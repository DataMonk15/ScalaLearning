package org.example

import org.apache.spark.sql.SparkSession
import org.apache.logging.log4j.{Level, LogManager, Logger}
import org.apache.logging.log4j.core.config.Configurator

import scala.util.Try

/*
id, name, age, email, address_line_1, address_line_2, city, zipcode
1, one, 21, one@example.com, one_address line 1, one address line 2, hyderabad, 500001
2, two, 22, two@example.com, two_address line 1, two address line 2, hyderabad, 500002
3, three, 23, three@example.com, three_address line 1, three address line 2, hyderabad, 500003
4, four, 24, four@example.com, four_address line 1, four address line 2, hyderabad, 500004

{
  "id":1,
  "name":"one",
  "age" : 21,
  "email": "one@example.com",
  "address":{
    "address_line_1":"one_address line 1",
	"address_line_2":"one_address line 2",
	"city" : "hyderabad",
	"zipcode" : 500001
  }
}
 */

case class Person(id:String,name:String,age:String,email:String,address_line_1:String,address_line_2:String,city:String,zipcode:String)

object test {

	val logger:Logger =  LogManager.getLogger(getClass.getName)

	def optionToInt(s:String):String ={
		Option(s).filter(_.nonEmpty).flatMap(x => Try(x.toInt).toOption).map(_.toString).getOrElse("null")
	}

	def optionToString(s:String):String = {
		Option(s).map(_.trim).filter(_.nonEmpty).map(str => s""""$str"""").getOrElse("null")
	}

	def toJson(person:Person):String ={
		s"""|{
				|"id": ${optionToInt(person.id)},
				|"name": ${optionToString(person.name)},
				|"age": ${optionToInt(person.age)},
				|"email":${optionToString(person.email)},
				|"address":{
				|	"address_line_1":${optionToString(person.address_line_1)},
				|	"address_line_2":${optionToString(person.address_line_2)},
				|	"city": ${optionToString(person.city)}
				| 	}
				| }
				|""".stripMargin
	}

	def main(args: Array[String]): Unit = {

		Configurator.setRootLevel(Level.INFO)

		logger.info("creating the sparksession object")
		val spark = SparkSession.builder()
			.appName("test")
			.master("local[*]")
			.getOrCreate()
		logger.debug("created the sparksession object")

		import spark.implicits._

		val df2 = spark.read.option("header","true").
			option("inferschema","true").csv("/Users/naveenkumar/IdeaProjects/ScalaLearning/src/main/scala/org/example/test.txt")

		logger.warn("input file is read into dataframe")
		df2.show()
		val result = df2.as[Person].map(toJson)
		logger.error("dataframe is converted into person class")
		val finalresult = s"[\n" + result.collect().mkString(",\n") + "]"
		println(finalresult)
	}
}
