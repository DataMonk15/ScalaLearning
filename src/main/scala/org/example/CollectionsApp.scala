package org.example

import scala.collection.immutable.TreeSeqMap.Empty
import scala.reflect.runtime.universe.Tree
import scala.util.Try
import scala.xml.Node

object CollectionsApp {
	def main(args: Array[String]): Unit = {

		val num = List(2020, 20, 1010, 10, 2, 22)

		val largestNumber = num.mkString("")
		println(largestNumber.sorted(Ordering[Char].reverse))

		println(Option(Try("".toInt).getOrElse("null")))

	}
}
