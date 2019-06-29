package string

fun main() {
    val matrix = arrayOf(
        arrayOf("A","A","A","A"),
        arrayOf("B","B","B","B"),
        arrayOf("C","C","C","C"),
        arrayOf("D","D","D","D")
    )

    for ( i in 0 until 4){
        for ( j in 3 downTo 0 ){
            print(matrix[j][i])
        }
        println()
    }
}