import scala.io.Source
/* j'ai cherche des trucs mais je n'arrive pas a voir comment ca va se profiler. Si j'ai bien compris, on parse les 3 fichiers
, j'ai recupere les colonnes du nom du pays ou de son code. Apres je ne vois pas ce qu'il faut faire. Pour la BDD j'ai pas reussi
a trouve comment on faisait sans spark et pour les classe mutable, on pourrai faire correspondre un attribut(List[le type associe])
à une colonne de notre fichier csv
 */
class parser {

  val filename_airport = "airports.csv"
  val filename_country = "countries.csv"
  val filename_runaway = "runways.csv"
  
  val airports = Source.fromFile(filename_airport).getLines.map(_.split(",").toList)
  val countries = Source.fromFile(filename_country).getLines.map(_.split(",").toList)
  val runways = Source.fromFile(filename_runaway).getLines.map(_.split(",").toList)

  val id_airport = airports.map(x => List(x(1)))
  val name_airport = airports.map(x => List(x(4)))// si j'ai bien comrpis, je recupere la 4eme colonnes de airports
  //mais si je veux travailler dessus je ne vois pas comment faire
  val name_country = countries.map(x => List(x(3)))
  val code_country = countries.map(x => List(x(2)))
  airports.map(x => List(x(1), x(2), x(3), x(4), x(5)))

  def printperso(l: List[Any]) = println(l)
  def aff(l: List[Any]) = println(airports.map(x => List(x(1), x(2), x(3), x(4), x(5)))
  )

  //1 objet par fichiers csv
  //une classe storing dans laquelle on instancie les les objets de la classe parser
  //
}







