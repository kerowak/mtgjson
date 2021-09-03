package mtgjson

/**
 * Properties for various card data in alternate languages
 *
 * [[https://mtgjson.com/data-models/foreign-data/]]
 *
 * @param language - The language of this card
 * @param name     - Translation of the card's name into the target language
 */
case class ForeignData(language: Language, name: String)
