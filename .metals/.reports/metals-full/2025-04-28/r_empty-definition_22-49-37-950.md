error id: printSchema.
file://<WORKSPACE>/src/main/scala/ReadAAPLCSV.scala
empty definition using pc, found symbol in pc: printSchema.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -df/printSchema.
	 -df/printSchema#
	 -df/printSchema().
	 -scala/Predef.df.printSchema.
	 -scala/Predef.df.printSchema#
	 -scala/Predef.df.printSchema().
offset: 404
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

    df.show(10)
    df.printSc@@hema()
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

empty definition using pc, found symbol in pc: printSchema.