fun main() {
    val text = "aaabcxyzaaaabczaaczabbaaaaaabc"
    val pattern = "aaabc"

    val textToSearch = "$pattern$$text"
    println(textToSearch)
    val ZArray = findMatchIndexes(textToSearch, pattern.length)
    println(textToSearch)
    println(ZArray.toString())
}

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
//    return ZArray.subList(separatorIndex, ZArray.size - 1)
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
//    ZArray[ZValueItr] = right1 - left
//    right1--
//    return right1
//}