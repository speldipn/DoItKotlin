package com.example.doitkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlin.system.measureTimeMillis


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

  val counterContext = newSingleThreadContext("CounterContext")
  private var counter = 0
  private var mutex = Mutex()

  private suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 100
    val k = 100
    val time = measureTimeMillis {
      val jobs = List(n) {
        GlobalScope.launch {
          repeat(k) { action() }
        }
      }
      jobs.forEach { it.join() }
    }
    _println("Completed ${n * k} acitons in $time ms")
  }

  private fun run() {
    timeElapsed {
      runBlocking {
        massiveRun {
          try {
            mutex.lock()
            counter++
            mutex.unlock()
          } catch(e: Exception) {
            _println("execption: $e")
          }
        }
        _println("Counter: ${counter}")
      }
    }
  }

}
