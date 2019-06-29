package string

fun main() {
    val stringsToTest = arrayOf(
        Pair("abc","cba")
    ,   Pair("abc","cbaa")
    ,   Pair("abc","")
    ,   Pair("abc","")
    ,   Pair("","abc")
    ,   Pair("ccc ","ccc")
    ,   Pair("ccc","ccc")
    )

    stringsToTest.forEach {
        println(isPermutationOf(it.first, it.second))
    }
}

fun isPermutationOf(stringToTest: String , referenceString: String ): Boolean {
    if ( stringToTest.length != referenceString.length ){
        return  false
    }

    val charFrequency = HashMap<Char, Int>()
    referenceString.forEach {
        charFrequency[it] = charFrequency.getOrDefault(it, 0) + 1
    }

    stringToTest.forEach {
        charFrequency[it] = charFrequency.getOrDefault(it, 0) - 1
    }

    charFrequency.forEach(){
        if ( it.value != 0 ){
            return@isPermutationOf false
        }
    }

    return true
}