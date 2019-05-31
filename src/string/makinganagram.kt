package string

import java.util.*
import kotlin.collections.HashMap

// Complete the makeAnagram function below.
fun makeAnagram(a: String, b: String): Int {
    val aMap = HashMap<Char, Int>()
    val bMap = HashMap<Char, Int>()
    val computed = HashMap<Char, Boolean>()


    for ( c in a ){
        aMap[c] = ( aMap[c] ?: 0 ) + 1
    }

    for ( c in b ){
        bMap[c] = ( bMap[c] ?: 0 ) + 1
    }

    var numberToDelete = 0

    for ( entry in aMap ){
        numberToDelete += Math.abs(entry.value - ( bMap[entry.key] ?: 0 ))
        computed[entry.key] = true
    }

    for ( entry in bMap ){
        if ( computed[entry.key] == null ||  computed[entry.key] == false ){
            numberToDelete += Math.abs(entry.value - ( aMap[entry.key] ?: 0 ))
        }
    }

    return numberToDelete
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val a = scan.nextLine()

    val b = scan.nextLine()

    val res = makeAnagram(a,b)


    println(res)
}
