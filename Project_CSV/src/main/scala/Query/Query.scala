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
          if (i.get.name.toString.contains(input)) {
            val code_c = i.get.code
            val run = runways.filter(e => !e.equals(None))
            val f_airports = airports.filter(e => !e.equals(None))
            f_airports.foreach(i => {
              run.foreach(j => {
                if (i.get.iso_country.contains(code_c)) {
                  print(i.get.name + " , ")
                  i.get.id.equals(j.get.airport_ref)
                  println(j.get.id)
                }
              })
            })
          }
        })
      }
      if (is_code_country(input)) {
        try {
        val run = runways.filter(e => !e.equals(None))
        val f_airports = airports.filter(e => !e.equals(None))
        f_airports.foreach(i => {
          run.foreach(j => {
            if (i.get.iso_country.contains(input)) {
              print(i.get.name + " , ")
              i.get.id.equals(j.get.airport_ref)
              println(j.get.id)
            }
          })
        })
        }catch{
          case e: Exception => None
        }
      }
    }
}