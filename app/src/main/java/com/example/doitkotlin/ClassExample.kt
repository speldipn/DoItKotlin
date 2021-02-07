package com.example.doitkotlin

import android.util.Log

class ClassExample {

    fun runExample() {
        val coco = Bird("mybird", 2, "short", "blue")
        val lark = Lark("mylark", 2, "long", "brown")
        val parrot = Parrot("myparrot", 2, "short", "multiple", "korean")

        debug("Coco: ${coco.name} ${coco.wing} ${coco.beak} ${coco.color}")
        debug("Lark: ${lark.name} ${lark.wing} ${lark.beak} ${lark.color}")
        debug("Parrot: ${parrot.name} ${parrot.wing} ${parrot.beak} ${parrot.color} ${parrot.language}")

        lark.singHitone()
        parrot.speak()
        lark.fly()
    }

    open inner class Bird(val name: String, val wing: Int, val beak: String, val color: String) {

        open fun fly() = debug("Fly wing: $wing")
        fun sing(vol: Int) = debug("Sing vol: $vol")
    }

    inner class Lark(
        name: String,
        wing: Int,
        beak: String,
        color: String
    ) : Bird(name, wing, beak, color) {
        fun singHitone() = debug("Happy Song!")
        override fun fly() {
            debug("Lark fly wing: $wing")
        }
    }

    inner class Parrot : Bird {
        val language: String

        constructor(
            name: String,
            wing: Int,
            beak: String,
            color: String,
            language: String
        ) : super(name, wing, beak, color) {
            this.language = language
        }

        fun speak() = debug("Speak! $language")
        override fun fly() {
            debug("Parrot fly wing: $wing")
        }
    }

    private fun debug(msg: String) {
        Log.d(MainActivity.TAG, msg)
    }

}