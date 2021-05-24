package mtgjson

import enumeratum.values.{StringCirceEnum, StringEnum, StringEnumEntry}

sealed abstract class Identifier(val value: String) extends StringEnumEntry
case object Identifier extends StringEnum[Identifier] with StringCirceEnum[Identifier] {
  val values = findValues

  case object CardKingdomFoilId      extends Identifier("cardKingdomFoilId")
  case object CardKingdomId          extends Identifier("cardKingdomId")
  case object McmId                  extends Identifier("mcmId")
  case object McmMetaId              extends Identifier("mcmMetaId")
  case object MtgArenaId             extends Identifier("mtgArenaId")
  case object MtgoId                 extends Identifier("mtgoId")
  case object MtgoFoilId             extends Identifier("mtgoFoilId")
  case object ScryfallOracleId       extends Identifier("scryfallOracleId")
  case object ScryfallId             extends Identifier("scryfallId")
  case object ScryfallIllustrationId extends Identifier("scryfallIllustrationId")
  case object TcgPlayerProductId     extends Identifier("tcgplayerProductId")
  case object MtgJsonV4Id            extends Identifier("mtgjsonV4Id")
  case object MultiverseId           extends Identifier("multiverseId")
}
