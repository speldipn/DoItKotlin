package com.example.doitkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select
import kotlin.random.Random


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

  private fun run() {
    timeElapsed {
      runBlocking {
        val routine1 = GlobalScope.produce {
          delay(Random(System.currentTimeMillis()).nextLong(1000))
          send("A")
        }
        val routine2 = GlobalScope.produce {
          delay(Random(System.currentTimeMillis()).nextLong(1000))
          send("B")
        }
        val result = select<String> {
          routine1.onReceive { result -> result }
          routine2.onReceive { result -> result }
        }
        _println("Result was $result")
      }
    }
  }

}
