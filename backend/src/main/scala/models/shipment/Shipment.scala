package models.shipment

import upickle.default.{ReadWriter, macroRW}

case class Shipment(
   
)

object Shipment {
  implicit val shipmentRW: ReadWriter[Shipment] = macroRW
}