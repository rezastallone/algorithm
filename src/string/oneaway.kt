package string

import kotlin.math.abs

fun main() {
    val testcases = arrayOf(
        Pair("abc", "ab"),
        Pair("aaa", "bbb"),
        Pair("abc", "def"),
        Pair("abc", "a"),
        Pair("abc", "axe"),
        Pair("abc", ""),
        Pair("abc", "abd"),
        Pair("abb", "abd")
    )

    testcases.forEach {
        println(isOneEditAway(it.first, it.second))
    }
}

fun isOneEditAway(first: String, second: String): Boolean {

    if ( Math.abs(first.length - second.length) > 1 ){
        return false
    }

    val charFrequency = Array(26){
        0
    }

    first.forEach {
        charFrequency[it - 'a'] = ++charFrequency[it - 'a']
    }

    second.forEach {
        charFrequency[it - 'a'] = --charFrequency[it - 'a']
    }

    var diff = 0
    charFrequency.forEach {
        val frequency = Math.abs(it)
        diff += frequency
        if ( diff > 2 || frequency > 2  ){
            return@isOneEditAway false
        }
    }
    return diff > 0 && diff < 3
}
