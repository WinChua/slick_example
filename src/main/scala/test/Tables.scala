package test
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(Director.schema, Expert.schema, ExpertTablename.schema, File.schema, MyView.schema, Person.schema, T1.schema, T2.schema, Tablename.schema, Test.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Director
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param parent Database column parent SqlType(INT)
   *  @param dirName Database column dir_name SqlType(CHAR), Length(128,false) */
  case class DirectorRow(id: Int, parent: Int, dirName: String)
  /** GetResult implicit for fetching DirectorRow objects using plain SQL queries */
  implicit def GetResultDirectorRow(implicit e0: GR[Int], e1: GR[String]): GR[DirectorRow] = GR{
    prs => import prs._
    DirectorRow.tupled((<<[Int], <<[Int], <<[String]))
  }
  /** Table description of table Director. Objects of this class serve as prototypes for rows in queries. */
  class Director(_tableTag: Tag) extends Table[DirectorRow](_tableTag, "Director") {
    def * = (id, parent, dirName) <> (DirectorRow.tupled, DirectorRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(parent), Rep.Some(dirName)).shaped.<>({r=>import r._; _1.map(_=> DirectorRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column parent SqlType(INT) */
    val parent: Rep[Int] = column[Int]("parent")
    /** Database column dir_name SqlType(CHAR), Length(128,false) */
    val dirName: Rep[String] = column[String]("dir_name", O.Length(128,varying=false))
  }
  /** Collection-like TableQuery object for table Director */
  lazy val Director = new TableQuery(tag => new Director(tag))

  /** Entity class storing rows of table Expert
   *  @param eid Database column eid SqlType(INT), AutoInc, PrimaryKey
   *  @param expertname Database column expertname SqlType(CHAR), Length(16,false), Default(Some())
   *  @param bumeng Database column bumeng SqlType(CHAR), Length(32,false), Default(Some()) */
  case class ExpertRow(eid: Int, expertname: Option[String] = Some(""), bumeng: Option[String] = Some(""))
  /** GetResult implicit for fetching ExpertRow objects using plain SQL queries */
  implicit def GetResultExpertRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[ExpertRow] = GR{
    prs => import prs._
    ExpertRow.tupled((<<[Int], <<?[String], <<?[String]))
  }
  /** Table description of table Expert. Objects of this class serve as prototypes for rows in queries. */
  class Expert(_tableTag: Tag) extends Table[ExpertRow](_tableTag, "Expert") {
    def * = (eid, expertname, bumeng) <> (ExpertRow.tupled, ExpertRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(eid), expertname, bumeng).shaped.<>({r=>import r._; _1.map(_=> ExpertRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column eid SqlType(INT), AutoInc, PrimaryKey */
    val eid: Rep[Int] = column[Int]("eid", O.AutoInc, O.PrimaryKey)
    /** Database column expertname SqlType(CHAR), Length(16,false), Default(Some()) */
    val expertname: Rep[Option[String]] = column[Option[String]]("expertname", O.Length(16,varying=false), O.Default(Some("")))
    /** Database column bumeng SqlType(CHAR), Length(32,false), Default(Some()) */
    val bumeng: Rep[Option[String]] = column[Option[String]]("bumeng", O.Length(32,varying=false), O.Default(Some("")))
  }
  /** Collection-like TableQuery object for table Expert */
  lazy val Expert = new TableQuery(tag => new Expert(tag))

  /** Entity class storing rows of table ExpertTablename
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param tid Database column tid SqlType(INT), Default(None)
   *  @param eid Database column eid SqlType(INT), Default(None)
   *  @param adds Database column adds SqlType(CHAR), Length(255,false)
   *  @param `type` Database column type SqlType(CHAR), Length(10,false) */
  case class ExpertTablenameRow(id: Int, tid: Option[Int] = None, eid: Option[Int] = None, adds: String, `type`: String)
  /** GetResult implicit for fetching ExpertTablenameRow objects using plain SQL queries */
  implicit def GetResultExpertTablenameRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[String]): GR[ExpertTablenameRow] = GR{
    prs => import prs._
    ExpertTablenameRow.tupled((<<[Int], <<?[Int], <<?[Int], <<[String], <<[String]))
  }
  /** Table description of table expert_tablename. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class ExpertTablename(_tableTag: Tag) extends Table[ExpertTablenameRow](_tableTag, "expert_tablename") {
    def * = (id, tid, eid, adds, `type`) <> (ExpertTablenameRow.tupled, ExpertTablenameRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), tid, eid, Rep.Some(adds), Rep.Some(`type`)).shaped.<>({r=>import r._; _1.map(_=> ExpertTablenameRow.tupled((_1.get, _2, _3, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column tid SqlType(INT), Default(None) */
    val tid: Rep[Option[Int]] = column[Option[Int]]("tid", O.Default(None))
    /** Database column eid SqlType(INT), Default(None) */
    val eid: Rep[Option[Int]] = column[Option[Int]]("eid", O.Default(None))
    /** Database column adds SqlType(CHAR), Length(255,false) */
    val adds: Rep[String] = column[String]("adds", O.Length(255,varying=false))
    /** Database column type SqlType(CHAR), Length(10,false)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[String] = column[String]("type", O.Length(10,varying=false))

    /** Index over (eid) (database name eid_ibfk_2) */
    val index1 = index("eid_ibfk_2", eid)
    /** Index over (tid) (database name tid_ibfk_1) */
    val index2 = index("tid_ibfk_1", tid)
  }
  /** Collection-like TableQuery object for table ExpertTablename */
  lazy val ExpertTablename = new TableQuery(tag => new ExpertTablename(tag))

  /** Entity class storing rows of table File
   *  @param fid Database column fid SqlType(INT), AutoInc, PrimaryKey
   *  @param id Database column id SqlType(INT)
   *  @param path Database column path SqlType(CHAR), Length(128,false) */
  case class FileRow(fid: Int, id: Int, path: String)
  /** GetResult implicit for fetching FileRow objects using plain SQL queries */
  implicit def GetResultFileRow(implicit e0: GR[Int], e1: GR[String]): GR[FileRow] = GR{
    prs => import prs._
    FileRow.tupled((<<[Int], <<[Int], <<[String]))
  }
  /** Table description of table File. Objects of this class serve as prototypes for rows in queries. */
  class File(_tableTag: Tag) extends Table[FileRow](_tableTag, "File") {
    def * = (fid, id, path) <> (FileRow.tupled, FileRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(fid), Rep.Some(id), Rep.Some(path)).shaped.<>({r=>import r._; _1.map(_=> FileRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column fid SqlType(INT), AutoInc, PrimaryKey */
    val fid: Rep[Int] = column[Int]("fid", O.AutoInc, O.PrimaryKey)
    /** Database column id SqlType(INT) */
    val id: Rep[Int] = column[Int]("id")
    /** Database column path SqlType(CHAR), Length(128,false) */
    val path: Rep[String] = column[String]("path", O.Length(128,varying=false))

    /** Index over (id) (database name id) */
    val index1 = index("id", id)
  }
  /** Collection-like TableQuery object for table File */
  lazy val File = new TableQuery(tag => new File(tag))

  /** Entity class storing rows of table MyView
   *  @param i1 Database column i1 SqlType(INT), Default(None)
   *  @param c1 Database column c1 SqlType(CHAR), Length(11,false), Default(None)
   *  @param ind Database column ind SqlType(INT), Default(None) */
  case class MyViewRow(i1: Option[Int] = None, c1: Option[String] = None, ind: Option[Int] = None)
  /** GetResult implicit for fetching MyViewRow objects using plain SQL queries */
  implicit def GetResultMyViewRow(implicit e0: GR[Option[Int]], e1: GR[Option[String]]): GR[MyViewRow] = GR{
    prs => import prs._
    MyViewRow.tupled((<<?[Int], <<?[String], <<?[Int]))
  }
  /** Table description of table my_view. Objects of this class serve as prototypes for rows in queries. */
  class MyView(_tableTag: Tag) extends Table[MyViewRow](_tableTag, "my_view") {
    def * = (i1, c1, ind) <> (MyViewRow.tupled, MyViewRow.unapply)

    /** Database column i1 SqlType(INT), Default(None) */
    val i1: Rep[Option[Int]] = column[Option[Int]]("i1", O.Default(None))
    /** Database column c1 SqlType(CHAR), Length(11,false), Default(None) */
    val c1: Rep[Option[String]] = column[Option[String]]("c1", O.Length(11,varying=false), O.Default(None))
    /** Database column ind SqlType(INT), Default(None) */
    val ind: Rep[Option[Int]] = column[Option[Int]]("ind", O.Default(None))
  }
  /** Collection-like TableQuery object for table MyView */
  lazy val MyView = new TableQuery(tag => new MyView(tag))

  /** Entity class storing rows of table Person
   *  @param id Database column ID SqlType(INT), PrimaryKey
   *  @param name Database column NAME SqlType(TEXT)
   *  @param phone Database column PHONE SqlType(TEXT)
   *  @param age Database column AGE SqlType(INT) */
  case class PersonRow(id: Int, name: String, phone: String, age: Int)
  /** GetResult implicit for fetching PersonRow objects using plain SQL queries */
  implicit def GetResultPersonRow(implicit e0: GR[Int], e1: GR[String]): GR[PersonRow] = GR{
    prs => import prs._
    PersonRow.tupled((<<[Int], <<[String], <<[String], <<[Int]))
  }
  /** Table description of table Person. Objects of this class serve as prototypes for rows in queries. */
  class Person(_tableTag: Tag) extends Table[PersonRow](_tableTag, "Person") {
    def * = (id, name, phone, age) <> (PersonRow.tupled, PersonRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(phone), Rep.Some(age)).shaped.<>({r=>import r._; _1.map(_=> PersonRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(INT), PrimaryKey */
    val id: Rep[Int] = column[Int]("ID", O.PrimaryKey)
    /** Database column NAME SqlType(TEXT) */
    val name: Rep[String] = column[String]("NAME")
    /** Database column PHONE SqlType(TEXT) */
    val phone: Rep[String] = column[String]("PHONE")
    /** Database column AGE SqlType(INT) */
    val age: Rep[Int] = column[Int]("AGE")
  }
  /** Collection-like TableQuery object for table Person */
  lazy val Person = new TableQuery(tag => new Person(tag))

  /** Entity class storing rows of table T1
   *  @param i1 Database column i1 SqlType(INT), Default(None)
   *  @param c1 Database column c1 SqlType(CHAR), Length(11,false), Default(None)
   *  @param ind Database column ind SqlType(INT), Default(None) */
  case class T1Row(i1: Option[Int] = None, c1: Option[String] = None, ind: Option[Int] = None)
  /** GetResult implicit for fetching T1Row objects using plain SQL queries */
  implicit def GetResultT1Row(implicit e0: GR[Option[Int]], e1: GR[Option[String]]): GR[T1Row] = GR{
    prs => import prs._
    T1Row.tupled((<<?[Int], <<?[String], <<?[Int]))
  }
  /** Table description of table t1. Objects of this class serve as prototypes for rows in queries. */
  class T1(_tableTag: Tag) extends Table[T1Row](_tableTag, "t1") {
    def * = (i1, c1, ind) <> (T1Row.tupled, T1Row.unapply)

    /** Database column i1 SqlType(INT), Default(None) */
    val i1: Rep[Option[Int]] = column[Option[Int]]("i1", O.Default(None))
    /** Database column c1 SqlType(CHAR), Length(11,false), Default(None) */
    val c1: Rep[Option[String]] = column[Option[String]]("c1", O.Length(11,varying=false), O.Default(None))
    /** Database column ind SqlType(INT), Default(None) */
    val ind: Rep[Option[Int]] = column[Option[Int]]("ind", O.Default(None))
  }
  /** Collection-like TableQuery object for table T1 */
  lazy val T1 = new TableQuery(tag => new T1(tag))

  /** Entity class storing rows of table T2
   *  @param i2 Database column i2 SqlType(INT), Default(None)
   *  @param c2 Database column c2 SqlType(CHAR), Length(255,false), Default(None)
   *  @param ind Database column ind SqlType(INT), Default(None) */
  case class T2Row(i2: Option[Int] = None, c2: Option[String] = None, ind: Option[Int] = None)
  /** GetResult implicit for fetching T2Row objects using plain SQL queries */
  implicit def GetResultT2Row(implicit e0: GR[Option[Int]], e1: GR[Option[String]]): GR[T2Row] = GR{
    prs => import prs._
    T2Row.tupled((<<?[Int], <<?[String], <<?[Int]))
  }
  /** Table description of table t2. Objects of this class serve as prototypes for rows in queries. */
  class T2(_tableTag: Tag) extends Table[T2Row](_tableTag, "t2") {
    def * = (i2, c2, ind) <> (T2Row.tupled, T2Row.unapply)

    /** Database column i2 SqlType(INT), Default(None) */
    val i2: Rep[Option[Int]] = column[Option[Int]]("i2", O.Default(None))
    /** Database column c2 SqlType(CHAR), Length(255,false), Default(None) */
    val c2: Rep[Option[String]] = column[Option[String]]("c2", O.Length(255,varying=false), O.Default(None))
    /** Database column ind SqlType(INT), Default(None) */
    val ind: Rep[Option[Int]] = column[Option[Int]]("ind", O.Default(None))
  }
  /** Collection-like TableQuery object for table T2 */
  lazy val T2 = new TableQuery(tag => new T2(tag))

  /** Entity class storing rows of table Tablename
   *  @param tid Database column tid SqlType(INT), AutoInc, PrimaryKey
   *  @param tablename Database column tablename SqlType(CHAR), Length(255,false), Default(Some()) */
  case class TablenameRow(tid: Int, tablename: Option[String] = Some(""))
  /** GetResult implicit for fetching TablenameRow objects using plain SQL queries */
  implicit def GetResultTablenameRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[TablenameRow] = GR{
    prs => import prs._
    TablenameRow.tupled((<<[Int], <<?[String]))
  }
  /** Table description of table TableName. Objects of this class serve as prototypes for rows in queries. */
  class Tablename(_tableTag: Tag) extends Table[TablenameRow](_tableTag, "TableName") {
    def * = (tid, tablename) <> (TablenameRow.tupled, TablenameRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(tid), tablename).shaped.<>({r=>import r._; _1.map(_=> TablenameRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column tid SqlType(INT), AutoInc, PrimaryKey */
    val tid: Rep[Int] = column[Int]("tid", O.AutoInc, O.PrimaryKey)
    /** Database column tablename SqlType(CHAR), Length(255,false), Default(Some()) */
    val tablename: Rep[Option[String]] = column[Option[String]]("tablename", O.Length(255,varying=false), O.Default(Some("")))
  }
  /** Collection-like TableQuery object for table Tablename */
  lazy val Tablename = new TableQuery(tag => new Tablename(tag))

  /** Entity class storing rows of table Test
   *  @param id Database column id SqlType(INT), Default(None) */
  case class TestRow(id: Option[Int] = None)
  /** GetResult implicit for fetching TestRow objects using plain SQL queries */
  implicit def GetResultTestRow(implicit e0: GR[Option[Int]]): GR[TestRow] = GR{
    prs => import prs._
    TestRow(<<?[Int])
  }
  /** Table description of table test. Objects of this class serve as prototypes for rows in queries. */
  class Test(_tableTag: Tag) extends Table[TestRow](_tableTag, "test") {
    def * = id <> (TestRow, TestRow.unapply)

    /** Database column id SqlType(INT), Default(None) */
    val id: Rep[Option[Int]] = column[Option[Int]]("id", O.Default(None))
  }
  /** Collection-like TableQuery object for table Test */
  lazy val Test = new TableQuery(tag => new Test(tag))
}
