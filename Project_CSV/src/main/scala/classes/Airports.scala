package classes

import scala.io.Source

case class Airports(id: Int, ident: String, type_ : String, name: String, latitude_deg: Double, longitude_deg: Double,
                    elevation_ft: Double, continent: String, iso_country: String, iso_region: String) {


  def makeAirport(line: String): Option[Airports] = {
    val l = line.split(",")
    try {
      val id = l(0).toInt
      val ident = l(1)
      val type_ = l(2)
      val name = l(3)
      val latitude_deg = l(4).toDouble
      val longitude_deg = l(5).toDouble
      val elevation_ft = l(6).toDouble
      val continent = l(7)
      val iso_country = l(8)
      val iso_region = l(9)
      Some(Airports(id, ident, type_, name, latitude_deg, longitude_deg, elevation_ft, continent, iso_country, iso_region))
    } catch {
      case e: Exception => None
    }
  }

  val filename_countries = "resources/airports.csv"
  val airports = Source.fromFile(filename_countries).getLines.map(makeAirport)
  airports.foreach(println)
}
