package mtgjson

/**
 * Describes the properties and values of an individual set
 * Includes static releases like duel decks and From the Vault
 *
 * [[https://mtgjson.com/file-models/set/]]
 *
 * @param name - Full name
 * @param code - Shortened identifier
 * @param releaseDate - Release date (ISO 8601)
 * @param isOnlineOnly - The set is only available online (MTGO, Arena)
 * @param isFoilOnly - The set is only available in foil (e.g From the Vault releases)
 * @param keyruneCode - Keyrune font code for [[https://keyrune.andrewgioia.com/]]
 * @param baseSetSize - Size of the set not including promos and other "extra" cards
 * @param totalSetSize - Total size of the set
 */
case class Set(
  name: String,
  code: String,
  releaseDate: String,
  isOnlineOnly: Boolean,
  isFoilOnly: Boolean,
  keyruneCode: String,
  baseSetSize: Int,
  totalSetSize: Int
)
