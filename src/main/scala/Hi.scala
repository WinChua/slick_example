import slick.driver.MySQLDriver.api._
import scala.concurrent.ExecutionContext.Implicits.global
import test._
import scala.io.Source
object Hi extends App {
	/*println("Hi People!")
	println(System.getProperty("user.dir"))
	val file = Source.fromFile("application.conf")
	file.getLines.foreach(println)*/
	//val db = Database.forConfig("mysql")
	val db = Database.forConfig("mysql")
	try {
		val insert = DBIO.seq(
          Tables.Person += (Tables.PersonRow(0,"WinChua","13660270454",23)),
          Tables.Person += (Tables.PersonRow(1,"CaiJia","13172559443",22))
		)
		db.run(insert)
	} finally db.close
	
}