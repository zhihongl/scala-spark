import org.apache.spark.sql.SparkSession

object HelloSpark {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Hello Spark")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._

    val data = Seq(
      ("Alice", "Engineering", 95000),
      ("Bob", "Marketing", 72000),
      ("Cathy", "Engineering", 88000),
      ("Dave", "Marketing", 65000),
      ("Eve", "Engineering", 102000)
    ).toDF("name", "department", "salary")

    println("Full dataset:")
    data.show()

    val highEarners = data.filter($"salary" > 80000)
    println("Employees with salary > 80000:")
    highEarners.show()

    val deptStats = data
      .groupBy("department")
      .count()
    println("Employee count by department:")
    deptStats.show()

    spark.stop()
  }
}
