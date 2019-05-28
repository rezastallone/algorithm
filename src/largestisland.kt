fun main() {
    val islands = generateIslands()
//    calculateLargestIsland(4,4,islands)
    val largestIsland = getLargestIsland(islands)
    println("largest island is ${largestIsland}")
}

fun getLargestIsland(islands: MutableList<MutableList<Int>>): Int {
    var largestIsland = 0
    for ( row in 0 until  islands.size ){
        val rowIslands = islands[row]
        for ( col in 0 until rowIslands.size ){
            if ( rowIslands[col] == 1 ){
                largestIsland = Math.max(calculateLargestIsland(row,col, islands), largestIsland)
            }
        }
        println()
    }
    return largestIsland
}

fun calculateLargestIsland(row: Int, col: Int, islands: MutableList<MutableList<Int>>): Int {
    if ( row < 0 || row >= islands.size || col < 0 || col >= islands[row].size ){
        return 0
    }
    if ( islands[row][col] == 0){
        return 0
    }
    islands[row][col] = 0
    var size = 1
    for ( rowItr in row - 1 .. row + 1){
        for ( colItr in col - 1 .. col + 1){
            size += calculateLargestIsland(rowItr, colItr, islands)
        }
    }
    return size
}

fun generateIslands(): MutableList<MutableList<Int>> {
    val islands1 = mutableListOf(1,0,0,1,0,0)
    val islands2 = mutableListOf(1,0,0,1,1,0)
    val islands3 = mutableListOf(0,0,1,1,1,0)
    val islands4 = mutableListOf(1,0,0,1,0,0)
    val islands5 = mutableListOf(1,1,0,0,0,0)
    val islands6 = mutableListOf(0,0,0,1,1,0)
    val allIslands = mutableListOf(
        islands1,
        islands2,
        islands3,
        islands4,
        islands5,
        islands6
    )
    return allIslands
}