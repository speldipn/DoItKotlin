package com.example.doitkotlin

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*


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

    // private, default, public, internal
    // DTO: Data Transfer Object(= POJO, Plain Old Java Object)
    private fun setup() {
    }

//    private fun runBlockingExample() {
//        runBlocking {
//            val job = async {
//                delay(1000L)
//                debug("World!")
//            }
//            debug("Hello")
//            job.join()
////            delay(2000L)
//            debug("End of runBlocking")
//        }
//        debug("End of example")
//    }

//    private fun runCoroutinesExample5() {
////        val doWork1: () -> String = { "Work1" }
////        val doWork2: () -> String = { "Work2" }
////        suspend fun doWork1() = "Work1"
////        suspend fun doWork2() = "Work2"
//        val doWork1 = { "Work1" }
//        val doWork2 = { "Work2" }
//
//        val one = GlobalScope.async {
//            debug("one: ${Thread.currentThread()}")
//            doWork1()
//        }
//
//        val two = GlobalScope.async {
//            debug("two: ${Thread.currentThread()}")
//            doWork2()
//        }
//
//        GlobalScope.launch {
//            val combined = "${one.await()}_${two.await()}"
//            debug("Kotlin combined: $combined")
//            debug("Main: ${Thread.currentThread()}")
//        }
//    }

//    private fun runCoroutinesExample4() {
//        suspend fun doWork1(): String {
//           delay(1000L)
//            return "Work1"
//        }
//
//        suspend fun doWork2(): String {
//            delay(3000L)
//            return "Work2"
//        }
//
//        fun worksInSerial() {
//            GlobalScope.launch {
//                val one = doWork1()
//                val two = doWork2()
//                debug("Kotlin One: $one")
//                debug("Kotlin Two: $two")
//            }
//        }
//
//        worksInSerial()
//        debug("End of program")
//    }

//    private fun runCoroutinesExample2() {
//        val job = GlobalScope.launch {
//            delay(1000L)
//            debug("World")
//        }
//        debug("Hello,")
//        debug("job.isActive: ${job.isActive}, completed: ${job.isCompleted}")
//        Thread.sleep(2000L)
//
//        debug("job.isActive: ${job.isActive}, completed: ${job.isCompleted}")
//    }

//    private fun runCoroutinesExample() {
//        fun doSomething() = debug("doSomething called")
//        GlobalScope.launch {
//            delay(1000L)
//            debug("World!")
//            doSomething()
//        }
//        debug("Hello,")
//        try { Thread.sleep(2000) } catch (ignored: Exception) { }
//    }


//    private fun runThreadExample3() {
//        val myService:ExecutorService = Executors.newFixedThreadPool(8)
//        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
//        val items = list.map { "$it thread.." }
//        fun processItem(item: String) { debug("$item")}
//        for(index in 0 until 8) {
//            myService.submit {
//                processItem(items[index])
//            }
//        }
//    }

//    private fun runThreadExample2() {
//        object : Thread() {
//            override fun run() {
//                debug("Current Thread: ${Thread.currentThread()}")
//            }
//        }.start()
//
//        Runnable { debug("Current Thread: ${Thread.currentThread()}") }.run()
//
//        Thread { debug("Current Thread: ${Thread.currentThread()}") }.start()
//    }

//    private fun runThreadStartExample() {
//        class SimpleThread: Thread() {
//            override fun run() {
//                debug("Current Threads: ${currentThread()}")
//            }
//        }
//
//        class SimpleRunnable: Runnable {
//            override fun run() {
//                debug("Current Thread: ${Thread.currentThread()}")
//            }
//        }
//
//        val thread = SimpleThread()
//        thread.start()
//
//        val runnable = SimpleRunnable()
//        val thread1 = Thread(runnable)
//        thread1.start()
//    }

//    private fun runChapterTenExample() {
//        // 1.
//        val property: Int? = 42
//        fun someMethod() {
//            property?.let { debug("someMehtod: $it") }
//        }
//        someMethod()
//        // 2.
//        data class Person(var name: String, var age: Int)
//        val person = Person().apply {
//            name = "Killdong"
//            age = 30
//        }
//        debug("$person")
//
//        // 3. Occur null pointer exception
//    }

//    private fun runFileExample() {
//        val path = ""
//        val text = "test text"
//        try {
//            Files.write(Paths.get(path), text.toByteArray(), StandardOpenOption.CREATE)
//        } catch(e: Exception) {
//            debug("${e.message}")
//        }
//    }

//    private fun runDSLExample() {
//        data class Job(
//            var cateogry: String? = null,
//            var position: String? = null,
//            var extension: Int? = null
//        )
//
//        data class Person(
//            var name: String? = null,
//            var age: Int? = null,
//            var job: Job? = null
//        )
//
//        fun person(block: (Person) -> Unit): Person {
//            val p = Person()
//            block(p)
//            return p
//        }
//
//        val person = person {
//            it.name = "Neo"
//            it.age = 34
//        }
//
//        debug("$person")
//    }

//    private fun runRandomExample() {
//        val count = 20
//        val nums = mutableListOf<Int>()
//        for (index in 0..count - 1) {
//            nums.add(Random().nextInt(10))
//        }
//        debug("$nums")
//    }

//    private fun runTakeIfExample() {
//        fun doThis() = debug("doThis called")
//        data class User(val name: String, var skills: String, var email: String? = null)
//
//        var user: User? = null
//        user = User("Neo", "Android", "neo@gmail.com")
//        if (user != null && user.email != null) {
//            doThis()
//        }
//        if (user?.email != null) {
//            doThis()
//        }
//        user?.takeIf { it.email != null }?.apply { doThis() }
//
//        val input = "Kotlin"
//        val keyword = "in"
//
//        input.indexOf(keyword).takeIf { it >= 0 }.apply { debug("$keyword indexOf: $this") }
//            ?: debug("keyword not found")
//
//        input.indexOf(keyword).takeUnless { it < 0 }.apply { debug("$keyword indexOf: $this") }
//            ?: debug("keyword not found")
//    }

//    private fun runUseExample() {
//        PrintWriter(FileOutputStream("")).use { it.println("Hello") }
//    }

//    private fun runWithExample() {
//        data class User(val name: String, var skills: String, var email: String? = null)
//
//        val user = User("Kildong", "default")
//        debug("user: $user")
//
//        val result = with(user) {
//            skills = "Kotlin"
//            email = "kildong@example.com"
//            "success"
//        }
//        debug("user: $user")
//        debug("result: $result")
//    }

//    private fun runRunExample() {
//        var skills = "Kotlin"
//        debug(skills)
//
//        val a = 10
//        skills = run {
//            var level = "Kotlin Levle: " + a
//            level
//        }
//
//        data class Person(var name: String, var skills: String)
//        val person = Person("Kildong", "Kotlin")
//        debug("person: $person")
//
//        val returnObj = person.apply {
//            this.name = "Sean"
//            this.skills = "Java"
//            "success"
//        }
//        debug("returnObj: $returnObj")
//
//        val returnObj2 = person.run {
//            this.name = "Dooly"
//            this.skills = "C#"
//            "success"
//        }
//        debug("returnObj2: $returnObj2")
//
//        debug("person == returnObj: ${person == returnObj}")
//        debug("person === returnObj: ${person === returnObj}")
//    }

//    private fun runApplyExample() {
//        data class Person(var name: String, var skills: String)
//
//        val person = Person("Kildong", "Kotlin")
//        person.apply { this.skills = "Swift" }
//
//        val returnObj = person.apply {
//            name = "Sean"
//            skills = "Java"
//        }
//
//        debug("person: $person")
//        debug("returnObj: $returnObj")
//        debug("person: $person")
//
//        fun makeDir(path: String): File {
////            # case 1
////            val result = File(path)
////            result.mkdirs()
////            return result
////            # case 2
//            return File(path).apply { mkdirs() }
//        }
//    }

//    private fun runLetAndAlsoExample() {
//        fun makeDir(path: String): File {
//            val result = File(path)
//            result.mkdirs()
//            return result
//        }
//
//        fun makeDir1(path: String) = path.let { File(it) }.also { it.mkdirs() }
//    }

//    private fun runKotlinExtensionExample() {
//        // let
//        val score: Int? = 32
//        // var score = null
//
//        fun checkScore() {
//            if (score != null) {
//                debug("Score: $score")
//            }
//            score?.let {
//                debug("checkScore $it")
//            }
//        }
//
//        fun checkScoreLet() {
//            score?.let { debug("checkScoreLet1: $it") }
//            val str = score.let { it.toString() }
//            debug("checkScoreLet2: $str")
//        }
//
//        fun letTestFunc() {
//            val a: Int? = null
//            val b = 2
//            val result = a.let { it?.plus(b) }.let { it?.plus(it) }
//            debug("$result")
//        }
//
//        fun alsoTestFunc() {
//            var m = 1
//            m = m.also { m.plus(10) }
//            debug("$m")
//        }
//
//        fun letAndAlsoTestFunc() {
//            data class Person (val name: String, var skills: String)
//            var person = Person("Kildong", "Kotlin")
//            val a = person.let {
//                it.skills = "Android"
//                "success"
//            }
//            debug("$person") // Kildong, Android
//            debug("a: $a") // success
//            val b = person.also {
//                it.skills = "Java"
//                "success"
//            }
//            debug("$person") // Kildong, Java
//            debug("b: $b") // success
//        }
//
//        checkScore()
//        debug("==============")
//        checkScoreLet()
//        debug("==============")
//        letTestFunc()
//        debug("==============")
//        alsoTestFunc()
//        debug("==============")
//        letAndAlsoTestFunc()
//    }

//    private fun runKotlinStandardExample() {
//        val calc = Calc()
//        var result = 0
//        calc.addNum(10, 20) { a, b -> result = a + b }
//        debug("result: $result")
//    }

//    class Calc {
//        fun addNum(a: Int, b: Int, add: (Int, Int) -> Unit) = add(a, b)
//    }

//    private fun runFibonacciUsingSequence() {
//        val fibonacci = generateSequence(1 to 1) { it.second to it.first + it.second }
//            .map { it.first }
//        debug("${fibonacci.take(10).toList()}")
//    }
//
//    private fun runPrimeUsingSequence() {
//        val primes = generateSequence(2 to generateSequence(3) { it + 2 }) {
//            val currSeq = it.second.iterator()
//            val nextPrime = currSeq.next()
//            nextPrime to currSeq.asSequence().filter { it % nextPrime != 0 }
//        }.map { it.first }
//        debug("${primes.take(10).toList()}")
//
//    }

//    private fun runMethodChaningExample() {
//        val list1 = listOf(1, 2, 3, 4, 5)
//        val listDefault = list1.map { debug("map($it)"); it * it }
//            .filter { debug("filter($it)"); it % 2 == 0 }
//        debug("$listDefault")
//
//        val listSeq = list1.asSequence()
//            .map { debug("map($it)"); it * it }
//            .filter { debug("filter($it)"); it % 2 == 0 }
//            .toList()
//        debug("$listSeq")
//    }

//    private fun runSequenceExample() {
//        val nums: Sequence<Int> = generateSequence(1) { it + 1 }
//        debug("${nums.take(10).toList()}")
//
//        val squares = generateSequence(1) { it + 1}.map{ it * it }
//        debug("${squares.take(10).toList()}")
//
//        val oddSquares = squares.filter { it % 2 != 0 }
//        debug("${oddSquares.take(3).toList()}")
//    }

//    private fun runSortedExampled() {
//        val unsortedList = listOf(3, 2, 7, 5)
//        debug("${unsortedList.reversed()}") //  5 7 2 3
//
//        debug("${unsortedList.sorted()}") // 2 3 5 7
//
//        debug("${unsortedList.sortedDescending()}") // 7 5 3 2
//
//        debug("${unsortedList.sortedBy { it % 3 }}") // 3 7 2 5
//        debug("${unsortedList.sortedByDescending { it % 3 }}")  // 2 5 7 3
//    }

//    private fun runCollectionMerge() {
//        val list1 = listOf(1, 2, 3, 4, 5, 6)
//        val list2 = listOf(2, 2, 3, 4, 5, 5, 6, 7)
//
//        debug("list1.union(list2): ${list1.union(list2)}")
//        debug("list1.plus(list2): ${list1.plus(list2)}")
//
//        val part = list1.partition { it % 2 == 0 }
//        debug("$part")
//        debug("${part.first}")
//        debug("${part.second}")
//
//        val partOne = part.first
//        val partTwo = part.second
//
//        val partMerged = partOne.plus(partTwo)
//        debug("$partMerged")
//
//        val zip = list1.zip(listOf(7, 8))
//        debug("$zip")
//
//        val zipOne = zip[0]
//        debug("${zipOne.first} ${zipOne.second}")
//
//        val zipTwo = zip[1]
//        debug("${zipTwo.first} ${zipTwo.second}")
//    }

//    private fun runSearchExample() {
//        val list = listOf(1, 2, 3, 4, 5, 6)
//        debug("binarySearch: ${list.binarySearch(3)}")
//        debug("find { it > 3 }: ${list.find { it > 3 }}")
//        debug("find { it > 1 }: ${list.find { it > 1 }}")
//    }

//    private fun runListIndexExample() {
//        val list = listOf(1, 2, 3, 4, 5, 6)
//        val listPair = listOf(Pair("A", 300), Pair("B", 200), Pair("C", 100))
//        val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6)
//
//        debug("indexOf: ${list.indexOf(4)}")
//        debug("indexOfFirst: ${list.indexOfFirst { it % 2 == 0 }}")
//        debug("lastIndexOf: ${listRepeated.lastIndexOf(5)}")
//        debug("indexOfLast: ${list.indexOfLast { it % 2 == 0 }}")
//
//        debug("$listPair")
//
//        try {
//            debug("single: ${listPair.single { it.second == 100 }}")
//        } catch (e: Exception) {
//            debug("${e.message}")
//        }
//
//        debug("singleOrNull: ${listPair.singleOrNull { it.second == 500 }}")
//    }

//    private fun runElementSearchExample() {
//        val list = listOf(1, 2, 3, 4, 5, 6)
//        val listPair = listOf(Pair("A", 300), Pair("B", 200), Pair("C", 100))
//        val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6)
//
//        debug("elementAt: ${list.elementAt(1)}") // 2
//
//        debug("elementAtOrElse: ${list.elementAtOrElse(11) { it / 2 }}")
//
//        debug("elementAtOrNull: ${list.elementAtOrNull(10)}")
//
//        try {
//            debug("first: ${listPair.first { it.second == 100 }}")
//            debug("last: ${listPair.last { it.second == 500 }}")
//        } catch (e: Exception) {
//            debug("${e.message}")
//        }
//
//        debug("firstOrNull: ${listPair.firstOrNull { it.first == "E" }}")
//        debug("lastOrNull: ${listPair.lastOrNull { it.first == "E" }}")
//    }

//    private fun runComponentMappingExample() {
//        val list = listOf(1, 2, 3, 4, 5, 6)
//        val listWithNull = listOf(1, null, 3, null, 5, 6)
//        debug("${list.map { it * 2 }}")
//
//        val mapIndexed = list.mapIndexed { index, value -> index * value }
//        debug("$mapIndexed")
//
//        debug("${listWithNull.mapNotNull { it?.times(2) }}")
//
//        debug("${list.flatMap { listOf(it, 'A') }}")
//
//        val result = listOf("abc", "12").flatMap { it.toList() }
//        debug("$result")
//
//        val grpMap = list.groupBy { if (it % 2 == 0) "even" else "odd" }
//        debug("$grpMap")
//        debug("${grpMap["even"]}")
//        debug("${grpMap.get("odd")}")
//    }

//    private fun runComponentExample() {
//        val list = listOf(1, 2, 3, 4, 5, 6)
//        val listRepeated = listOf(2, 3, 3, 4, 5, 5, 6)
//        debug("component1(): ${list.component1()}")
//        debug("distinct: ${listRepeated.distinct()}")
//        debug("intersect: ${list.intersect(listOf(5, 6, 7, 8))}")
//    }

//    private fun runListPracticeExample() {
//        val list = listOf(1, 2, 3, 4, 5, 6)
//        val listMixed = listOf(1, "Hello", 3, "World", 5, 'A')
//        val listWithNull = listOf(1, null, 3, null, 5, 6)
//        val listRepeated = listOf(2, 3, 3, 4, 5, 5, 6)
//        val map = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")
//
//        debug("${list.filter { it % 2 == 0 }}")
//        debug("${list.filterNot { it % 2 == 0 }}")
//        debug("${listWithNull.filterNotNull()}")
//
//        debug("filteredIndexed:  ${list.filterIndexed { idx, value -> idx != 1 && value % 2 == 0 }}")
//        val mutList =
//            list.filterIndexedTo(mutableListOf()) { idx, value -> idx != 1 && value % 2 == 0 }
//        debug("filteredIndexedTo: $mutList")
//
//        debug("filterKeys: ${map.filterKeys { it != 11 }}")
//        debug("filterValues: ${map.filterValues { it == "Java" }}")
//
//        debug("filterIsInstance: ${listMixed.filterIsInstance<String>()}")
//        debug("filterIsInstance: ${listMixed.filterIsInstance<Int>()}")
//
//        debug("slice: ${list.slice(listOf(0, 2))}") // 1, 3
//        debug("slide: ${list.slice(2..3)}") // 3, 4
//
//        debug("list.take(2): ${list.take(2)}")
//        debug("list.takeLast(2): ${list.takeLast(2)}")
//        debug("list.takeWhile { it < 3 }: ${list.takeWhile { it < 3 }}")
//
//        debug("list.drop(3): ${list.drop(3)}")
//        debug("list.dropWhile { it < 3 }: ${list.dropWhile { it < 3 }}")
//        debug("list.dropLastWhile { it > 3 }: ${list.dropLastWhile { it > 3 }}")
//
//    }

//    private fun runCollectionNoneExample() {
//        val list = listOf(1, 2, 3, 4, 5, 6)
//
//        debug("none: ${list.none()}")
//        debug("none: ${list.none { it > 5 }}")
//
//        debug("${list.isEmpty()}")
//        debug("${list.isNotEmpty()}")
//    }

//    private fun runCollectionExtensionValidationExample() {
//        val list = listOf(1, 2, 3, 4, 5, 6)
//        val listPair = listOf(Pair("A", 300), Pair("B", 200), Pair("C", 100))
//        val map = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")
//
//        debug("${list.all { it < 10 }}")
//        debug("${list.all { it % 2 == 0 }}")
//
//        debug("=====")
//        debug("${list.any { it % 2 == 0 }}")
//        debug("${list.any { it > 10 }}")
//
//        debug("=====")
//        debug("list.contains(2) " + list.contains(2))
//        debug("2 in list ${2 in list}")
//        debug("map.contains(11) ${map.contains(11)}")
//        debug("11 in map ${11 in map}")
//
//        debug("containsAll: " + list.containsAll(listOf(1, 2, 3)))
//    }

//    private fun runReturnListExample() {
//        val list = listOf(1, 2, 3, 4, 5, 6)
//        val listPair = listOf(Pair("A", 300), Pair("B", 200), Pair("C", 100))
//        val map = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")
//
//        list.forEach { debug("$it") }
//        debug("\n")
//        list.forEachIndexed { index, value -> debug("list[$index]=$value") }
//
//        val returnedList = list.onEach { it * 10 }
//        debug("\n")
//
//        val returnedMap = map.onEach { debug("key: ${it.key}, value: ${it.value}") }
//        debug("returnedList = $returnedList")
//        debug("returnedMap = $returnedMap")
//
//        debug("${list.count { it % 2 == 0 }}")
//
//        debug("max: ${list.max()}")
//        debug("min: ${list.min()}")
//
//        debug("maxBy: ${map.maxBy { it.key }}") // 6
//        debug("maxBy: ${map.minBy { it.key }}") // 1
//
//        debug("fold(4): ${list.fold(4) { total, next -> total + next }}")
//        debug("fold(1): ${list.fold(1) { total, next -> total * next }}")
//
//        debug("${list.foldRight(4) { total, next -> total + next }}")
//        debug("${list.foldRight(1) { total, next -> total * next }}")
//
//        debug("${list.reduce { total, next -> total + next }}")
//        debug("${list.reduceRight { total, next -> total + next }}")
//
//        debug("${listPair.sumBy { it.second }}")
//    }

//    private fun runCollectionExtensionExample() {
//        val list1: List<String> = listOf("one", "two", "three")
//        val list2: List<Int> = listOf(1, 3, 4)
//        val map1 = mapOf("hi" to 1, "hello" to 2, "Goodbye" to 3)
//
//        val result = list1 + "four"
//        debug("plus $result")
//
//        val result1 = list2
//        debug("plus $result1")
//
//        val result2 = list2 + listOf(5, 6, 7)
//        debug("plus $result2")
//
//        val result3 = list2 - 1
//        debug("minus $result3")
//    }

//    private fun runCollectionPracticeExample() {
//        val hashMap: HashMap<Int, String> = hashMapOf(1 to "Hello", 2 to "World")
//        debug("hasMap = $hashMap")
//
//        val sortedMap: SortedMap<Int, String> = sortedMapOf(1 to "Apple", 2 to "Banana")
//        debug("sortedMap = $sortedMap")
//
//        val linkedHash: LinkedHashMap<Int, String> = linkedMapOf(1 to "Computer", 2 to "Mouse")
//        debug("linkedHash = $linkedHash")
//    }

//    private fun runMapExample() {
//        val langMap: Map<Int, String> = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++", 11 to "aa")
//        for ((key, value) in langMap) {
//            debug("key=$key value=$value")
//        }
//
//        debug("langMap[22] = ${langMap[22]}")
//        debug("langMap.get(22) = ${langMap.get(22)}")
//        debug("langMap.keys = ${langMap.keys}")
//
//        // mutable
//        val capitalCityMap: MutableMap<String, String> =
//            mutableMapOf("Korea" to "Seoul", "China" to "Beijing", "Japan" to "Tokyo")
//        debug("${capitalCityMap}")
//        debug("${capitalCityMap.keys}")
//        debug("${capitalCityMap.values}")
//
//        capitalCityMap.put("UK", "London")
//        capitalCityMap.remove("China")
//        debug("$capitalCityMap")
//
//        val addData = mutableMapOf("USA" to "Washington")
//        capitalCityMap.putAll(addData)
//        debug("$capitalCityMap")
//    }

//    private fun runLinkedSetExample() {
//        val intsLinkedHashSet: LinkedHashSet<Int> = linkedSetOf(35, 21, 76, 26, 75)
//        intsLinkedHashSet.add(4)
//        intsLinkedHashSet.remove(21)
//        debug("$intsLinkedHashSet")
//
//        intsLinkedHashSet.clear()
//        debug("$intsLinkedHashSet")
//    }

//    private fun runTreeSetExample() {
//        val intsSortedSet: TreeSet<Int> = sortedSetOf(4, 1, 7, 2)
//        intsSortedSet.add(6)
//        intsSortedSet.remove(1)
//        debug("$intsSortedSet")
//
//        intsSortedSet.clear()
//        debug("intsSortedSet = $intsSortedSet")
//    }

//    private fun runHashSetExample() {
//        val intHashSet: HashSet<Int> = hashSetOf(6, 3, 4, 7)
//        intHashSet.add(5)
//        intHashSet.remove(6)
//        debug("$intHashSet")
//    }

//    private fun runSetMapExample() {
//        val mixedTypeSet = setOf("Hello", 5, "world", 3.14, 'c')
//        val intSet: Set<Int> = setOf(1, 5, 5)
//
//        debug("$mixedTypeSet")
//        debug("$intSet")
//
//        val animals = mutableSetOf("Lion", "Dog", "Cat", "Python", "Hippo")
//        debug("$animals")
//
//        animals.add("Dog")
//        debug("$animals")
//
//        animals.remove("Python")
//        debug("$animals")
//
//    }

//    private fun runArrayListExample() {
//        val list1: List<Int> = LinkedList()
//        val list2: List<Int> = ArrayList()
//    }

//    private fun runCollectionExample() {
//        val fruits = listOf("apple", "banana", "kiwi")
//
//        for(index in fruits.indices) {
//            debug("fruits[$index] = ${fruits[index]}")
//        }
//
//        // empty collection
//        val emptyList: List<String> = emptyList()
//
//        // listOfNotNull
//        val nonNullsList: List<Int> = listOfNotNull(2, 45, 2, null, 5, null)
//        debug("$nonNullsList")
//
//        val mutableList: MutableList<String> = mutableListOf("Kildong", "Neo", "Dooly")
//        mutableList.add("Ben")
//        debug("add, $mutableList")
//
//        mutableList.removeAt(1)
//        debug("removeAt(1), $mutableList")
//
//        mutableList[0] = "Sean"
//        debug("0 changed, $mutableList")
//
//        val mutableListMixed = mutableListOf("Android", "Apple", 5, 6, 'X')
//        debug("mixed, $mutableListMixed")
//
//        val sampleList = listOf("aaaa", "bbbb", "cccc")
//        val toMutableList = sampleList.toMutableList()
//        toMutableList.removeAt(1)
//        debug("$toMutableList")
//    }

//    private fun runStringTrimExample() {
//        val text = """ |Tell me and I forget.
//            |Teach me and I remember.
//            |Involve me and I learn.
//            |(Benjamin Franklin)
//        """.trimMargin()
//        debug(text)
//    }

//    private fun runStringExample() {
//        val hello = "Hello world" // use constant pool of java
//        debug("${hello[0]}, size=${hello.length}")
//
//        val helloChars = Array("Hello".length + 1) { ' ' }
//        helloChars[0] = 'H'
//        helloChars[1] = 'E'
//        helloChars[2] = 'L'
//        helloChars[3] = 'L'
//        helloChars[4] = 'O'
//        helloChars.forEachIndexed { i, e -> debug("helloChard[$i] = $e") }
//
//        debug(hello.substring(0..3))
//
//        val builder = StringBuilder("Hello")
//        builder.append("World") // HelloWorld
//        builder.insert(10, "Added") //HelloWorldAdded
//        builder.delete(5, 10) // HelloAdded
//        debug("output: $builder")

//        val deli = "Welcome to Kotlin"
//        val sp = deli.split(" ")
//        sp.forEach { e -> debug(e) }
//
//        val numList:MutableList<Number> = mutableListOf()
//        numList.add(10)
//        numList.add(5.5)
//        numList.forEach { e -> debug("$e") }
//    }

//    private fun runArraySimpleExample() {
//        val b = Array<Any>(10) { 0 }
//        b[0] = "Hello World"
//        b[1] = 1.1
//        debug("${b[0]}")
//        debug("${b[1]}")
//        debug("${b[2]}")

    //        val arr = arrayOf(1, 2, 3, 4, 5)
//        arr.forEach { num -> debug("$num") }
//        debug("====================")
//        arr.forEachIndexed { i, e -> debug("arr[$i] = $e") }
//        debug("====================")
//        val iter: Iterator<Int> = arr.iterator()
//        while(iter.hasNext()) {
//            val e = iter.next()
//            debug("$e")
//        }
//        debug("====================sortDescending")
//        arr.sortDescending()
//        arr.forEach { e -> debug("$e") }
//        debug("====================sort")
//        arr.sort()
//        arr.forEach { e -> debug("$e") }
//        debug("====================sortedDescending")
//        val descendSortedArray = arr.sortedDescending()
//        descendSortedArray.forEach { e -> debug("$e") }
//        debug("====================sorted")
//        val sortedArray = arr.sorted()
//        sortedArray.forEach { e -> debug("$e") }
//
//        val items = arrayOf("Dog", "Cat", "Lion", "Kangaroo", "Po")
//        items.sortDescending()
//        debug(items.contentToString())
//
//        debug("====================products")
//        data class Product(val name: String, val price: Double) : Comparable<Product> {
//            override fun compareTo(other: Product): Int {
//                return price.toInt() - other.price.toInt()
//            }
//        }
//
//        val products = arrayOf(
//            Product("Snow Ball", 870.00),
//            Product("Smart Phone", 999.00),
//            Product("Drone", 240.00),
//            Product("Mouse", 333.55),
//            Product("Keyboard", 125.99),
//            Product("Monitor", 1500.99),
//            Product("Tablet", 512.99),
//        )

//        products.sortBy { e -> e.price }
//        products.sort()
//        products.forEachIndexed { i, e -> debug("products[$i] $e") }
//        products.forEach { e -> debug("$e") }


    // sort with example
//        products.sortWith( Comparator { p1, p2 ->
//            when {
//                p1.price > p2.price -> 1
//                p1.price == p2.price -> 0
//                else -> -1
//            }
//        })
//        products.sortWith(compareBy({it.name}, {it.price}))
//        products.forEach { e -> debug("$e") }

//        val arr = arrayOf(1, -1, 3, 4, -5, 0)
//        arr.filter { e -> e > 0 }.forEach { e -> debug("$e") }
//
//        val fruits = arrayOf("banana", "avocado", "apple", "kiwi")
//        fruits.filter { it.startsWith("a") }
//            .sortedBy { it }
//            .map { it.toUpperCase() }
//            .forEach { debug(it) }
//
//        debug("${products.minBy { it.price }}")
//        debug("${products.maxBy { it.price }}")
//
//        val numbers = arrayOf(1, 2, 3)
//        val strs = arrayOf("one", "two", "three")
//        val simpleArray = arrayOf(numbers, strs)
//        simpleArray.forEach { debug("$it") }
//
//        val flattenSimpleArray = simpleArray.flatten()
//        debug("$flattenSimpleArray")
//
//    }

//    private fun runArrayClassExample() {
//        val arr = Array(5) { i -> i * 2 }
//        debug(arr.contentToString())
//
//        val a = arrayOfNulls<Int>(1000)
//        val a1 = Array(100) { 0 }
//        if (a.contentEquals(a1)) {
//            debug("equal")
//        } else {
//            debug("not equal")
//        }
//        debug("${a[0]}")
//        debug("${a1[0]}")
//
//        var aa = Array(1000) { i -> myClass(i + 1) }
//        debug("${aa[0]}")
//
//        var aaa = intArrayOf(1, 2, 3, 4, 5)
//        var bbb = aaa.plus(6)
//        debug(Arrays.toString(aaa))
//        debug(Arrays.toString(bbb))
//
//        val arr3 = aaa.sliceArray(0..2)
//        debug(Arrays.toString(arr3))
//
//        val _arr = arrayOf(1, 2, 3, 4, 5)
//        debug("first: ${_arr.first()}")
//        debug("last: ${_arr.last()}")
//        debug("indexOf(3): ${_arr.indexOf(3)}")
//        debug("average: ${_arr.average()}")
//        debug("count: ${_arr.count()}")
//        debug("${6 in _arr}")
//    }
//
//    class myClass(val num: Int) {
//        override fun toString(): String = "myClass num=$num"
//    }

//    private fun runDeepToStringExample() {
//        val array = arrayOf(
//            intArrayOf(1, 2),
//            intArrayOf(3, 4),
//            intArrayOf(5, 6, 7)
//        )
//        debug(Arrays.toString(array))
//        debug(Arrays.deepToString(array))
//    }

//    private fun runArrayDeclareExample() {
//        val arr = intArrayOf(1, 2, 3, 4, 5)
//
//        debug("arr: ${Arrays.toString(arr)}")
//        debug("size: ${arr.size}")
//        debug("sum(): ${arr.sum()}")
//
//        debug("${arr.get(2)}")
//        debug("${arr[2]}")
//
//        arr.set(2, 7)
//        arr[0] = 8
//        debug("size: ${arr.size} arr[0]: ${arr[0]}, arr[2]: ${arr[2]}")
//        debug(Arrays.toString(arr))
//
//        for (i in 0..arr.size-1) {
//            debug("${arr[i]}")
//        }
//    }

//    private fun runArraySampleExample() {
//        val array = intArrayOf(5, 0, 2, 5)
//        val ele = array.get(0)
//        val ele1 = array[0]
//
//        debug("$ele, $ele1")
//
//        val array2d = arrayOf(
//            arrayOf(1, 2, 3),
//            arrayOf(4, 5, 6),
//            arrayOf(7, 8, 9)
//        )
//
//        debug("${array2d[2][1]}")
//
//        array2d[2][1] = 55
//        debug("${array2d[2][1]}")
//
//        for (i in 0..arr.size-1) {
//
//        }
//    }

//    private fun runIntArrayExample(){
//        val intOnlyArr1 = arrayOf<Int>(4, 5, 7, 3)
//        val intOnlyArr2 = intArrayOf(4, 5, 7, 3, 1)
//        debug("arraOf")
//        for(e in intOnlyArr1) {
//            debug("$e")
//        }
//        debug("intArraOf")
//        for(e in intOnlyArr2) {
//            debug("$e")
//        }
//    }

//    private fun runMixArrayExample() {
//        val mixArr = arrayOf(4, 5, 7, 3, "Chike", false)
//        for(e in mixArr) {
//            debug("$e")
//        }
//    }

//    private fun run2DArrayExample() {
//        val array1 = arrayOf(1, 2, 3)
//        val array2 = arrayOf(4, 5, 6)
//        val array3 = arrayOf(7, 8, 9)
//        val arr2d = arrayOf(array1, array2, array3)
//        for(ele in arr2d) {
//            for(e in ele) {
//                debug("$e")
//            }
//        }
//    }

//    private fun runInterfaceGenericClassExample() {
//        val obj1 = ClassA<HandlerA>()
//        val obj2 = ClassA<HandlerB>()
//    }
//
//    interface InterfaceA
//    interface InterfaceB
//
//    class HandlerA: InterfaceA, InterfaceB
//    class HandlerB: InterfaceA, InterfaceB
//
//    class ClassA<T> where T: InterfaceA, T: InterfaceB

//    private fun typeLimitGenericExample() {
//        debug("${sum(10, 20, {a, b -> a + b})}")
//        debug("${sum(30, 20, {a, b -> a + b})}")
//    }
//
//    fun <T: Number> sum(a: T, b: T, op: (a: T, b: T) -> T): T {
//        return op(a, b)
//    }

//    private fun runCalcGenericExample() {
//        val calc = Calc<Int>()
//        debug("${calc.plus(10, 20)}")
//
//        val calc2 = Calc<Double>()
//        val calc3 = Calc<Long>()
//        // val calc4 = Calc<String>()
//
//        debug("${calc2.plus(2.5, 3.5)}")
//        debug("${calc3.plus(5L, 10L)}")
//    }
//
//    class Calc<T: Number> {
//        fun plus(arg1: T, arg2: T): Double {
//            return arg1.toDouble() + arg2.toDouble()
//        }
//    }

//    private fun runLambdaGenericExample() {
//        fun <T> sumGeneric(a: T, b: T, op: (a: T, b: T) -> T): T {
//            return op(a, b)
//        }
//
//        fun sum(a: Int, b: Int) = a + b
//        val sum1: (Int, Int) -> Int = { a, b -> a + b }
//        val sum2: (a: Int, b: Int) -> Int = { a, b -> a + b }
//
//        debug("1 ${sum(10, 20)}")
//        debug("2 ${sum1(10, 20)}")
//        debug("3 ${sum2(10, 20)}")
//        debug("4 ${sumGeneric(10, 20, { a, b -> a + b })}")
//    }

//    private fun runGenericArrayExample() {
//        val arr1: Array<String> = arrayOf("Apple", "Banana", "Cherry", "Durian")
//        val arr2: Array<Int> = arrayOf(1, 2, 3, 4)
//
//        debug("arr.indices ${arr1.indices}")
//        debug("${find<String>(arr1, "Cherry")}")
//        debug("${find(arr2, 5)}")
//    }
//
//    fun <T> find(a: Array<T>, target: T): Int {
//        for(data in a.indices) {
//            if(data == target) return data
//        }
//        return -1
//        for (i in a.indices) {
//            if (a[i] == Target) return i
//        }
//        return -1
//    }

//    private fun runSimpleGenericExample() {
//        val obj = GenericNull<String>()
//        obj.EqualityFunc("Hello", "World")
//
//        val obj2 = GenericNull<Int?>()
//        obj2.EqualityFunc(null, 10)
//    }
//
//    class GenericNull<T> {
//        fun EqualityFunc(arg1: T, arg2: T) {
//            Log.d(TAG, "${arg1 == arg2}")
//        }
//    }

//    private fun runGenericMyclassExample() {
//        val a = MyClass<Int>(12)
//        debug("${a.myProp}")
//        debug("${a.javaClass}")
//    }
//
//    class MyClass<T>(val myProp: T)

//    private fun runGenericBoxExample() {
//        val box1: Box<Int> = Box(1)
//        val box2: Box<String> = Box("Hello")
//        debug("${box1.name}")
//        debug(box2.name)
//    }
//
//    class Box<T>(t: T) {
//        var name = t
//    }

//    private fun runContainsExample() {
//        val i = 5
//
//        if (i in 1..10) {
//            debug("1 <= $i <= 10")
//        }
//
//        for (i in 1..4) debug("$i")
//
//        val findNum = 10
//        val array = arrayOf(10, 2, 3, 5)
//        if (array.contains(findNum)) {
//            debug("array contains $findNum")
//        } else {
//            debug("array not contain $findNum")
//        }
//    }

//    private fun runUnaryExample() {
//        val point = Point(10, 20)
//        debug("${-point}")
//    }
//
//    data class Point(val x: Int, val y: Int)
//    operator fun Point.unaryMinus() = Point(-x, -y)

//    class Manager {
//        operator fun invoke(value: String) {
//            Log.d(TAG, value)
//        }
//        fun test() {
//            val sum = { x: Int, y: Int -> x + y}
//            Log.d(TAG, "result: ${sum(3, 10)} ${sum.invoke(3, 10)}")
//        }
//    }

//    private fun runOperatorOverrideExample() {
//        // a + b, a.plus(b)
//        // a - b, a.minus(b)
//        // a * b, a.times(b)
//        // a / b, a.div(b)
//        // a % b, a.rem(b)
//        // a.b, a.rangeTo(b)
//
//        val p1 = Point(3, -8)
//        val p2 = Point(2, 9)
//
//        var point = p1 + p2
//        debug("point = ${point.x}, ${point.y}")
//
//        val decPoint = point--
//        debug("decPoint = ${decPoint.x}, ${decPoint.y}")
//    }
//
//    class Point(var x: Int = 0, var y: Int = 10) {
//        operator fun plus(p: Point): Point {
//            return Point(x + p.x, y + p.y)
//        }
//        operator fun dec() = Point(--x, --y)
//    }

//    private fun runReflectionExample() {
//        debug("${User::class}")
//        val classInfo = User::class
//        classInfo.members.forEach {
//            debug("Property name: ${it.name}, type: ${it.returnType}")
//        }
//        debug("${classInfo.qualifiedName}")
//    }
//
//    class User(val id: Int, val name: String, var grade: String = "Normal") {
//        fun check() {
//            if (grade == "Normal") {
//                Log.d(TAG, "You need to get the Silver grade")
//            }
//        }
//    }

//    private fun runEnumInterfaceClassExample() {
//        debug("${MemberType.NORMAL.getScore()}") // 100
//        debug("${MemberType.GOLD}") // first
//        debug("${MemberType.valueOf("SILVER")}") // 1
//        debug(MemberType.SILVER.prio) // Second
//
//        for(grade in MemberType.values()) {
//            debug("grade.name = ${grade.name}, prio = ${grade.prio}")
//        }
//    }
//
//    interface Score {
//        fun getScore(): Int
//    }
//
//    enum class MemberType(var prio: String): Score {
//        NORMAL("Third") {
//            override fun getScore(): Int = 100
//        },
//        SILVER("Second") {
//            override fun getScore(): Int = 500
//        },
//        GOLD("First") {
//            override fun getScore(): Int = 1500
//        }
//    }

//    private fun runEnumClassExample() {
//        val day = DayOfWeek.SATURDAY
//        when(day.num) {
//            in 1..5 -> debug("Weekday")
//            else -> debug("Weekend")
//        }
//
//        val direct = Direction.WEST
//        debug("direction WEST: ${direct.name} ${direct.ordinal}")
//    }
//
//    enum class Direction {
//        NORTH, SOUTH, WEST, EAST
//    }
//
//    enum class DayOfWeek(val num: Int) {
//        MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4),
//        FRIDAY(5), SATURDAY(6), SUNDAY(7)
//    }

//    private fun runSealClassExample() {
//        val result = Result.Success("Good")
//        val msg = eval(result)
//        debug(msg)
//    }
//
//    fun eval(result: Result): String = when(result) {
//        is Status = "in progress"
//        is Result.Success -> result.message
//        is Result.Error -> result.message
//    }
//
//    sealed class Result {
//        open class Success(val message: String): Result()
//        class Error(val code: Int, val message: String): Result()
//    }
//
//    class Status: Result()
//    class Inside: Result.Success("Status")

//    private fun runAnonymousClassExample() {
//        val phone = SmartPhone("ZFlip")
//        debug(phone.powerOn())
//    }
//
//    interface Switcher {
//        fun on(): String
//    }
//
//    class SmartPhone(val model: String) {
//        fun powerOn(): String {
//            class Led(val color: String) {
//                fun blink(): String = "Blinking $color on $model"
//            }
//            val powerStatus = Led("Red")
//            val powerSwitch = object: Switcher {
//                override fun on(): String {
//                    return powerStatus.blink()
//                }
//            }
//            return powerSwitch.on()
//        }
//    }

//    private fun localClassExample() {
//        val myPhone = Smartphone("Note9")
//        myPhone.ExternalStorage(128)
//        debug(myPhone.powerOn())
//    }
//
//    class Smartphone(val model: String) {
//        private val cpu = "Exynos"
//
//        inner class ExternalStorage(private val size: Int) {
//            fun getInfo() = "${model}: Installed on $cpu with ${size}Gb"
//        }
//
//        fun powerOn(): String {
//            class Led(val color: String) {
//                fun blink(): String = "Blinking $color on $model"
//            }
//            val powerStatus = Led("Red")
//            return powerStatus.blink()
//        }
//    }

//    private fun runOuterClassExample() {
//        val output = Outer.Nested().greeting()
//
//        // Outer.outside()
//        val outer = Outer()
//        outer.outside()
//
//        val nested = Outer.Nested()
//        nested.greeting()
//    }
//
//    class Outer {
//        val ov = 5
//
//        class Nested {
//            val nv = 10
//            fun greeting() {
//                Log.d(TAG, "[Nested] Hello ! $nv")
//                getSomething()
//            }
//        }
//
//        fun outside() {
//            val msg = Nested().greeting()
//            Log.d(TAG, "[Outer]: $msg, ${Nested().nv}")
//        }
//
//        companion object {
//            const val country = "Korea"
//            fun getSomething() = Log.d(TAG, "Get something..")
//        }
//    }

//
//    class A {
//        val a = 10
//        fun test1() {
//        }
//
//        class B {
//            val b = 20
//
//            fun test2() {
//            }
//        }
//    }

    private fun runDataClassExample() {
//        val cus1 = Customer("Sean", "sean@gmail.com")
//        val cus2 = Customer("Sean", "sean@gmail.com")
//
//        debug("${cus1 == cus2}")
//        debug("${cus1.equals(cus2)}")
//        debug("${cus1.hashCode()}, ${cus2.hashCode()}")
//        debug("${cus1.hashCode() == cus2.hashCode()}")
//
//        val cus3 = cus1.copy(name = "Alice")
//        debug("$cus1")
//        debug("$cus3")
//
//        val (name, email) = cus1
//        debug("$name, $email")
//
//        val (_, email) = cus3
//        debug(email)
//
//        val name2 = cus1.component1()
//        val email2 = cus1.component2()
//        debug("name=$name2, email=$email2")

        val cus1 = Customer("Sean", "sean@mail.com")
//        val cus2 = Customer("Sean", "sean@mail.com")
//        val bob = Customer("Bob", "bob@mail.com")
//        val erica = Customer("Erica", "sean@mail.com")
//
//        val customers = listOf(cus1, cus2, bob, erica)
//
//        for ((name, email) in customers) {
//            debug("$name, $email")
//        }
//
//        fun myFunc() = Customer("Mickey", "mic@abc.com")
//        val (name, email) = myFunc()
//        debug("$name, $email")

        val myLambda = { (nameLa, emailLa): Customer ->
            debug(nameLa)
            debug(emailLa)
        }
        myLambda(cus1)
    }

    data class Customer(var name: String, var email: String) {
        var job: String = "Unknown"

        constructor(name: String, email: String, _job: String) : this(name, email) {
            job = _job
        }

        init {
            // simple logic
        }
    }

//    private fun runCoffeeExample() {
//        val coffeeMaker = CoffeeMaker(MyDripCoffeeModule())
//        coffeeMaker.brew()
//    }
//
//    interface Heater {
//        fun on()
//        fun off()
//        fun isHot(): Boolean
//    }
//
//    class ElectronicHeater(var heating: Boolean = false) : Heater {
//        override fun on() {
//            Log.d(TAG, "[ElictronicHeater] heating...")
//            heating = true
//        }
//
//        override fun off() {
//            heating = false
//        }
//
//        override fun isHot(): Boolean = heating
//    }
//
//    interface Pump {
//        fun pump()
//    }
//
//    class Thermosiphon(heater: Heater) : Pump, Heater by heater {
//        override fun pump() {
//            if (isHot()) {
//                Log.d(TAG, "[Thermosiphon] pumping...")
//            }
//        }
//    }
//
//
//    interface CoffeeModule {
//        fun getThermosiphon(): Thermosiphon
//    }
//
//    class MyDripCoffeeModule : CoffeeModule {
//        companion object {
//            val elictronicHeater: ElectronicHeater by lazy {
//                ElectronicHeater()
//            }
//        }
//
//        private val _thermosiphon: Thermosiphon by lazy {
//            Thermosiphon(elictronicHeater)
//        }
//
//        override fun getThermosiphon(): Thermosiphon = _thermosiphon
//    }
//
//
//    class CoffeeMaker(val coffeeModule: CoffeeModule) {
//        fun brew() {
//            val theSiphon: Thermosiphon = coffeeModule.getThermosiphon()
//            theSiphon.on()
//            theSiphon.pump()
//            Log.d(TAG, "Coffee, here! Enjoy!~")
//            theSiphon.off()
//        }
//    }


//    class Person(name: Nameable, work: Runnable): Nameable by name, Runnable by work
//
//    interface Nameable {
//        var name: String
//    }
//
//    class StaffName: Nameable {
//        override var name: String = "Sean"
//    }
//
//    class Work: Runnable {
//        override fun run() {
//            Log.d(TAG, "work...")
//        }
//    }

//    interface A {
//        fun funtionA()
//    }
//
//    interface B {
//        fun functionB()
//    }
//
//    class C(val a: A, val b: B) {
//        fun funtionC() {
//            a.funtionA()
//            b.functionB()
//        }
//    }
//
//    class DelegatedC(a: A, b: B): A by a, B by b {
//        fun functionC() {
//            funtionA()
//            functionB()
//        }
//    }

//    private fun runInterfaceExample2() {
//        val master = Master()
//        val dog = Dog("Toto", "Small")
//        val cat = Cat("Coco", "BigFat")
//        master.playWithPet(dog)
//        master.playWithPet(cat)
//    }
//
//    open class Animal(val name: String)
//
//    class Dog(name: String, override var category: String): Pet, Animal(name) {
//        override fun feeding() {
//            Log.d(TAG, "Feed the dog a bone")
//        }
//    }
//
//    class Master {
//        fun playWithPet(dog: Dog) {
//            Log.d(TAG, "Enjoy with my dog.")
//            dog.feeding()
//        }
//        fun playWithPet(cat: Cat) {
//            Log.d(TAG, "Enjoy with my cat.")
//            cat.feeding()
//        }
//    }

//    private fun runInterfaceExample() {
//        val obj = Cat("small")
//        debug("Pet Categoryy: ${obj.category}") // Pet Category: small
//        obj.feeding() // Feed the cat a tuna can!
//        obj.patting() // Keep patting
//    }
//
//    interface Pet {
//        var category: String
//        fun feeding()
//        fun patting() {
//            Log.d(TAG, "Keep patting")
//        }
//    }
//
//    class Cat(name: String, override var category: String): Pet, Animal(name) {
//        override fun feeding() {
//            Log.d(TAG, "Feed the cat a tuna can!")
//        }
//    }

//    private fun runObjectExpressionExample() {
//        val pretendedMan = object: Superman() {
//            override fun fly() {
//                debug("I'm not a real superman. I cant' fly!")
//            }
//        }
//        pretendedMan.work()
//        pretendedMan.talk()
//        pretendedMan.fly()
//
//        val test = C()
//
//        fun foo() {
//            val adHoc = object {
//                var x: Int = 0
//                var y: Int = 0
//            }
//            debug("${adHoc.x + adHoc.y}")
//        }
//
//    }
//
//    class C {
//        private fun foo() = object { val x: String = "x" }
//        fun publicFoo() = object { val x: String = "x"}
//        fun bar() {
//            val x1 = foo().x // anonymous class, possible access to props
////            val x2 = publicFoo() // Any class No possible access to props
//        }
//    }
//
//    open inner class Superman {
//        fun work() = debug("Taking photos")
//        fun talk() = debug("Talking with people")
//        open fun fly() = debug("Flying in the air.")
//    }

//    private fun runCompanionExample() {
//        OCustomer.greeting()
//        OCustomer.name = "Dooly"
//        debug("name = ${OCustomer.name}")
//        debug(OCustomer.HOBBY.name)
//
//        CCustomer.greeting()
//        debug("name = ${CCustomer.name}, HELLO = ${CCustomer.HELLO}")
//        debug(CCustomer.HOBBY.name)
//    }
//
//    object OCustomer {
//        var name = "Kildong"
//        fun greeting() = Log.d(TAG, "Hello world!")
//        val HOBBY = Hobby("Basketball")
//        init {
//            Log.d(TAG, "init!")
//        }
//    }
//
//    class CCustomer {
//        companion object {
//            const val HELLO = "hello"
//            var name = "Joosol"
//            @JvmField val HOBBY = Hobby("Football")
//            @JvmStatic fun greeting() = Log.d(TAG, "Hello world!")
//        }
//    }
//
//    class Hobby(val name: String)

//    private fun runStaticExample() {
//        debug(Person.language)
//        Person.language = "English"
//        debug(Person.language)
//        Person.work()
//        // debug(Person.name)
//    }
//
//    class Person {
//        var id: Int = 0
//        var name: String = "Youngdeok"
//        companion object {
//            var language: String = "Korean"
//            fun work() { Log.d(MainActivity.TAG, "working...") }
//        }
//    }

//    private fun runNotifyDataUsingVetoableExample() {
//        var data: List<Any> by Delegates.vetoable(listOf()) {
//                prop, old, new ->
//                //notifyDataSetChagned()
//                old != new
//        }
//
//        // apdater.data = ...
//    }
//
//    private fun runVetoableExample() {
//        var max: Int by Delegates.vetoable(0) {
//                prop, old, new->
//            new > old
//        }
//
//        debug("$max")
//        max = 10
//        debug("$max")
//
//        max = 11
//        debug("$max")
//    }

//    inner class User {
//        var name: String by Delegates.observable("NONAME") {
//            property, oldValue, newValue ->
//            debug("$oldValue -> $newValue")
//        }
//    }

//    interface Car {
//        fun go(): String
//
//        fun main() {
//            val myDamas = CarModel("Damas 2010", VanImpl("100hp"))
//            val my350z = CarModel("350Z 2008", SportImpl("350hp"))
//
//            myDamas.carInfo()
//            my350z.carInfo()
//        }
//    }
//
//    inner class VanImpl(val power: String) : Car {
//        override fun go(): String = "go of VanImple have $power power"
//    }
//
//    inner class SportImpl(val power: String) : Car {
//        override fun go(): String = "For racing have $power power"
//    }
//
//    inner class CarModel(val model: String, impl: Car): Car by impl {
//        fun carInfo() {
//            debug("$model ${go()}")
//        }
//    }

//    private fun runDelegateExample() {
//        val cat = Cat()
//        class Robot: Animal by cat
//        val robot = Robot()
//        robot.eat()
//    }
//
//    interface Animal {
//        fun eat()
//    }
//
//    inner class Cat: Animal {
//        override fun eat() { debug("eat of Cat called") }
//    }
//
//    inner class LazyTest1 {
//        fun runExample() {
//            var isPersonInstantiated: Boolean = false
//
//            val person: Person by lazy {
//                isPersonInstantiated = true
//                Person("Kim", 23)
//            }
//
//            val personDelegate = lazy { Person("Hong", 40) }
//
//            debug("person init: $isPersonInstantiated")
//            debug("personDelegate Init: ${personDelegate.isInitialized()}")
//
//            debug("person.name = ${person.name}")
//            debug("personDelegate.value.name = ${personDelegate.value.name}")
//
//            debug("persopn init: $isPersonInstantiated")
//            debug("personDelegate init: ${personDelegate.isInitialized()}")
//        }
//    }
//
//    inner class LazyTest {
//        init {
//            debug("init block")
//        }
//
//        val subject by lazy {
//            debug("lazy initialzied")
//            "Kotlin programming"
//        }
//
//        fun flow() {
//            debug("Not initialized")
//            debug("subject one: $subject")
//            debug("subject two: $subject")
//        }
//    }
//
//    private fun runLateinitExample() {
//        val kildong = Person1()
//        kildong.test()
//        kildong.name = "Kildong"
//        kildong.test()
//        debug("name = ${kildong.name}")
//    }
//
//    inner class Person1 {
//        lateinit var name: String
//        fun test() {
//            if (::name.isInitialized) {
//                debug("Not initialized")
//            } else {
//                debug("initialized")
//            }
//        }
//    }
//
//    private fun runFakeAgeExample() {
//        val kim = FakeAge()
//        kim.age = 15
//        debug("Kim's real age = 15, pretended age = ${kim.age}")
//
//        val hong = FakeAge()
//        hong.age = 35
//        debug("Hong's real age = 35, pretended age = ${hong.age}")
//    }
//
//    open inner class FakeAge {
//        var age = 0
//            set(value) = when {
//                value < 18 -> field = value - 3
//                value in 18..30 -> field = value
//                else -> field = value + 3
//            }
//    }
//
//    open inner class First {
//        open val x: Int = 0
//            get() {
//                debug("First x")
//                return field
//            }
//        val y: Int = 0
//    }
//
//    open inner class Second : First() {
//        override val x: Int = 0
//            get() {
//                debug("Second x")
//                return field + 3
//            }
//    }

//    inner class User(_id: Int, _name: String, _age: Int) {
//        val id: Int = _id
//        private var tempName: String? = null
//        var name: String = _name
//            get() {
//                if(tempName == null) tempName = "NONAME"
//                return tempName ?: throw AssertionError("Asserted by others")
//            }
//        var age: Int = _age
//    }

//    inner class User(_id: Int, _name: String, _age: Int) {
//        val id: Int = _id
//
//        var name: String = _name
//            get() {
//                debug("name getter")
//                return field
//            }
//            set(value) {
//                debug("name setter, $value")
//                field = value
//            }
//
//        var age: Int = _age
//            get() = field
//    }

    private fun runCarExample() {
        // var car = Car()
//        val tico = Tico("kildong", true)
//        tico.access("gotico")
//
//        val burglar = Burglar()
//        burglar.steal(tico)
    }

    //    inner open class Car protected constructor(
//        _year: Int,
//        _model: String,
//        _power: String,
//        _wheel: String
//    ) {
//        private var year: Int = _year
//        public var model: String = _model
//        protected open var power: String = _power
//        internal var wheel: String = _wheel
//
//        protected fun start(key: Boolean) {
//            if (key) Log.d(MainActivity.TAG, "Start the engine!")
//        }
//
//        inner class Driver(_name: String, _license: String) {
//            private var name: String = _name
//            var license: String = _license
//            internal fun driving() = Log.d(TAG, "[Driver] Driving() - $name")
//        }
//    }
//
//    inner class Tico(
//        _year: Int,
//        _model: String,
//        _power: String,
//        _wheel: String,
//        var name: String,
//        private var key: Boolean
//    ) : Car(_year, _model, _power, _wheel) {
//        override var power: String = "50hp"
//        val driver = Driver(name, "first class")
//
//        constructor(_name: String, _key: Boolean) : this(
//            2014,
//            "basic",
//            "100hp",
//            "normal",
//            _name,
//            _key
//        ) {
//            name = _name
//            key = _key
//        }
//
//        fun access(password: String) {
//            if (password == "gotico") {
//                Log.d(MainActivity.TAG, "----[Tico] access()----")
//                // super.year
//                Log.d(MainActivity.TAG, "suepr.model = ${super.model}")
//                Log.d(MainActivity.TAG, "suepr.power= ${super.power}")
//                Log.d(MainActivity.TAG, "suepr.wheel= ${super.wheel}")
//                super.start(key)
//
//                // driver.name
//                Log.d(MainActivity.TAG, "Driver().license = ${driver.license}")
//                driver.driving()
//            } else {
//                Log.d(MainActivity.TAG, "You're a burglar")
//            }
//        }
//    } // end of Tico class
//
//    class Burglar() {
//        fun steal(anycar: Any) {
//            if (anycar is Tico) {
//                Log.d(MainActivity.TAG, "----[Burglar] steal()----")
//                // Log.d(MainActivity.TAG, "${anycar.power}")
//                // Log.d(MainActivity.TAG, "${anycar.year}")
//                Log.d(MainActivity.TAG, "anycar.name = ${anycar.name}")
//                Log.d(MainActivity.TAG, "anycar.wheel = ${anycar.wheel}")
//                Log.d(MainActivity.TAG, "anycar.model= ${anycar.model}")
//
//                Log.d(MainActivity.TAG, "${anycar.driver.license}")
//                anycar.driver.driving()
//                // Log.d(MainActvitiy.TAG, "${Car.start()}")
//                anycar.access("dontknow")
//            } else {
//                Log.d(MainActivity.TAG, "Nothing to steal")
//            }
//        }
//    }
//
//    private inline fun inlineSubFunction(a: Int, out: (x: Int) -> Unit) {
//        debug("Before function call")
//        out(a)
//        debug("After function call")
//    }
//
//    private fun inlineFunctionTest() {
//        inlineSubFunction(10) { a -> debug("$a") }
//        inlineSubFunction(20) { a -> debug("$a") }
//        inlineSubFunction(30, fun(x) = debug("$x"))
//    }
//
//    private fun forLoopTest() {
//        // *****
//        // ****
//        // ***
//        // **
//        // *
//        for (i in 4 downTo 0) {
//            var star = ""
//            for (j in 0..i) {
//                star += "*"
//            }
//            textView.append("$star\n")
//        }
//        textView.append("\n\n")
//
//        //  *
//        // ***
//        //*****
//        // ***
//        //  *
//        var isReserve = false
//        var starCount = 0
//        var skipCount = 0
//        val max = 5
//        for (i in 0 until max) {
//            var line = ""
//
//            if (!isReserve) {
//                starCount = 2 * (i + 1) - 1
//                skipCount = 2 - i
//            } else {
//                starCount = 2 * (max - i) - 1
//                skipCount = (i + 1) - 3
//            }
//
//            // skip space
//            for (j in 0 until skipCount) {
//                line += " "
//            }
//
//            // add star
//            for (j in 0 until starCount) {
//                line += "*"
//            }
//
//            textView.append("${line}\n")
////            debug(line)
//
//            if (i == 2) {
//                isReserve = true
//            }
//        }
//
//        val n = 2
//        ((0 until n) + (n downTo 0)).forEach {
////            debug("${" ".repeat(n - it)}*${"*".repeat(2 * it)}")
//        }
//
//        ((0 until 2) + (2 downTo 0)).forEach {
////            debug("${it}")
//        }
//    }
//
//    private fun ifTest() {
//        val score = 59.9
//        var grade: Char? = null
//        if (score >= 90) {
//            grade = 'A'
//        } else if (score in 80.0..89.9) {
//            grade = 'B'
//        } else if (score in 69.0..79.9) {
//            grade = 'C'
//        }
//        debug("Grade:${grade ?: 'D'}")
//    }
//
//    private fun infixFunctionTest() {
//        infix fun Int.multiply(a: Int) = this * a
//
//        val result = 3 multiply 3
//        debug("result: ${result}")
//    }
//
//    private fun anonymousFuntionTest() {
//        val sum = fun(x: Int, y: Int): Int = x + y
//        val add: (Int, Int) -> Int = fun(a, b) = a + b
//        debug("add(10,2): ${add(10, 2)}, sum(1,3):${sum(1, 3)}")
//        val add2 = { a: Int, b: Int -> a + b }
//        debug("${add2(30, 4)}")
////        val person = Person("Anne")
//        val name = "Neo"
//        val age = 34
//        val isAdult = true
////        person.printSpdn()
////        name.printSpdn()
//        age.printSpdn()
//        isAdult.printSpdn()
//    }
//
//    fun Any.printSpdn() {
//        debug("print spdn")
//    }
//
//    private fun lambdaThreadTest() {
//        var sharable = 1
//
//        val lock = ReentrantLock()
//        val taskFunc = { sharable += 1 }
//        val threadFunc: (ReentrantLock, () -> Unit) -> Unit = { lock, task ->
//            lock.lock()
//            try {
//                task()
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//            lock.unlock()
//        }
//        val threadFunc1 = { lock: ReentrantLock, task: () -> Unit ->
//            lock.lock()
//            try {
//                task()
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//            lock.unlock()
//        }
//        threadFunc(lock, taskFunc)
//        threadFunc1(lock, taskFunc)
//        threadFunc(lock, taskFunc)
//        threadFunc1(lock, taskFunc)
//        threadFunc(lock, taskFunc)
//        threadFunc1(lock, taskFunc)
//
//        debug("sharable: ${sharable}")
//    }
//
//    private fun practiceLambda() {
//        val sum = { a: Int, b: Int -> a + b }
//        val mul = { a: Int, b: Int -> a * b }
//        val res1 = sum(3, 2)
//        val res2 = mul(sum(3, 3), 3)
//        debug("res1:${res1} res2:${res2}")
//
//        val greet = { debug("greet: Hello World") }
//        val greet2: () -> Unit = { debug("greet2: Hello world!") }
//        greet()
//        greet2()
//
//        val square: (Int) -> Int = { x -> x * x }
//        val square2 = { x: Int -> x * x }
//        debug("square: ${square(10)} square2: ${square2(20)}")
//
//        // netsted
//        val nestedLambum: () -> () -> Unit = { { debug("nested1") } }
//        val nestedLambda2 = { { debug("nested2") } }
//        nestedLambum()()
//        nestedLambda2()()
//
//        fun _sum(a: Int, b: Int) = a + b
//        val __sum = { a: Int, b: Int -> a + b }
//        fun paramFunc(a: Int, b: Int, sum: (Int, Int) -> Int): Int {
//            return sum(a, b)
//        }
//        debug("${paramFunc(2, 3, ::_sum)}")
//        debug("${paramFunc(4, 5, __sum)}")
//
//
//        fun noParam(out: () -> String) = debug(out())
//        noParam({ "No param test1" })
//        noParam { "No param test2" }
//
//        fun twoLambda(first: (String, String) -> String, second: (String) -> String) {
//            debug("first: ${first("OneParam", "TwoParam")}")
//            debug("second: ${second("OneParam")}")
//        }
//        twoLambda({ a, b -> a + b }, { a -> a })
//        twoLambda({ a, b -> "two $a$b" }) { a -> "two $a" }
//    }
//
//    private fun printManyArgs(vararg nums: Int) {
//        debug("size: ${nums.size}")
//        for (num in nums) {
//            debug("$num")
//        }
//    }
//
//    private fun highFunc(sum: (Int, Int) -> Int, a: Int, b: Int): Int = sum(a, b)
//
//    private fun printFunDefaultParamter(a: Int = 10, b: Int) {
//        debug("a=${a}, b=${b}")
//    }
//
//    private fun printMaxExample() {
//        debug("${sum1(1, 3)}")
//        debug("${sum2(1, 3)}")
//        debug("${sum3(1, 3)}")
//        debug("${max1(3, 5)}")
//        debug("${max2(3, 5)}")
//        debug("${max3(3, 5)}")
//    }
//
//    private fun max1(a: Int, b: Int) = if (a > b) a else b
//    private fun max2(a: Int, b: Int): Int = if (a > b) a else b
//    private fun max3(a: Int, b: Int): Int {
//        return if (a > b) a else b
//    }
//
//    private fun printSumFuncTest() {
//        debug("${sum1(1, 2)}")
//        debug("${sum2(1, 2)}")
//        debug("${sum3(1, 2)}")
//    }
//
//    private fun sum1(a: Int, b: Int): Int = a + b
//    private fun sum2(a: Int, b: Int): Int {
//        return a + b
//    }
//
//    private fun sum3(a: Int, b: Int) = a + b
//
//    private fun printBitExample() {
//        debug("${2.shl(1)}") // 4
//        debug("${2.shr(1)}") // 1
//        debug("${2.ushr(1)}") // 1
//        debug("${2.and(1)}") // 0
//        debug("${2.or(1)}") // 3
//        debug("${2.xor(1)}") // 3
//        debug("${2.inv()}") // -3
//    }
//
//    private fun printTypeExample() {
//        printVariableType("Hello")
//        printVariableType(10)
//        printVariableType(20L)
//        printVariableType(1.0)
//        printVariableType(10.0F)
//        printVariableType('A')
//        printVariableType(true)
//    }
//
//    private fun printVariableType(variable: Any) {
//        when (variable) {
//            is String -> {
//                debug("$variable is string")
//            }
//            is Int -> {
//                debug("$variable is int")
//            }
//            is Long -> {
//                debug("$variable is long")
//            }
//            is Float -> {
//                debug("$variable is float")
//            }
//            is Double -> {
//                debug("$variable is double")
//            }
//            is Char -> {
//                debug("$variable is char")
//            }
//            is Boolean -> {
//                debug("$variable is boolean")
//            }
//            else -> {
//                debug("$variable is unknown type")
//            }
//        }
//    }
//
//    private fun printAsCast() {
//        val y: String? = null
//        val x = y as? String ?: "empty"
//        debug("$x $y")
//
//        var a: Any = 1
//        debug("0 a: $a type: ${a.javaClass}")
//        a = 20L
//        debug("1 a: $a type: ${a.javaClass}")
//        a = "Hello"
//        debug("2 a: $a type: ${a.javaClass}")
//    }
//
//    private fun printCheckType() {
//        val num = 10
//
//        if (num is Int) {
//            debug("$num is int")
//        } else if (num !is Int) {
//            debug("$num is not int")
//        }
//
//        val x: Any
//        x = "Hello"
//        if (x is String) {
//            debug("$x is string, length=${x.length}")
//        } else {
//            debug("$x is not a string")
//        }
//    }
//
//    private fun printSmartCast() {
//        var test: Number = 12.2
//        debug("$test")
//        test = 12
//        debug("$test")
//        test = 120L
//        debug("$test")
//        test += 12.0F
//        debug("$test")
//    }
//
//    private fun printReferenceTest() {
//        val a: Int = 128
//        val b = a
//        debug("${a === b}")  // true
//
//        val c: Int? = a
//        val d: Int? = a
//        val e: Int? = c
//        debug("${c == d}") // true
//        debug("${c === d}") // false
//        debug("${c === e}") // true
//    }
//
//    private fun printStringTest() {
//        val user: Username = "Neo"
//
//        // === : Compare reference
//        var str1: String = "Hello"// String pool
//        var str2 = "World"
//        var str3 = "Hello" // Read from string pool
//
//        debug("${str1 === str2}") // false
//        debug("${str1 === str3}") // true
//
//        val num = 10
//
//        var longText = """Hello
//            My name is $user.
//            Nice to meet you
//            ${num}
//        """.trimMargin()
//        debug(longText)
//
//        var _str1: String? = "Hello Kotlin"
//        _str1 = null
//        debug("${_str1!!} ${_str1?.length}")
//    }
//
//    private fun printDataSize() {
//        debug("Byte min: ${Byte.MIN_VALUE} max: ${Byte.MAX_VALUE}")
//        debug("Short min: ${Short.MIN_VALUE} max: ${Short.MAX_VALUE}")
//        debug("Int min: ${Int.MIN_VALUE} max: ${Int.MAX_VALUE}")
//        debug("Long min: ${Long.MIN_VALUE} max: ${Long.MAX_VALUE}")
//        debug("Float min: ${Float.MIN_VALUE} max: ${Float.MAX_VALUE}")
//        debug("Double min: ${Double.MIN_VALUE} max: ${Double.MAX_VALUE}")
//    }
//
    var count = 0
    private fun debug(msg: String) {
        Log.d(TAG, "${count++}: $msg")
    }

//    inner class Person(val name: String) {
//        fun printName() {
//            debug("$name")
//        }
//    }
}