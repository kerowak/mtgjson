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

  val printings = Await.result(client.getPrintings()
    .filter(_.frameEffects.size > 1)
    .map {printing =>
      println(printing.frameEffects)
      printing
    }
    .runWith(Sink.seq), Duration.Inf)

  println(printings.size)
  system.terminate()
}
