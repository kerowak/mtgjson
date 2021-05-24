package mtgjson

import enumeratum.values.{StringCirceEnum, StringEnum, StringEnumEntry}

sealed abstract class FrameEffect(val value: String) extends StringEnumEntry
case object FrameEffect extends StringEnum[FrameEffect] with StringCirceEnum[FrameEffect] {
  val values = findValues

  case object ColorShifted           extends FrameEffect("colorshifted")
  case object Companion              extends FrameEffect("companion")
  case object CompassLandDFC         extends FrameEffect("compasslanddfc")
  case object Devoid                 extends FrameEffect("devoid")
  case object Draft                  extends FrameEffect("draft")
  case object Etched                 extends FrameEffect("etched")
  case object ExtendedArt            extends FrameEffect("extendedart")
  case object FullArt                extends FrameEffect("fullart")
  case object Inverted               extends FrameEffect("inverted")
  case object Legendary              extends FrameEffect("legendary")
  case object Miracle                extends FrameEffect("miracle")
  case object MoonEldraziDFC         extends FrameEffect("mooneldrazidfc")
  case object NyxBorn                extends FrameEffect("nyxborn")
  case object NyxTouched             extends FrameEffect("nyxtouched")
  case object OrgiginPWDFC           extends FrameEffect("originpwdfc")
  case object Showcase               extends FrameEffect("showcase")
  case object Snow                   extends FrameEffect("snow")
  case object SunMoonDFC             extends FrameEffect("sunmoondfc")
  case object Tombstone              extends FrameEffect("tombstone")
  case object WaxingAndWaningMoonDFC extends FrameEffect("waxingandwaningmoondfc")
}

