import scala.io.Source

object parser {

  val airports = Source.fromFile("airports.csv").getLines.map(_.split(",").toList)
  // la ligne en dessous permet de dire je veux recuper tel et tel colonne du fichier csv.
  airports.map(x => List(x(1), x(2), x(3), x(4), x(5)))
}

def parser(line: String): Option[Any] = {
    line.map(_.split(",").toList) match {
        case List(nos datas) => Some(List(nos data))
        case _ => None
    }
}

def readData(fileName:String): List[Any] = {
    val line = Source.fromFile(filename).getLines.toList
    val data = parseCsvLine(line)
}
