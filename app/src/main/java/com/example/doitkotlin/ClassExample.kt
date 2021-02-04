package com.example.doitkotlin

import android.util.Log

class ClassExample {

    fun runExample() {
        val coco = Bird("mybird", 2, "short", "blue")

        coco.color = "yellow"
        debug("coco.color: ${coco.color}")
        coco.fly()
        coco.sing(3)
    }

    inner class Bird {
        var name: String
        var wing: Int
        var beak: String
        var color: String

        constructor(name: String, wing: Int, beak: String, color: String) {
            this.name = name
            this.wing = wing
            this.beak = beak
            this.color = color
        }

        fun fly() = debug("Fly wing: $wing")
        fun sing(vol: Int) = debug("Sing vol: $vol")
    }

    private fun debug(msg: String) {
        Log.d(MainActivity.TAG, msg)
    }

}