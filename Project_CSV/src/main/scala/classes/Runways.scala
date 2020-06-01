package classes

import scala.io.Source

case class Runways(id: Int, airport_ref: Int, airport_ident: String, len_ft: Int, width_ft: Int, surface: String, lited: Int,
                   closed: Int, le_ident: String) {

  def makeRunways(line: String): Option[Runways] = {

    val l = line.split(",")
    try {
      val id = l(0).toInt
      val airport_ref = l(1).toInt
      val airport_indent = l(2)
      val len_ft = l(3).toInt
      val width_ft = l(4).toInt
      val surface = l(5)
      val lited = l(6).toInt
      val closed = l(7).toInt
      val le_ident = l(8)
      Some(Runways(id, airport_ref, airport_indent, len_ft, width_ft, surface, lited, closed, le_ident))
    } catch {
      case e: Exception => None
    }
  }

  val filename_runways = "resources/runways.csv"
  val runways = Source.fromFile(filename_runways).getLines.map(makeRunways)
  runways.foreach(println)
}
