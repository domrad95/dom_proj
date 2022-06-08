package models.product

import upickle.default.{ReadWriter => RW, macroRW}

sealed trait Category

object Category {
    implicit val rw: RW[Category] = RW.merge(Alcohol().alcoholRW)

    case class Alcohol() extends Category {
        implicit val alcoholRW: RW[Alcohol] = macroRW
    }

    val values = Seq(Alcohol)
}