package Query

class Query {

  // For Country
  val c = new classes.C
  val filename_country = c.filename_countries
  val countries = c.l

  // For Airports
  val a = new classes.A
  val filename_airport = a.filename_airport
  val airports = a.l

  //For Runways
  val r = new classes.R
  val file = r.filename_runways
  val runways = r.runways


  def read_input() = {
    println("Please enter a Country Name or a Country Code")
    val in = scala.io.StdIn.readLine()
    in
  }

  def is_code_country(code: String): Boolean = {
    val f = countries.filter(e => e.get.code.contains(code))
    if (f.isEmpty)
      false
    true
  }

  def is_name_country(name: String): Boolean = {

    val f = countries.filter(e => e.get.name.contains(name))
    if (f.isEmpty)
      false
    true
  }

  def display_airport_runways(input: String): Unit = {

      if (is_name_country(input)) {
        countries.foreach(i => {
          try {
            if (i.get.name.toString.contains(input)) {
              val code_c = i.get.code
              val run = runways.filter(e => !e.equals(None))
              val f_airports = airports.filter(e => !e.equals(None))
              val res = f_airports.filter(_.get.iso_country.contains(code_c))
              res.foreach(i => {
                val res2 = run.filter(_.get.airport_ident.equals(i.get.ident)).map(i => i.get.id)
                println(i.get.name + " , " + res2)
              })
            }
          }catch{
            case e: Exception => None
          }
        })
      }
      if (is_code_country(input)) {
        try {
        val run = runways.filter(e => !e.equals(None))
        val f_airports = airports.filter(e => !e.equals(None))
          val res = f_airports.filter(_.get.iso_country.contains(input))
          res.foreach(i => {
            val res2 = run.filter(_.get.airport_ident.equals(i.get.ident)).map(i => i.get.id)
            println(i.get.name + " , " + res2)
          })
        }catch{
          case e: Exception => None
        }
      }
    }
}