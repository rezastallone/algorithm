package string


fun main() {
    val stringToTest = "mr jhon smith"

    val newStringBuilder = StringBuilder()
    stringToTest.forEach {
        if ( it != ' ' ){
            newStringBuilder.append(it)
        } else {
            newStringBuilder.append("%20")
        }
    }
    println(newStringBuilder.toString())
}