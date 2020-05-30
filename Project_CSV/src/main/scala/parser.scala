import scala.io.Source
/* j'ai cherche des trucs mais je n'arrive pas a voir comment ca va se profiler. Si j'ai bien compris, on parse les 3 fichiers
, j'ai recupere les colonnes du nom du pays ou de son code. Apres je ne vois pas ce qu'il faut faire. Pour la BDD j'ai pas reussi
a trouve comment on faisait sans spark et pour les classe mutable, on pourrai faire correspondre un attribut(List[le type associe])
à une colonne de notre fichier csv
 */
object parser {

  val airports = Source.fromFile("airports.csv").getLines.map(_.split(",").toList)
  val countries = Source.fromFile("countries.csv").getLines.map(_.split(",").toList)
  val runways = Source.fromFile("runways.csv").getLines.map(_.split(",").toList)

  val id_airport = airports.map(x => List(x(1)))
  val name_airport = airports.map(x => List(x(4)))// si j'ai bien comrpis, je recupere la 4eme colonnes de airports
  //mais si je veux travailler dessus je ne vois pas comment faire
  val name_country = countries.map(x => List(x(3)))
  val code_country = countries.map(x => List(x(2)))
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







