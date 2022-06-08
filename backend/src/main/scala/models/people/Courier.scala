package models.people

import models.order.Order
import upickle.default.{ReadWriter, macroRW}

case class Courier(
  orders: Seq[Order]
)

object Courier {
  implicit val courierRW: ReadWriter[Courier] = macroRW
}
