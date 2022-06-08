package models.payment

import upickle.default.{ReadWriter, macroRW}

case class Payment(
  
)

object Payment {
    implicit val paymentRW: ReadWriter[Payment] = macroRW
}
