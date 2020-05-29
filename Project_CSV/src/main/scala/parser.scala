import scala.io.Source

object parser {

  val airports = Source.fromFile("airports.csv").getLines.map(_.split(",").toList)
  // la ligne en dessous permet de dire je veux recuper tel et tel colonne du fichier csv.
  airports.map(x => List(x(1), x(2), x(3), x(4), x(5)))
}