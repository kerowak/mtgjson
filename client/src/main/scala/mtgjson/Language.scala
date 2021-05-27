package mtgjson

import enumeratum.values.{StringCirceEnum, StringEnum, StringEnumEntry}

sealed abstract class Language(val value: String) extends StringEnumEntry
case object Language extends StringEnum[Language] with StringCirceEnum[Language] {
  val values = findValues

  case object AncientGreek       extends Language("Ancient Greek")
  case object Arabic             extends Language("Arabic")
  case object ChineseSimplified  extends Language("Chinese Simplified")
  case object ChineseTraditional extends Language("Chinese Traditional")
  case object French             extends Language("French")
  case object German             extends Language("German")
  case object Hebrew             extends Language("Hebrew")
  case object Italian            extends Language("Italian")
  case object Japanese           extends Language("Japanese")
  case object Korean             extends Language("Korean")
  case object Latin              extends Language("Latin")
  case object Phyrexian          extends Language("Phyrexian")
  case object Portuguese         extends Language("Portuguese (Brazil)")
  case object Russian            extends Language("Russian")
  case object Sanskrit           extends Language("Sanskrit")
  case object Spanish            extends Language("Spanish")
}