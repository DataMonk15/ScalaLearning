package org.example

object Variables {
  def main(args: Array[String]): Unit = {

    // val is immutable in nature and varables cannot be reassigned.
    val firstName = "Naveen"
    val lastName = "Kumar"
    println(s"values are ${firstName} and ${lastName}")

    // firstName = "Arjun" reassignment is not allowed beacuse of immutable

    // var is mutable in nature and variables can be reassigned.
    var fName = "Naveen"
    fName = "Kumar"
    println(s"value after reassignement is ${fName}")

    // fName = 1 throws an compilation error because of data type change
  }
}
