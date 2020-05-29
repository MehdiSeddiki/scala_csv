package csv_main

object main {

  def main(args: Array[String]): Unit = {
      println("1. Query (Q)")
      println("2. Reports (R)")
      println("3. Exit the program (E)")
      Iterator.continually(io.StdIn.readLine)
        .takeWhile(_ != "E")
        .foreach{
          case "Q" => println("Query selectionned")
          case "R" => println("Reports selectionned")
          case _  => println("Bad choice, try again !")
        }
  }
}
