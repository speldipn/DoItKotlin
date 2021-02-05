package com.example.doitkotlin

import android.util.Log

class InterfaceExample {
    fun runExample() {
        val c = C()
        c.test()
    }

    open inner class A {
        open fun f() = debug("A class f()")
        fun a() = debug("A class a()")
    }

    inner class C : A(), B {
        override fun f(): Int = debug("C Class f()")

        fun test() {
            f()
            b()
            super<A>.f()
            super<B>.f()
        }
    }

    interface B {
        fun f() = Log.d(MainActivity.TAG, "B Interface f()")
        fun b() = Log.d(MainActivity.TAG, "B Interface b()")
    }

    fun debug(msg: String) = Log.d(MainActivity.TAG, msg)
}