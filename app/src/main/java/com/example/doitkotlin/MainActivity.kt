package com.example.doitkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.lang.Exception
import java.util.*
import java.util.concurrent.locks.ReentrantLock

//import com.example.doitkotlin.test.Person

typealias Username = String

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView

    companion object {
        val TAG = "SPDN"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        setup()
    }

    private inline fun inlineSubFunction(a: Int, out: (x: Int) -> Unit) {
        debug("Before function call")
        out(a)
        debug("After function call")
    }

    private fun inlineFunctionTest() {
        inlineSubFunction(10) { a -> debug("$a") }
        inlineSubFunction(20) { a -> debug("$a") }
        inlineSubFunction(30, fun(x) = debug("$x"))
    }

    private fun setup() {
        val classExample = ClassExample()
        classExample.runExample()
    }

    private fun forLoopTest() {
        // *****
        // ****
        // ***
        // **
        // *
        for (i in 4 downTo 0) {
            var star = ""
            for (j in 0..i) {
                star += "*"
            }
            textView.append("$star\n")
        }
        textView.append("\n\n")

        //  *
        // ***
        //*****
        // ***
        //  *
        var isReserve = false
        var starCount = 0
        var skipCount = 0
        val max = 5
        for (i in 0 until max) {
            var line = ""

            if (!isReserve) {
                starCount = 2 * (i + 1) - 1
                skipCount =  2 - i
            } else {
                starCount = 2 * (max - i) - 1
                skipCount = (i + 1) - 3
            }

            // skip space
            for (j in 0 until skipCount) {
                line += " "
            }

            // add star
            for (j in 0 until starCount) {
                line += "*"
            }

            textView.append("${line}\n")
//            debug(line)

            if (i == 2) {
                isReserve = true
            }
        }

        val n = 2
        ((0 until n) + (n downTo 0)).forEach {
//            debug("${" ".repeat(n - it)}*${"*".repeat(2 * it)}")
        }

        ((0 until 2) + (2 downTo 0)).forEach {
//            debug("${it}")
        }
    }

    private fun ifTest() {
        val score = 59.9
        var grade: Char? = null
        if (score >= 90) {
            grade = 'A'
        } else if (score in 80.0..89.9) {
            grade = 'B'
        } else if (score in 69.0..79.9) {
            grade = 'C'
        }
        debug("Grade:${grade ?: 'D'}")
    }

    private fun infixFunctionTest() {
        infix fun Int.multiply(a: Int) = this * a

        val result = 3 multiply 3
        debug("result: ${result}")
    }

    private fun anonymousFuntionTest() {
        val sum = fun(x: Int, y: Int): Int = x + y
        val add: (Int, Int) -> Int = fun(a, b) = a + b
        debug("add(10,2): ${add(10, 2)}, sum(1,3):${sum(1, 3)}")
        val add2 = { a: Int, b: Int -> a + b }
        debug("${add2(30, 4)}")
        val person = Person("Anne")
        val name = "Neo"
        val age = 34
        val isAdult = true
//        person.printSpdn()
//        name.printSpdn()
        age.printSpdn()
        isAdult.printSpdn()
    }

    fun Any.printSpdn() {
        debug("print spdn")
    }

    private fun lambdaThreadTest() {
        var sharable = 1

        val lock = ReentrantLock()
        val taskFunc = { sharable += 1 }
        val threadFunc: (ReentrantLock, () -> Unit) -> Unit = { lock, task ->
            lock.lock()
            try {
                task()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            lock.unlock()
        }
        val threadFunc1 = { lock: ReentrantLock, task: () -> Unit ->
            lock.lock()
            try {
                task()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            lock.unlock()
        }
        threadFunc(lock, taskFunc)
        threadFunc1(lock, taskFunc)
        threadFunc(lock, taskFunc)
        threadFunc1(lock, taskFunc)
        threadFunc(lock, taskFunc)
        threadFunc1(lock, taskFunc)

        debug("sharable: ${sharable}")
    }

    private fun practiceLambda() {
        val sum = { a: Int, b: Int -> a + b }
        val mul = { a: Int, b: Int -> a * b }
        val res1 = sum(3, 2)
        val res2 = mul(sum(3, 3), 3)
        debug("res1:${res1} res2:${res2}")

        val greet = { debug("greet: Hello World") }
        val greet2: () -> Unit = { debug("greet2: Hello world!") }
        greet()
        greet2()

        val square: (Int) -> Int = { x -> x * x }
        val square2 = { x: Int -> x * x }
        debug("square: ${square(10)} square2: ${square2(20)}")

        // netsted
        val nestedLambum: () -> () -> Unit = { { debug("nested1") } }
        val nestedLambda2 = { { debug("nested2") } }
        nestedLambum()()
        nestedLambda2()()

        fun _sum(a: Int, b: Int) = a + b
        val __sum = { a: Int, b: Int -> a + b }
        fun paramFunc(a: Int, b: Int, sum: (Int, Int) -> Int): Int {
            return sum(a, b)
        }
        debug("${paramFunc(2, 3, ::_sum)}")
        debug("${paramFunc(4, 5, __sum)}")


        fun noParam(out: () -> String) = debug(out())
        noParam({ "No param test1" })
        noParam { "No param test2" }

        fun twoLambda(first: (String, String) -> String, second: (String) -> String) {
            debug("first: ${first("OneParam", "TwoParam")}")
            debug("second: ${second("OneParam")}")
        }
        twoLambda({ a, b -> a + b }, { a -> a })
        twoLambda({ a, b -> "two $a$b" }) { a -> "two $a" }
    }

    private fun printManyArgs(vararg nums: Int) {
        debug("size: ${nums.size}")
        for (num in nums) {
            debug("$num")
        }
    }

    private fun highFunc(sum: (Int, Int) -> Int, a: Int, b: Int): Int = sum(a, b)

    private fun printFunDefaultParamter(a: Int = 10, b: Int) {
        debug("a=${a}, b=${b}")
    }

    private fun printMaxExample() {
        debug("${sum1(1, 3)}")
        debug("${sum2(1, 3)}")
        debug("${sum3(1, 3)}")
        debug("${max1(3, 5)}")
        debug("${max2(3, 5)}")
        debug("${max3(3, 5)}")
    }

    private fun max1(a: Int, b: Int) = if (a > b) a else b
    private fun max2(a: Int, b: Int): Int = if (a > b) a else b
    private fun max3(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    private fun printSumFuncTest() {
        debug("${sum1(1, 2)}")
        debug("${sum2(1, 2)}")
        debug("${sum3(1, 2)}")
    }

    private fun sum1(a: Int, b: Int): Int = a + b
    private fun sum2(a: Int, b: Int): Int {
        return a + b
    }

    private fun sum3(a: Int, b: Int) = a + b

    private fun printBitExample() {
        debug("${2.shl(1)}") // 4
        debug("${2.shr(1)}") // 1
        debug("${2.ushr(1)}") // 1
        debug("${2.and(1)}") // 0
        debug("${2.or(1)}") // 3
        debug("${2.xor(1)}") // 3
        debug("${2.inv()}") // -3
    }

    private fun printTypeExample() {
        printVariableType("Hello")
        printVariableType(10)
        printVariableType(20L)
        printVariableType(1.0)
        printVariableType(10.0F)
        printVariableType('A')
        printVariableType(true)
    }

    private fun printVariableType(variable: Any) {
        when (variable) {
            is String -> {
                debug("$variable is string")
            }
            is Int -> {
                debug("$variable is int")
            }
            is Long -> {
                debug("$variable is long")
            }
            is Float -> {
                debug("$variable is float")
            }
            is Double -> {
                debug("$variable is double")
            }
            is Char -> {
                debug("$variable is char")
            }
            is Boolean -> {
                debug("$variable is boolean")
            }
            else -> {
                debug("$variable is unknown type")
            }
        }
    }

    private fun printAsCast() {
        val y: String? = null
        val x = y as? String ?: "empty"
        debug("$x $y")

        var a: Any = 1
        debug("0 a: $a type: ${a.javaClass}")
        a = 20L
        debug("1 a: $a type: ${a.javaClass}")
        a = "Hello"
        debug("2 a: $a type: ${a.javaClass}")
    }

    private fun printCheckType() {
        val num = 10

        if (num is Int) {
            debug("$num is int")
        } else if (num !is Int) {
            debug("$num is not int")
        }

        val x: Any
        x = "Hello"
        if (x is String) {
            debug("$x is string, length=${x.length}")
        } else {
            debug("$x is not a string")
        }
    }

    private fun printSmartCast() {
        var test: Number = 12.2
        debug("$test")
        test = 12
        debug("$test")
        test = 120L
        debug("$test")
        test += 12.0F
        debug("$test")
    }

    private fun printReferenceTest() {
        val a: Int = 128
        val b = a
        debug("${a === b}")  // true

        val c: Int? = a
        val d: Int? = a
        val e: Int? = c
        debug("${c == d}") // true
        debug("${c === d}") // false
        debug("${c === e}") // true
    }

    private fun printStringTest() {
        val user: Username = "Neo"

        // === : Compare reference
        var str1: String = "Hello"// String pool
        var str2 = "World"
        var str3 = "Hello" // Read from string pool

        debug("${str1 === str2}") // false
        debug("${str1 === str3}") // true

        val num = 10

        var longText = """Hello
            My name is $user.
            Nice to meet you
            ${num}
        """.trimMargin()
        debug(longText)

        var _str1: String? = "Hello Kotlin"
        _str1 = null
        debug("${_str1!!} ${_str1?.length}")
    }

    private fun printDataSize() {
        debug("Byte min: ${Byte.MIN_VALUE} max: ${Byte.MAX_VALUE}")
        debug("Short min: ${Short.MIN_VALUE} max: ${Short.MAX_VALUE}")
        debug("Int min: ${Int.MIN_VALUE} max: ${Int.MAX_VALUE}")
        debug("Long min: ${Long.MIN_VALUE} max: ${Long.MAX_VALUE}")
        debug("Float min: ${Float.MIN_VALUE} max: ${Float.MAX_VALUE}")
        debug("Double min: ${Double.MIN_VALUE} max: ${Double.MAX_VALUE}")
    }

    private fun debug(msg: String) {
        Log.d(TAG, msg)
    }

    inner class Person(val name: String) {
        fun printName() {
            debug("$name")
        }
    }
}