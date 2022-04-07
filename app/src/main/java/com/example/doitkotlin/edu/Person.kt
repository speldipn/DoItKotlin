package com.example.doitkotlin.edu

class Person(
  val name: String, val age: Int
) {
  companion object {
    var name = "speldipn: Kotlin Name"

    @JvmStatic
    fun func() {
      println("speldipn: This is kotlin class")
    }
  }

}