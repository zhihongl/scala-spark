import org.apache.spark.sql.SparkSession

object SparkDemo {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Scala Spark Demo")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._

    val data = Seq(
      (1, "Alice", 29),
      (2, "Bob", 31),
      (3, "Cathy", 25)
    )

    val df = data.toDF("id", "name", "age")
    df.show()

    val avgAge = df.agg(Map("age" -> "avg")).first().getDouble(0)
    println(s"Average age: $avgAge")

    spark.stop()
  }
}