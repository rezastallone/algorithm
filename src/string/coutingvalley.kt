package string

import java.util.*

// Complete the countingValleys function below.
fun countingValleys(n: Int, s: String): Int {
    var counter = 0
    var valley = 0
    for ( c in s ){
        if ( c.toLowerCase() == 'd' ){
            counter--
        } else if ( c.toLowerCase() == 'u' ){
            counter++
            if ( counter == 0 ){
                valley++
            }
        }
    }
    return valley
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = countingValleys(n, s)

    println(result)
}
