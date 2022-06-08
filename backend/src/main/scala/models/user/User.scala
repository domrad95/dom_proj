package models.user

import upickle.default._

case class User(

)

object User {
  implicit val userRW: ReadWriter[User] = macroRW
}