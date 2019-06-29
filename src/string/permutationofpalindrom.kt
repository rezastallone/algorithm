package string

fun main() {
    val testcases = arrayOf(
        "tactcoa",
        "aaabcbaaa",
        "aaabcaaab",
        "aaabaaab",
        "acdacd",
        "aaad",
        "dawewd"
    )

    testcases.forEach {
        println("$it is palindrom ? ${ispalidrom(it)}")
    }
}

fun ispalidrom(stringToTest: String): Boolean {
    val charFrequency = Array(26){
        0
    }

    stringToTest.forEach {
        charFrequency[it - 'a'] = ++charFrequency[it - 'a']
    }
    var middleFound = false
    charFrequency.forEach {
        if ( it % 2 > 0 ){
            if ( ! middleFound ){
                middleFound = true
            } else {
                return@ispalidrom false
            }
        }
    }

    return true
}