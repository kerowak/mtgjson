package mtgjson

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import akka.stream.scaladsl.Sink
import akka.stream.scaladsl.Source
import mtgjson.Identifier.{ScryfallId, ScryfallIllustrationId, ScryfallOracleId, TcgPlayerProductId}

object Tool extends App {
  implicit val system = ActorSystem(Behaviors.empty, "tool")
  val client = new MtgjsonClient

  import system.executionContext

  val printings = Await.result(client.getCards()
    .runWith(Sink.seq), Duration.Inf)

  println(printings.size)

  println(printings.count(_.identifiers.contains(ScryfallOracleId)))
  println(printings.count(_.identifiers.contains(ScryfallId)))
  println(printings.count(_.identifiers.contains(ScryfallIllustrationId)))
  println(printings.count(_.identifiers.contains(TcgPlayerProductId)))
  system.terminate()
}
