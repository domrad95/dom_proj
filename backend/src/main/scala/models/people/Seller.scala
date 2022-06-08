package models.people

import upickle.default.{ReadWriter, macroRW}

case class Seller(

)

object Seller  {
  implicit val sellerRW: ReadWriter[Seller] = macroRW
}
