package com.example.doitkotlin

import android.util.Log

class ClassThisExample {

    fun runExample() {
        val p1 = Person("KilDong", 30)
        debug("====================\n\n")
        val p2 = Person("Dooly")
    }

    // [Secondary constructor] Paramerter
    // [Primary constructor] Paramter
    // [Property Person fName
    // [init] Person init block
    // [Secondary constructor] Body

    // [Primary constructor] Parameter
    // [Property] Person name
    // [init] Person init block

    inner class Person(firstName: String, out: Unit = debug("[Primary constructor] Parameter")) {
        val fName = debug("[Property] Person fName: $firstName")

        init {
            debug("[init] Person init block")
        }

        constructor(firstName: String, age: Int,
            out: Unit = debug("[Secondary Constructor] : Parameter")): this(firstName) {
            debug("[Secondary Constructor] Body: $firstName, $age")
        }
    }

    private fun debug(msg: String) {
        Log.d(MainActivity.TAG, msg)
    }
}