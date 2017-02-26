package com.jasonsatran.spark.meta.helper

import java.text.DecimalFormat
import org.apache.spark.sql.functions._

object Helper {

  def percentFill(numerator: Double, denominator: Double) : Double = {
    return round((numerator.toDouble / denominator.toDouble) * 100)
  }

  def round (x: Double) : Double = {
    val formatString = "#####.#"
    val formatter  = new DecimalFormat(formatString)
    val result = formatter.format(x)
    result.toDouble
  }

  def isEmpty(x: String): Boolean = {
    if (x ==null){
      return true
    }else if (x.trim==""){
      return true
    }
    else{
      return false
    }
  }

  val COLUMN_SIZE = 60

  def formatColumn(value : String) : String = {
    val spaces = " " * COLUMN_SIZE
    (spaces + value).takeRight(COLUMN_SIZE)
  }

  val udfIsEmpty = udf[Boolean,String] (isEmpty)
}