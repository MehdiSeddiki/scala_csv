import scala.io.Source

object main{

  def main(args: Array[String]): Unit = {


    case class Countries(id: Int, code: String, name: String, continent: String, wikipedia_link: String, keyword: Option[String] = None)

    def makeCountry(line: String): Option[Countries] = {

      val l = line.split(",")
      try {
        val id = l(0).toInt
        val code = l(1)
        val name = l(2)
        val continent = l(3)
        val wikipedia_link = l(4)
        val keyword = l(5)
        Some(Countries(id, code, name,  continent, wikipedia_link, Some(keyword)))
      }catch{
        case e: Exception => None
      }
    }
    val filename_countries = "resources/countries.csv"
    val countries = Source.fromFile(filename_countries).getLines.map(makeCountry)
    countries.foreach(println)
  }

}
