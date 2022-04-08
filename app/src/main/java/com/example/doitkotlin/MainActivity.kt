package com.example.doitkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.runBlocking


fun _println(args: Any?) = println("${MainActivity.TAG}: ${args}")
fun _print(args: Any?) = print("${MainActivity.TAG}: ${args}")

class MainActivity : AppCompatActivity() {

  companion object {
    const val TAG = "[s]"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    run()
  }

  private fun timeElapsed(task: () -> Unit) {
    val before = System.nanoTime()
    task()
    val after = System.nanoTime()
    val speed = (after - before) / 1000000
    _println("time elapsed: $speed ms")
  }

  private fun run() {
    timeElapsed {
      runBlocking {
        // TODO
      }
    }
  }

}
