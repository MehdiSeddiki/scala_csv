package classes

import scala.io.Source

class C {

  case class Countries(id: Int, code: String, name: String, continent: String, wikipedia_link: String, keyword: Option[String] = None)


    def makeCountry(line: String): Option[Countries] = {

      val l = line.split(",")
      try {
        val id_c = l(0).toInt
        val code = l(1)
        val name = l(2)
        val continent = l(3)
        val wikipedia_link = l(4)
        if (l(4) == l.last)
          Some(Countries(id_c, code, name, continent, wikipedia_link, None))
        else
          Some(Countries(id_c, code, name, continent, wikipedia_link, Some(l(5))))
      } catch {
        case e: Exception => None
      }
    }

    val filename_countries = "resources/countries.csv"
    val countries = Source.fromFile(filename_countries).getLines.map(makeCountry).toList
    val l = countries.tail
    //println(l)

}
