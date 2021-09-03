package mtgjson

import java.util.UUID

/**
 * Represents a card, as printed in a set.
 *
 * Effectively a tuple of [[Card]] and [[Set]], with some additional
 * data to describe that union.
 *
 * [[https://mtgjson.com/data-models/card-set/]]
 *
 * @param name         - Full name of the card
 * @param setCode      - The set this card belongs to
 * @param hasFoil      - This card has a foil variation
 * @param hasNonFoil   - This card has a nonfoil variation
 * @param availability - The card's appearance in Paper/other platforms
 * @param identifiers  - Various identifiers for other services
 * @param frameEffects - All nonstandard frame effects applied to this printing
 * @param foreignData  - Language variations
 * @param uuid         - MTGJSON uuid for this Card (Set)
 */
case class Printing(
  name: String,
  setCode: String,
  hasFoil: Boolean,
  hasNonFoil: Boolean,
  availability: List[Availability],
  identifiers: Map[Identifier, String],
  frameEffects: List[FrameEffect] = Nil,
  foreignData: List[ForeignData] = Nil,
  uuid: UUID,
)