package com.testcase.junit_testcase

enum class Color(val color: String) {
    RED("0xFF0000"),
    GREEN("0x00FF00"),
    BLUE("0x0000FF")
}
public fun main() {
    println("${Color.BLUE}")
    println(Color.BLUE.color)
    println(Color.BLUE.name)
    println("${Color.BLUE.ordinal}")
    println("${Color.entries}")
    println(Color.entries[0].color)

}