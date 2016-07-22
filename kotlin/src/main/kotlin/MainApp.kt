import java.io.File

/**
 * My first test of kotlin
 *
 * Created by gwmccort on 5/27/2016.
 */

val PI = 3.14159

fun main(args: Array<String>) {
    println("Hello Kotlin")
    println(greetings())
    println("sum(1,2): ${sum(1, 2)}")

    var radius: Double = 1.0
    val increment = 1
    // increment = increment + 1 <-- will not compile since increment is a val
    println("The radius of a circle with radius ${radius} is ${circleArea(radius)}")
    radius = radius + increment
    println("The radius of a circle with radius ${radius} is ${circleArea(radius)}")

    // reads all the lines from a file and prints them out
    File("build.gradle").forEachLine { println(it) }
}

fun sum(a: Int, b: Int): Int {
    return a+b
}

fun greetings() = "Hello World!"

fun circleArea(r: Double) = PI * r * r
