package com.workshop.sample.kotlin

fun main() {
    var number1: Int = 5
    println(number1)

    number1 = 7

    println(number1)

    val number2 = 10
    println(number2)

    val str1 = "Ali"
    val str2 = "Reza"

    val str3 = "Hello $str1 $str2"
    val str4 = """This is my text
        |this is my text
        |this is my text
    """.trimMargin()
    println(str4)

    var number3 = 24
    var result = if (number3 > 24) 5 else 6
    println(result)

    fun doSomething() {
        println("do something")
    }

    doSomething()

    fun method1(name: String, familyName: String) {
        println("Hi $name $familyName")
    }

    method1("Ali", "Heydari")
    method1(name = "Ali", familyName = "Heydari")
    method1(familyName = "Heydari", name = "Ali")

    fun method2(param1: Int, param2: String = "C", param3: Int) {
        println("$param1 $param2 $param3")
    }

    method2(4, "A", 17)
    method2(4, param3 = 20, param2 = "B")
    method2(4, param3 = 24)

    fun method3(vararg numbers: Int) {
        numbers.forEach {
            println(it)
        }
    }

    method3(3, 7, 8, 9)

    fun method4(a: Int, b: Int): Int {
        return a + b
    }

    fun method5(a: Int, b: Int) = a + b
    fun method6(a: Int, b: Int) = if (number3 > 24) 5 else ""

    val sum = method4(5, 7)
    println(sum)

    var numbers = listOf(2, 11, 4, 7, 8, 9)
    var mutableNumbers = mutableListOf(5.8)
    for (i in numbers) {
        println(i)
    }
    for (i in numbers.indices) {
        println("$i ${numbers[i]}")
    }
    numbers.forEach {ahmad->
        println(ahmad)
    }
    numbers.forEachIndexed { index, i ->
        println("$index = $i")
    }
    for (i in 1..10) {
        print("$i ,")
    }
    println()
    for (i in 1..10 step 2) {
        print("$i ,")
    }
    println()
    for (i in 1 until 10) {
        print("$i ,")
    }
    println()
    for (i in 10 downTo 1) {
        print("$i ,")
    }
    println()
    for (i in 10 downTo 1 step 2) {
        print("$i ,")
    }
    println()
    var num1 = 5
    var num2: Int? = null

    num2?.let {
        println(num1 + num2)
    }

    var num3 = if (num2 != null) num1 + num2 else num1

    println(num3)

    val student = Student()
    student.name = "Ali"
    student.family = "Ahmadi"
    student.avg = 14

    val student2 = Student()
    with(student2) {
        name = "Ali"
        family = "Ahmadi"
        avg = 14
    }

    println(student)
    student.talk()
    var areEqual = student == student2
    println(areEqual)

    val dataStd1 = Student2("A", "B", 14)
    val dataStd2 = Student2("A", "B", 14)

    areEqual = dataStd1 == dataStd2
    println(areEqual)

    student.displayName

    Student.myMethod()
    Student.XYZ

}