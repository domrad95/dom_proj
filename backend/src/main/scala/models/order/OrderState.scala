package models.order

import upickle.default._

sealed trait OrderState

object OrderState {
  implicit val orderStateRW: ReadWriter[OrderState] = ReadWriter.merge(Placed().placedRW, InShipment().inShipmentRW)

  case class Placed() extends OrderState {
    implicit val placedRW: ReadWriter[Placed] = macroRW
  }

  case class InShipment() extends OrderState {
    implicit val inShipmentRW: ReadWriter[InShipment] = macroRW
  }

  val values = Seq(Placed, InShipment)
}