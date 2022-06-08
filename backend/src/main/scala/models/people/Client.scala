package models.people
import cask.model.Request
import models.contact._
import models.people.Client.clientIndexName
import ujson.Value
import upickle.default._
import utils.ElasticsearchClient

import java.util.UUID

case class Client(
  id: String,
  name: String,
  lastName: String,
  email: Email,
  phoneNumber: PhoneNumber,
  address: Address
) {

  def saveInEs(): Unit = {
    ElasticsearchClient.save(writeJs(this), clientIndexName, id)
  }
}

object Client {
  implicit val clientRW: ReadWriter[Client] = macroRW

  val clientIndexName = "clients_v1"

  def getFromEs(clientId: String): Client = {
    val json = ElasticsearchClient.get(clientId, clientIndexName)
    read[Client](json)
  }

  def createFromRequest(request: Request): Client = {
    val json = read[Value](request.text)
    json.obj("id") = UUID.randomUUID().toString
    read[Client](json)
  }
}
