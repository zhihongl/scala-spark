error id: show.
file://<WORKSPACE>/src/main/scala/ReadAAPLCSV.scala
empty definition using pc, found symbol in pc: show.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -df/show.
	 -df/show#
	 -df/show().
	 -scala/Predef.df.show.
	 -scala/Predef.df.show#
	 -scala/Predef.df.show().
offset: 422
uri: file://<WORKSPACE>/src/main/scala/ReadAAPLCSV.scala
text:
```scala
import org.apache.spark.sql.SparkSession

object ReadAAPLCSV {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Read AAPL CSV")
      .master("local[*]")
      .getOrCreate()

    val filePath = "data/AAPL.csv"
    val df = spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(filePath)

      println("-------------------")
    df.show@@(10)
    df.printSchema()
    // print some delimeters
    println("-------------------")
    println("-------------------")

    // Inspect the first 5 rows for the 'Close' column
    // import org.apache.spark.sql.functions._
    // df.select("Close").show(5)
    // df.printSchema()

    spark.stop()
  }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: show.