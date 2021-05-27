package mtgjson

import enumeratum.values.{StringCirceEnum, StringEnum, StringEnumEntry}

sealed abstract class Availability(val value: String) extends StringEnumEntry
case object Availability extends StringEnum[Availability] with StringCirceEnum[Availability] {
  val values = findValues

  case object Paper     extends Availability("paper")
  case object Mtgo      extends Availability("mtgo")
  case object Arena     extends Availability("arena")
  case object Dreamcast extends Availability("dreamcast")
  case object Shandalar extends Availability("shandalar")
}