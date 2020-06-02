package Reports

import scala.collection.immutable.ListMap

class Reports {
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


  def most_commom_runway_latitude(): Unit =
  {
    val f_countries = runways.filter(e => !e.equals(None))
    val res = f_countries.sortBy(_.get.le_ident).groupBy(_.get.le_ident).mapValues(_.size)
    val c = ListMap(res.toSeq.sortWith(_._2 > _._2):_*).take(10)

    c.foreach(i =>  println(i))
  }

  def highest_countries_airport(): Unit = {
    val f_airports = airports.filter(e => !e.equals(None))
    val f_countries = countries.filter(e => !e.equals(None))
   // val res = f_countries.sortBy(_.get.name).groupBy(_.get.name).mapValues(_.size)
    //val res2 = f_airports.collect(_.get.iso_country)
    //if (f_countries.collect(_.get.code).contains(f_airports.collect(_.get.iso_country)))


    /*f_airports.foreach(i => {
      f_countries.foreach(j => {
        if (i.get.iso_country.contains(j.get.code))
          println(j.get.name)
      })
    })*/
    //res.foreach(i => println(i))
  }


}
