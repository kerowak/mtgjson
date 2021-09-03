package mtgjson

/**
 * Describes a single, oracle-like entity of a MTG card.
 *
 * [[https://mtgjson.com/file-models/card-atomic/]]
 *
 * @param name        - Full name of the card
 * @param identifiers - Various identifiers for external services
 * @param printings   - List of set codes (see [[Set]]) that this card is printed in
 */
case class Card(
  name:        String,
  identifiers: Map[Identifier, String],
  printings:   List[String] = Nil
)
