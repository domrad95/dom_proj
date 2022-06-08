package handler

import cask.model.{Request, Response}
import cask.model.Status.Created
import models.people.Client
import ujson.Value
import upickle.default.writeJs

object ClientApiHandler {

  def get(clientId: String): Value = {
    val client = Client.getFromEs(clientId)
    writeJs[Client](client)
  }

  def create(request: Request): Response[Value] = {
    val client = Client.createFromRequest(request)
    client.saveInEs()
    Response(
      data = writeJs[Client](client),
      statusCode = Created.code
    )
  }

}
