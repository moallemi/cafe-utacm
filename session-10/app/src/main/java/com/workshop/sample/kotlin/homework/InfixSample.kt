package com.workshop.sample.kotlin.homework

fun main() {
    println(5.addBy(3))

    val a = 7 addBy 9
    println(a)
}

infix fun Int.addBy(by: Int): Int = this + by