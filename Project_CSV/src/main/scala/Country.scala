import scala.io.Source




class Country{

  def print_data(l: List[Any]) = println(l)
  def get_code() = country.code
  def get_name() = country.name
}

object country{
  val filename_countries = "resources/countries.csv"
  val countries = Source.fromFile(filename_countries).getLines.map(_.split(",").toList)
  //val stock = airports.map(x => List(x(1), x(2), x(3), x(4), x(5)))
  val id = countries.map(x => List(x(1))).toList
  val code = countries.map(x => List(x(2))).toList
  val name = countries.map(x => List(x(3))).toList
  val continent = countries.map(x => List(x(4))).toList
  val wikipedia_link = countries.map(x => List(x(5))).toList
  val keyword = countries.map(x => List(x(6))).toList
}
