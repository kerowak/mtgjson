package mtgjson

import akka.actor.ActorSystem

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import akka.stream.scaladsl.Sink
import akka.stream.scaladsl.Source

object Tool extends App {
  implicit val system = ActorSystem("name")
  val client = new MtgjsonClient

  import system.dispatcher

  val sets = Await.result(client.fetchSets
    .map(_.code)
    .runWith(Sink.seq), Duration.Inf)

  client.fetchCards
    .runWith(Sink.ignore)
    .flatMap(_ => system.terminate)
    .onComplete(_ => println("done"))
}
