package controllers

import cask.model.{Request, Response}
import handler.{ClientApiHandler, OrderApiHandler}
import ujson.Value
import utils.ElasticsearchClient
import wvlet.log.LogSupport

object MainController extends cask.MainRoutes with LogSupport {
  info(s"Application running on port: ${this.port}")

  ElasticsearchClient.initializeElasticsearch()

  @cask.get("/client/:clientId")
  def getCustomer(clientId: String): Value = {
    ClientApiHandler.get(clientId)
  }

  @cask.post("/client")
  def createCustomer(request: Request): Response[Value] = {
    ClientApiHandler.create(request)
  }

  @cask.get("/order/:orderId")
  def getOrder(orderId: String): Value = {
    OrderApiHandler.get(orderId)
  }

  @cask.post("/order")
  def createOrder(request: Request): Response[Value] = {
    OrderApiHandler.create(request)
  }

  initialize()
}