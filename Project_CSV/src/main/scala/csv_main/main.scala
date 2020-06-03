import scala.io.Source
package csv_main{}
package classes{}
package Query{}

object main {

  def menu(): Unit = {
    println("Q. Query")
    println("R. Reports")
    println("E. Exit the program")
    Iterator.continually(io.StdIn.readLine)
      .foreach {
        case "Q" => {
          menu_query()
        }
        case "R" => {
          menu_reports()
        }
        case "E" => System.exit(0)
        case _ => println("Bad choice try again !")
      }
  }

  def menu_query():Unit = {
    val q = new Query.Query
    println("1. Display the airports & runways at each airports")
    println("2. Step Back")
    Iterator.continually(io.StdIn.readLine)
      .foreach {
        case "1" => {
          val in = q.read_input()
          q.display_airport_runways(in)
          menu()
        }
        case "2" => menu()
        case _ => println("Bad choice, try again !")
      }
  }
  def menu_reports():Unit = {
    println("1. Highest/Lowest numbers of airport per country")
    println("2. Type of runways per country")
    println("3. Most common runway latitude")
    println("4. Step Back")
    val r = new Reports.Reports
    Iterator.continually(io.StdIn.readLine)
      .foreach {
        case "1" => {
          r.highest_countries_airport()
          menu()
        }
        case "2" => {
          r.runways_per_country()
          menu()
        }
        case "3" => {
          r.most_commom_runway_latitude()
          menu()
        }
        case "4" => menu()
        case _ => println("Bad choice, try again !")
      }
  }

  def main(args: Array[String]): Unit = {
    menu()
  }
}