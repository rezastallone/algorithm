fun main (args: Array<String>){
    val text = "ababcabcabababd"
    val pattern = "ababd"
                 //00120
    val foundIndex = getMatchStartIndex(text, pattern)
    if ( foundIndex != -1 ){
        println("FOUND at ${foundIndex} ${text.substring(foundIndex, foundIndex + pattern.length)}" )
    } else {
        println("NOT FOUND")
    }
}

fun getMatchStartIndex(text: String, patternToSearch: String): Int {
    val arrayPattern = createArrayFromPattern(patternToSearch)
    for ( i in arrayPattern){
        println("Arr : $i")
    }
    var patternItr = -1
    var foundIndex = -1
    for ( textItr in 0 until text.length ){
        if ( text[textItr] == patternToSearch[patternItr+1] ){
            println("Comparing ${text[textItr]} and ${patternToSearch[patternItr+1]}")
            patternItr++
        } else {
            while ( patternItr > -1 ){
                println("FALLBACK COMPATE ${text[textItr]} and ${patternToSearch[patternItr+1]} FAIL")
                patternItr = arrayPattern[patternItr]
                patternItr = if ( patternItr < -1 ) -1 else patternItr
                println("Fallback to $patternItr")
                if ( text[textItr] == patternToSearch[patternItr+1] ) {
                    patternItr++
                    break
                }
            }
        }
        println("CONTINUE $patternItr ${patternToSearch.length-1}")

        if ( patternItr >= patternToSearch.length-1 ){
            println("FOUND")
            foundIndex = textItr - ( patternToSearch.length - 1 )
            break
        }
    }
    return foundIndex
}


fun createArrayFromPattern(pattern :String): MutableList<Int> {
    val arrayPattern = MutableList(pattern.length){
        -1
    }
    var prefixItr = -1
    for ( patternItr in 1 until pattern.length ){
        if ( pattern[patternItr] == pattern[prefixItr+1] ){
            prefixItr++
        } else {
            prefixItr = -1
        }
        arrayPattern[patternItr] = prefixItr
    }
    return arrayPattern
}