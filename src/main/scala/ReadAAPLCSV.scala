import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

object ReadAAPLCSV {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Read AAPL CSV")
      .master("local[*]")
      .getOrCreate()

    val filePath = "data/AAPL.csv"
    val df = loadData(spark, filePath)
    
    // Basic data exploration
    showDataSummary(df)
    
    // Advanced analytics demonstrations
    // 1. Filtering - Show stocks with closing price > $150
    val highValueStocks = df.filter(col("Close") > 150)
    println("\nStocks with closing price > $150:")
    highValueStocks.show()
    
    // 2. Aggregations - Calculate average volume by year
    val yearlyAvgVolume = df.withColumn("Year", year(col("Date")))
      .groupBy("Year")
      .agg(avg("Volume").alias("AvgVolume"))
      .orderBy("Year")
    println("\nAverage trading volume by year:")
    yearlyAvgVolume.show()
    
    // 3. Window functions - Calculate 7-day moving average
    val windowSpec = Window.orderBy("Date").rowsBetween(-6, 0)
    val movingAvgDF = df.withColumn("MovingAvg", 
      avg("Close").over(windowSpec))
    println("\n7-day moving average of closing prices:")
    movingAvgDF.select("Date", "Close", "MovingAvg").show(10)
    
    // 4. Data transformation - Calculate daily returns
    val returnsDF = df.withColumn("DailyReturn", 
      (col("Close") - lag("Close", 1).over(Window.orderBy("Date"))) 
      / lag("Close", 1).over(Window.orderBy("Date")))
    println("\nDaily returns calculation:")
    returnsDF.select("Date", "Close", "DailyReturn").show(10)
    
    spark.stop()
  }
  
  def loadData(spark: SparkSession, path: String): DataFrame = {
    spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(path)
  }
  
  def showDataSummary(df: DataFrame): Unit = {
    df.show(10)
    df.printSchema()
  }
  
  def inspectColumn(df: DataFrame, columnName: String, numRows: Int): Unit = {
    df.select(columnName).show(numRows)
    df.printSchema()
  }
}