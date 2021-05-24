package mtgjson

import java.util.UUID

case class Card(
  name:        String,
  identifiers: Map[Identifier, String],
  printings:   List[String] = Nil
)
