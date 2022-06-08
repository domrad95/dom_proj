package models.contact

import upickle.default.{ReadWriter, macroRW}

case class Email(
  address: String
)

object Email {
  implicit val emailRW: ReadWriter[Email] = macroRW
}