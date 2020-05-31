/*
package csv_main

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
                case "1" => println("Please type a country name or its code")
                case "2" => main(args)
              }
          }
          case "R" => {
            println("1. Country with the Highest number of airports & Lowest number o
 airports")
            println("2. Type of runways per country")
            println("3. Top 10 common runway latitude")
            println("4. Step Back (B)")
            Iterator.continually(io.StdIn.readLine)
              .foreach {
                case "1" => {
                  println("you chose Highest nb")
                  main(args)
                }
                case "2" => {
                  println(" you choose type of runways")
                  main(args)
                }
                case "3" => {
                  println("you choose 10 common runway latitude")
                  main(args)
                  }
                case "B" => main(args)
                case _ => println("Bad choice, try again !")

                }
              }
          case "E" => System.exit(0)
          case _ => println("Bad choice try again !")
        }
  }*/

