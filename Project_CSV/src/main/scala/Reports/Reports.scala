package Reports

import scala.collection.immutable.ListMap

class Reports {
  // Country
  val c = new classes.C
  val countries = c.l

  //  Airports
  val a = new classes.A
  val airports = a.l

  // Runways
  val r = new classes.R
  val runways = r.runways


  def most_commom_runway_latitude(): Unit =
  {
    val f_countries = runways.filter(e => !e.equals(None))
    val res = f_countries.sortBy(_.get.le_ident).groupBy(_.get.le_ident).mapValues(_.size)
    val c = ListMap(res.toSeq.sortWith(_._2 > _._2):_*).take(10)
    println("Most common runway altitude are :")
    c.foreach(i =>  println(i))
  }

  def runways_per_country(): Unit = {
    val f_countries = countries.filter(e => !e.equals(None))
    val f_runways = runways.filter(e => !e.equals(None))
    val f_airports = airports.filter(e => !e.equals(None))
    f_countries.foreach(i => {
      val code = i.get.code
      val res = f_airports.filter(_.get.iso_country.contains(code))
      res.foreach(j => {
        val res2 = f_runways.filter(_.get.airport_ident.equals(j.get.ident)).map(i => i.get.surface)
        val iso_country = j.get.iso_country
       if (iso_country == code && !res2.equals(Nil))
          println(i.get.name + " , ", res2)
      })
    })
  }


  def highest_countries_airport(): Unit = {
    val f_airports = airports.filter(e => !e.equals(None))
    val f_countries = countries.filter(e => !e.equals(None))

    println("Countries with the Highest number of airports :")
    println("")
    //TOP 10
    val res = f_airports.groupBy(_.get.iso_country).mapValues(_.size).toList
    val res2 = ListMap(res.toSeq.sortWith(_._2 > _._2):_*).take(10)
    res2.foreach(i =>
      {
        val countries_name = f_countries.filter(_.get.code.contains(i._1))
        countries_name.foreach( j => {
          print(j.get.name + " => ")
          println(i._2)
        })
      })

    println("\n--------------------------------------------------")
    println("Countries with the Lowest number of airports :\n")

    //TOP -10
    val f = f_airports.groupBy(_.get.iso_country).mapValues(_.size).toList
    val f2 = ListMap(f.toSeq.sortWith(_._2 < _._2):_*).take(10)
    f2.foreach(i =>
    {
      val countries_name = f_countries.filter(_.get.code.contains(i._1))
      countries_name.foreach( j => {
        print(j.get.name + " => ")
        println(i._2)
      })
    })
    println("")
  }
}
