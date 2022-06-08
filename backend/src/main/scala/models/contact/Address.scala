package models.contact

import upickle.default.{ReadWriter, macroRW}

case class Address(
  city: String,
  street: String,
  postalCode: String,
  homeNumber: Int, 
  flatNumber: Option[Int] = None
)

object Address {
  implicit val addressRW: ReadWriter[Address] = macroRW
}