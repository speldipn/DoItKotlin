package com.example.doitkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
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

  fun timeElapsed(task: () -> Unit) {
    val before = System.nanoTime()
    task()
    val after = System.nanoTime()
    val speed = (after - before) / 1000000
    _println("time elapsed: $speed ms")
  }

  fun CoroutineScope.producer(): ReceiveChannel<Int> = produce {
    var total = 0
    for (x in 1..5) {
      total += x
      send(total)
    }
  }

  private fun run() {
    timeElapsed {
      runBlocking {
        val result = producer()
        result.consumeEach { _println("$it") }
      }
    }
  }

}
