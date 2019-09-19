package com.workshop.sample.kotlin

class Student {

    var name: String? = null
    var family: String? = null
    var avg: Int? = null
        set(value) {
            if (value != null && value > 20) {
                throw Exception("Invalid number")
            }
            field = value
        }
    val displayName: String = "$name  $family"

    fun talk() {
        println("My name is $name $family")
    }

    override fun toString(): String {
        return "$name $family $avg"
    }

    companion object {
        val XYZ= ""
        fun myMethod() {

        }
    }
}
