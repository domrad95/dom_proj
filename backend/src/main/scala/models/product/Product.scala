package models.product

import upickle.default.{ReadWriter, macroRW}

case class Product(
  id: String,
  name: String,
  categories: Seq[Category],
  price: Double,
  image: String,
  description: String
) {

  def saveInDb(): Unit = {

  }
}

object Product {
  implicit val productRW: ReadWriter[Product] = macroRW
}