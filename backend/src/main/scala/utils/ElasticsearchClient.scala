package utils

import models.order.Order
import models.people.Client
import ujson.{Obj, Value}
import upickle.default._
import wvlet.log.LogSupport

object ElasticsearchClient extends LogSupport {

  val elasticsearchHost = "http://localhost:9200"

  def save(json: Value, indexName: String, id: String) = {
    requests.post(elasticsearchHost + "/" + indexName + "/_doc/" + id, data = json)
  }

  def get(id: String, indexName: String): Value = {
    val doc = requests.get(elasticsearchHost + "/" + indexName + "/_doc/" + id)
    read[Value](doc.text).obj("_source")
  }

  def createIndexIfNotExist(indexName: String): Unit = {
    val response = requests.put(elasticsearchHost + "/" + indexName, check = false)
    val msg = if (response.text.contains("resource_already_exists_exception")) " - index already exists" else ""
    info(s"Index creation status for index $indexName: " + response.statusCode + msg)
  }

  def initializeElasticsearch(): Unit = {
    createIndexIfNotExist(Order.orderIndexName)
    createIndexIfNotExist(Client.clientIndexName)
  }
}
