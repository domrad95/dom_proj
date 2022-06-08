package models.contact

import upickle.default.{ReadWriter, macroRW}

case class PhoneNumber(
  number: String
)

object PhoneNumber {
  implicit val phoneNumberRW: ReadWriter[PhoneNumber] = macroRW
}