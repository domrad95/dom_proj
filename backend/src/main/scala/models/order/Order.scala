package models.order

import cask.model.Request
import models.order.Order.orderIndexName
import models.payment.Payment
import models.people.Client
import models.product.Product
import models.shipment.Shipment
import upickle.default._
import utils.ElasticsearchClient

case class Order(
  id: String,
  client: Client,
  products: Iterable[Product],
  state: OrderState,
  payment: Payment,
  shipment: Shipment
) {

  def saveInEs(): Unit = {
    ElasticsearchClient.save(writeJs(this), orderIndexName, id)
  }
}

object Order {

  implicit val orderRW: ReadWriter[Order] = macroRW

  val orderIndexName = "order_v1"

  def createFromRequest(request: Request): Order = {
    read[Order](request.text)
  }

  def getFromEs(id: String): Order = {
    val json = ElasticsearchClient.get(id, orderIndexName)
    read[Order](json)
  }

}