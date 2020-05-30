import scala.io.Source

class x {


  def affiche(l: List[Any]) = {
    l.foreach(i => println(i))
  }
}

object q {
  val filename_airport = "resources/airports.csv"
  val airports = Source.fromFile(filename_airport).getLines.map(_.split(",").toList)
  val stock = airports.map(x => List(x(1), x(2), x(3), x(4), x(5)))
  def main(args: Array[String]): Unit = {
    val obj = new x
    obj.affiche(airports.toList)

  }
}