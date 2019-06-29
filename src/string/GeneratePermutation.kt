package string

fun main() {
    val s = "abcd"
    generatePermutation("", s)
}

fun generatePermutation(prefixToPrint: String, rem: String) {
    if (rem.isEmpty()) {
        println(prefixToPrint)
    } else {
        for (i in 0 until rem.length) {
            val remaining = rem.substring(0, i) + rem.substring(i + 1)
            generatePermutation(prefixToPrint + rem.get(i), remaining)
        }
    }
}