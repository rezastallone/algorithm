package string



fun main() {
    val stringsToTest = arrayOf(
        "abcdef",
        "aaaaab",
        "abcda",
        "dcef",
        "dcef!@##",
        "-123wdok><MXz"
    )
    stringsToTest.forEach {
        stringToTest ->
        println("$stringToTest has unique ? ${isStringHasUniqueChar(stringToTest)}" )
    }
}

fun isStringHasUniqueChar(stringToTest: String): Boolean {
    val alphabetCounter = Array<Int>(256){
        0
    }
    stringToTest.forEach {
            char ->
        val charIndex = Math.abs(char - 'a')
        if ( alphabetCounter[charIndex] > 0 ){
            return@isStringHasUniqueChar false
        }
        alphabetCounter.set(charIndex, ++alphabetCounter[charIndex])
    }
    return true
}
