package string

fun main() {
    val word = "huha"
    permutate("", word)
}

fun permutate(perm: String, word: String) {
    if ( word.isEmpty() ){
        println(perm + word)
    } else {
        for ( i in 0 until word.length){
            println("Perm : ${perm + word[i]} ${word.substring(0, i) + word.substring(i + 1, word.length)}")
            permutate(perm + word[i], word.substring(0, i) + word.substring(i + 1, word.length))
        }
    }
}
