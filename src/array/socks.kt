package array

import java.util.*
import kotlin.collections.*

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {
    val map = HashMap<Int, Int>()
    var count = 0
    for ( i in ar){
        var curVal = ( map[i] ?: 0 ) + 1
        map[i] = curVal
        if ( curVal == 2 ){
            count++
            map[i] = 0
        }
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n,ar)

    println(result)
}
