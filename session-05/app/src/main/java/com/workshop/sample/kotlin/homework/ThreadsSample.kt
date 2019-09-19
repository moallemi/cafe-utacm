package com.workshop.sample.kotlin.homework

fun main() {

    println("Hi")
    Thread {
        (1..20).forEach(::print)
    }.start()
    println("Bye")
}