package com.workshop.sample.kotlin

fun main() {

    val lambda = {
        println("This is my lambda")
    }

    val lambda2 = {
        println("Second lambda")
    }

    val sum = { a: Int, b: Int ->
        a + b
    }

    val mult = { a: Int, b: Int ->
        a * b
    }

//    doSomething(lambda)
//    doSomething(lambda2)

    var result = mathOp(5, 7, sum)
    println(result)
    result = mathOp(5, 7, mult)
    println(result)

    val numnbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val res = numnbers.filter {
        !it.isOdd()
    }
    println(res)

    val a = 25
    val b = a.inc()
    val c = a.toChar()
    val d = a.isOdd()
    println(d)

}

fun Int.isOdd() = this % 2 == 1

fun mathOp(number1: Int, number2: Int, func: (Int, Int) -> Int): Int {
    return func(number1, number2)
}

fun doSomething(param1: () -> Unit) {
    println("Before")

    param1()

    println("After")
}

