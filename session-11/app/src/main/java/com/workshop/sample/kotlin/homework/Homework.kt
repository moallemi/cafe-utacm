package com.workshop.sample.kotlin.homework

fun main() {

    fun sum(list: List<Int>): Int? {
        return list.sum()
    }


    fun max(list: List<Int>): Int? {
        return list.max()
    }

    fun findIndex(list: List<Int>, what: Int): Int? {
        return list.indexOfFirst { it == what }
    }


    fun isOdd(number: Int) = number % 2 == 1


    /**
    fun evenItems(list: List<Int>): List<Int> {

    }
     */
}