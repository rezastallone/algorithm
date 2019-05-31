//import java.util.*
//
//
//data class Coordinate(val x: Int, val y: Int)
//
//fun main() {
//    val golumnLoc = golumnDummyMap()
//    val aragonMap = aragonDummapMap()
//    println(golumnLoc)
//    println(aragonMap)
//    aragonMap.forEach{
//        val strToSearch = "${golumnLoc[0]}$$it"
//        println("Search string : ${findMatchIndexes(strToSearch, golumnLoc[0].length+1)}")
//    }
//}
//
//
//fun golumnDummyMap(): MutableList<String> {
//    val col1 = "aba"
//    val col2 = "bab"
//    val col3 = "aba"
//    return mutableListOf(col1, col2, col3)
//}
//
//fun aragonDummapMap(): MutableList<String> {
//    val col1 = "aababa"
//    val col2 = "ababab"
//    val col3 = "bababa"
//    val col4 = "ababab"
//    val col5 = "ababab"
//    val col6 = "bababa"
//    val col7 = "ababab"
//    return mutableListOf(
//        col1,
//        col2,
//        col3,
//        col4,
//        col5,
//        col6,
//        col7
//    )
//}
//
//fun getGolumnLocationDescription() {
//    val reader = Scanner(System.`in`)
//    val n1 = reader.nextInt()
//    val n2 = reader.nextInt()
//    val patternMatrix = MutableList(n1) {
//        MutableList(n2) {
//            0
//        }
//    }
//
//    println("recieved $n1 $n2, content are : ")
//    for (col in patternMatrix) {
//        for (row in col) {
//            print(row)
//        }
//        println()
//    }
//}
//
//fun findMatchIndexes(text: String, separatorIndex: Int): MutableList<Int> {
//    val ZArray = MutableList(text.length) {
//        0
//    }
//    var left = 0
//    var right = 0
//
//    for (ZValueItr in 1 until text.length) {
//        if (ZValueItr > right) {
//            right = ZValueItr
//            left = ZValueItr
//            right = iterateMatchingPattern(right, text, left, ZArray, ZValueItr)
//        } else {
//            var leftMirrorItr = ZValueItr - left
//            if (ZValueItr + ZArray[leftMirrorItr] > right) {
//                left = ZValueItr
//                right = iterateMatchingPattern(right, text, left, ZArray, ZValueItr)
//            } else {
//                ZArray[ZValueItr] = ZArray[leftMirrorItr]
//            }
//        }
//    }
//    return ZArray.subList(separatorIndex, ZArray.size)
//}
//
//private fun iterateMatchingPattern(
//    right: Int,
//    text: String,
//    left: Int,
//    ZArray: MutableList<Int>,
//    ZValueItr: Int
//): Int {
//    var right1 = right
//    while (right1 < text.length && text[right1] == text[right1 - left]) {
//        right1++
//    }
//    ZArray[ZValueItr] = ( right1 - left )
//    right1--
//    return right1
//}