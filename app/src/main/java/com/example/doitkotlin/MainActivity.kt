package com.example.doitkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.PI
import kotlin.math.abs

//import com.example.doitkotlin.test.Person

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "speldipn"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }

    // private, default, public, internal
    private fun setup() {
        // var car = Car()
        val tico = Tico("kildong", true)
        tico.access("gotico")

        val burglar = Burglar()
        burglar.steal(tico)
    }

    inner open class Car protected constructor(
        _year: Int,
        _model: String,
        _power: String,
        _wheel: String
    ) {
        private var year: Int = _year
        public var model: String = _model
        protected open var power: String = _power
        internal var wheel: String = _wheel

        protected fun start(key: Boolean) {
            if (key) Log.d(MainActivity.TAG, "Start the engine!")
        }

        inner class Driver(_name: String, _license: String) {
            private var name: String = _name
            var license: String = _license
            internal fun driving() = Log.d(TAG, "[Driver] Driving() - $name")
        }
    }

    inner class Tico(
        _year: Int,
        _model: String,
        _power: String,
        _wheel: String,
        var name: String,
        private var key: Boolean
    ) : Car(_year, _model, _power, _wheel) {
        override var power: String = "50hp"
        val driver = Driver(name, "first class")

        constructor(_name: String, _key: Boolean) : this(
            2014,
            "basic",
            "100hp",
            "normal",
            _name,
            _key
        ) {
            name = _name
            key = _key
        }

        fun access(password: String) {
            if (password == "gotico") {
                Log.d(MainActivity.TAG, "----[Tico] access()----")
                // super.year
                Log.d(MainActivity.TAG, "suepr.model = ${super.model}")
                Log.d(MainActivity.TAG, "suepr.power= ${super.power}")
                Log.d(MainActivity.TAG, "suepr.wheel= ${super.wheel}")
                super.start(key)

                // driver.name
                Log.d(MainActivity.TAG, "Driver().license = ${driver.license}")
                driver.driving()
            } else {
                Log.d(MainActivity.TAG, "You're a burglar")
            }
        }
    } // end of Tico class

    class Burglar() {
        fun steal(anycar: Any) {
            if (anycar is Tico) {
                Log.d(MainActivity.TAG, "----[Burglar] steal()----")
                // Log.d(MainActivity.TAG, "${anycar.power}")
                // Log.d(MainActivity.TAG, "${anycar.year}")
                Log.d(MainActivity.TAG, "anycar.name = ${anycar.name}")
                Log.d(MainActivity.TAG, "anycar.wheel = ${anycar.wheel}")
                Log.d(MainActivity.TAG, "anycar.model= ${anycar.model}")

                Log.d(MainActivity.TAG, "${anycar.driver.license}")
                anycar.driver.driving()
                // Log.d(MainActvitiy.TAG, "${Car.start()}")
                anycar.access("dontknow")
            } else {
                Log.d(MainActivity.TAG, "Nothing to steal")
            }
        }
    }

    private fun debug(msg: String) {
        Log.d(TAG, msg)
    }
}