package Query

class Query {

  // Country
  val c = new classes.C
  val countries = c.l

  // Airports
  val a = new classes.A
  val airports = a.l

  // Runways
  val r = new classes.R
  val runways = r.runways


  /* read the input of the user */
  def read_input() = {
    println("Please enter a Country Name or a Country Code")
    val in = scala.io.StdIn.readLine()
    in
  }

  /* Check if input is a country code */
  def is_code_country(code: String): Boolean = {
    val f = countries.filter(e => e.get.code.contains(code))
    if (f.isEmpty)
      false
    true
  }


  /* Check if input is a country & partial match the name */
  def is_name_country(name: String): Boolean = {

    val f = countries.filter(e => e.get.name.contains(name))

    if (f.isEmpty)
      false

    if (f.size >= 2){
      println("Several Countries founded, do you mean ? :")
      f.foreach(e => println(e.get.name))
      val in = scala.io.StdIn.readLine()
      redisplay_airport(in: String)
    }
    true
  }

/*  if multiple coutries founded with partial name matching    */
  def redisplay_airport(input: String): Unit = {
    countries.foreach(i => {
      try {
        if (i.get.name.toString.contains(input)) {
          val code_c = i.get.code
          val run = runways.filter(e => !e.equals(None))
          val f_airports = airports.filter(e => !e.equals(None))
          val res = f_airports.filter(_.get.iso_country.equals(code_c))
          res.foreach(i => {
            val res2 = run.filter(_.get.airport_ident.equals(i.get.ident)).map(i => i.get.id)
            print(i.get.name + " => ")
            res2.foreach(j => print(j + " "))
            println("")
          })
        }
      }catch{
        case e: Exception => None
      }
    })
  }


  /* Display Airports Name & Runways id per airports */
  def display_airport_runways(input: String): Unit = {

      if (is_name_country(input)) {
        countries.foreach(i => {
          try {
            if (i.get.name.toString.contains(input)) {
              val code_c = i.get.code
              val run = runways.filter(e => !e.equals(None))
              val f_airports = airports.filter(e => !e.equals(None))
              val res = f_airports.filter(_.get.iso_country.equals(code_c))
              res.foreach(i => {
                val res2 = run.filter(_.get.airport_ident.equals(i.get.ident)).map(i => i.get.id)
                print(i.get.name + " => ")
                res2.foreach(j => print(j + " "))
                println("")
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
            print(i.get.name + " => ")
            res2.foreach(j =>  print(j + " "))
            println("")
            })
        }catch{
          case e: Exception => None
        }
      }
    }
}