package com.spark.hbase

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase._
import org.apache.spark.{SparkConf, SparkContext}

object Application {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("spark-project").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val spark = SparkSession.builder().master("local[*]").getOrCreate()

    val catalog =
      """{
        |"table":{"namespace":"myspace", "name":"customer"},
        |"rowkey":"rowkey",
        |"columns":{
        |"row_key":{"cf":"rowkey", "col":"rowkey", "type":"string"},
        |"firs_tname":{"cf":"personal", "col":"firstname", "type":"string"},
        |"last_name":{"cf":"personal", "col":"lastname", "type":"string"}
        |}
        |}""".stripMargin
    val dataFrame = spark.read.options(Map(HBaseTableCatalog.tableCatalog -> catalog)).format("org.apache.spark.sql.execution.datasources.hbase").load()
    dataFrame.show()
  }
}
