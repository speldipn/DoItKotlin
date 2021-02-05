package com.example.doitkotlin

import android.util.Log

class ClassExample {

    fun runExample() {
        val coco = Bird("mybird", 2, "short", "blue")

        debug("${coco.name} ${coco.beak}")

        coco.fly()
        coco.sing(3)
    }

    inner class Bird(val name: String, val wing: Int, val beak: String, val color: String) {
        init {
            debug("Start of init")
            debug("$name $beak $color")
            this.sing(3)
            debug("End of init")
        }

        fun fly() = debug("Fly wing: $wing")
        fun sing(vol: Int) = debug("Sing vol: $vol")
    }

    private fun debug(msg: String) {
        Log.d(MainActivity.TAG, msg)
    }

}