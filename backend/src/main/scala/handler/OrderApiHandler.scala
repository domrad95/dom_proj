package handler

import cask.model.Status.Created
import cask.{Request, Response}
import models.order.Order
import ujson.Value
import upickle.default._

object OrderApiHandler {

  def create(request: Request): Response[Value] = {
    val order = Order.createFromRequest(request)
    order.saveInEs()
    Response(
      data = writeJs[Order](order),
      statusCode = Created.code
    )
  }

  def get(clientId: String): Value = {
    val order = Order.getFromEs(clientId)
    writeJs[Order](order)
  }
}
