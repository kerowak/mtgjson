package mtgjson

case class Set(
  code: String,
  name: String,
  releaseDate: String,
  isOnlineOnly: Boolean,
  isFoilOnly: Boolean,
  keyruneCode: String,
  baseSetSize: Int,
  totalSetSize: Int
)
