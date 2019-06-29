fun main() {
    val stringsToConvert = listOf("3","4","A")
    val anotherListToConvert = listOf(3.4,4.2,422.2, 1, 2)
    println("converted string ${convertToIntListOrNull(stringsToConvert)}")
    println("converted string ${convertToIntListOrNull(anotherListToConvert)}")
}

fun <T> convertToIntListOrNull(listToConvert: List<T>): List<Int>?{
    val convertedList = mutableListOf<Int>()
    for ( itemToConvert in listToConvert ){
        if ( itemToConvert is Double){
            convertedList.add(itemToConvert.toInt())
        } else if ( itemToConvert is String && itemToConvert.toIntOrNull() != null  ) {
            convertedList.add(itemToConvert.toInt())
        }
    }
    return if ( convertedList.isEmpty() ){
        null
    } else {
        convertedList
    }
}