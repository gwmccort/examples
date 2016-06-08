import java.io.File

/**
 * My first test of kotlin
 *
 * Created by gwmccort on 5/27/2016.
 */

fun main(args: Array<String>) {
    println("Hello Kotlin")
    println("sum(1,2): ${sum(1, 2)}")

    // reads all the lines from a file and prints them out
    File("build.gradle").forEachLine { println(it) }
}

fun sum(a: Int, b: Int): Int {
    return a+b
}
