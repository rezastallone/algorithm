package string

import java.util.*

// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long): Long {
    var counter = 0L
    var nTimes = n / s.length
    for ( i in 0 until s.length){
        if ( s[i] == 'a'){
            counter++
        }
    }

    counter *= nTimes

    var leftOver = n % s.length

    for ( i in 0 until leftOver.toInt()){
        if ( s[i] == 'a'){
            counter++
        }
    }

    return counter
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val n = scan.nextLine().trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}