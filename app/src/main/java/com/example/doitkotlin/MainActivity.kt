package com.example.doitkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


fun _println(args: Any?) = println("${MainActivity.TAG}: ${args}")
fun _print(args: Any?) = print("${MainActivity.TAG}: ${args}")

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "speldipn"
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
        // 1 1 2 3 5 8
//        timeElapsed {
//            val fiboSeq = generateSequence(1 to 1) { it.second to (it.first + it.second) }
//                .map { it.first }
//            _println("${fiboSeq.take(10).toList()}")
//        }

        timeElapsed {
            val primeSeq = generateSequence(1) { it + 1 }
                .filterIndexed { index, value ->
                    var outCount = 0
                    for (i in 1..index + 1) {
                        if (value % i == 0) {
                            ++outCount
                        }
                    }
                    outCount == 2
                }
//            _println("${primeSeq.take(1000).toList().takeLast(10)}")
        }

        timeElapsed {
            val primes = generateSequence(2 to generateSequence(3) { it + 2 }) {
                val currSeq = it.second.iterator()
                val nextPrime = currSeq.next()
                _println("$nextPrime")
                nextPrime to currSeq.asSequence().filter { it % nextPrime != 0 }
            }.map { it.first }
            primes.take(5).toList()
//            _println("${primes.take(1000).toList().takeLast(10)}")
        }

        val seq = generateSequence(3) { it +  2 }
        _println("${seq.take(5).toList()}")

    }

}