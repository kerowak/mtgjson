package mtgjson

import java.util.UUID

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