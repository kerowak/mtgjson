package mtgjson

import akka.http.scaladsl.client.RequestBuilding.Get
import akka.actor.typed.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.scaladsl.Source
import akka.stream.alpakka.json.scaladsl.JsonReader
import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.StatusCodes._
import akka.util.ByteString

import io.circe.parser.decode
import io.circe.Decoder
import io.circe.generic.extras.auto._
import io.circe.generic.extras.Configuration

class MtgjsonClient(implicit val system: ActorSystem[_]) {

  implicit val circeConfig: Configuration = Configuration.default.withDefaults
  val http = Http()

  private def extractEntityData(response: HttpResponse) =
      response match {
        case HttpResponse(OK, _, entity, _) => entity.dataBytes
        case notOk =>
          Source.failed(new RuntimeException(s"illegal response $notOk"))
      }

  private def toJson[T](msg: ByteString)(implicit decoder: Decoder[T]) =
    decode[T](msg.utf8String)

  private def stream[T](uri: String)(implicit decoder: Decoder[T]) =
    Source
      .single(Get(uri))
      .mapAsync(1)(http.singleRequest(_))
      .flatMapConcat(extractEntityData)
      .via(JsonReader.select("$.data[*]"))
      .map(toJson[T])
      .map {
        case Left(err) => throw err
        case Right(value) => value
      }

  def getPrintings(): Source[Printing, _] =
    stream[Printing]("https://mtgjson.com/api/v5/AllIdentifiers.json")

  def getCards(): Source[Card,_] = {
    stream[Seq[Card]]("https://mtgjson.com/api/v5/AtomicCards.json")
      .map(_.head) // We're just gonna ignore multi-faced cards for now...
  }

  def getSets(): Source[mtgjson.Set, _] =
    stream[mtgjson.Set]("https://mtgjson.com/api/v5/SetList.json")

}
