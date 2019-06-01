package array

import java.util.*

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int {
    val rowSteps = mutableListOf(0, 0, -1, 1, 0, -1, 1)
    val columnSteps = mutableListOf(0, -1, -1, -1, 1, 1, 1)

    var firstSet = true
    var max = 0
    var total: Int
    for (i in 1 until arr.size - 1) {
        for (j in 1 until arr[i].size - 1) {
            total = 0
            for (k in 0 until rowSteps.size) {
                total += arr[i + columnSteps[k]][j + rowSteps[k]]
            }
            if ( firstSet ){
                max = total
                firstSet = false
            } else {
                max = Math.max(max, total)
            }
        }
    }
    return max
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}