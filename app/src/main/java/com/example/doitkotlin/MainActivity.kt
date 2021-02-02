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

    private fun setup() {
        debug("${abs(-10)}")
        debug("${PI}")
    }

    private fun debug(msg: String) {
        Log.d(TAG, msg)
    }
}