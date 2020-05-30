import scala.io.Source

object parser {

  val airports = Source.fromFile("airports.csv").getLines.map(_.split(",").toList)
  val id_airport = airports.map(x => List(x(1)))
  val name_airport = airports.map(x => List(x(4)))

  airports.map(x => List(x(1), x(2), x(3), x(4), x(5)))


  //peut etre un truc comme ca en combinant nos deux trucs.
  def parserfile(line: String): Option[Any] = {
    line.split(",").toList match {
      case List("nos datas") => Some(List("nos data"))
      case _ => None
    }
  }

  def readData(fileName:String): List[Any] = {
    val line = Source.fromFile(fileName).getLines.toList
    val data = parserfile(line) // probleme de type ici car line est de type list et non de type string
  }
}



