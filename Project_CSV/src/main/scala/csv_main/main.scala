import scala.io.Source
package csv_main{}
package classes{}
package Query{}

object main {
  def main(args: Array[String]): Unit = {
    println("Q. Query")
    println("R. Reports")
    println("E. Exit the program")
    Iterator.continually(io.StdIn.readLine)
      .foreach {
        case "Q" => {
          println("1. Display the airports & runways at each airports")
          println("2. Step Back")
          Iterator.continually(io.StdIn.readLine)
            .foreach {
              case "1" => {
                val q = new Query.Query
                val in = q.read_input()
                if (q.is_code_country(in))
                  q.display_airport_runways(in)
                else
                  println("false")
                main(args)
              }
              case "2" => main(args)
            }
        }
        case "R" => {
          println("1. Country with the Highest number of airports & Lowest number o airports")
          println("2. Type of runways per country")
          println("3. Top 10 common runway latitude")
          println("4. Step Back (B)")
          val r = new Reports.Reports

          Iterator.continually(io.StdIn.readLine)
            .foreach {
              case "1" => {
                r.highest_countries_airport()
                main(args)
              }
              case "2" => {
                r.runways_per_country()
                main(args)
              }
              case "3" => {
                r.most_commom_runway_latitude()
                main(args)
              }
              case "B" => main(args)
              case _ => println("Bad choice, try again !")
            }
        }
        case "E" => System.exit(0)
        case _ => println("Bad choice try again !")
      }
  }
}