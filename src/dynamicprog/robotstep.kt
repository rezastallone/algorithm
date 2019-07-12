package dynamicprog

val xMoves = arrayOf(1)
val yMoves = arrayOf(1)
val grid = arrayOf(
    arrayOf(1,1,1,0,0),
    arrayOf(1,1,1,1,0),
    arrayOf(1,0,1,1,0),
    arrayOf(1,1,1,0,1)
)

fun main() {
    println("Found path ${findPath(0, 0)}")
}

fun findPath(xLoc: Int, yLoc: Int): Boolean {
    return if ( xLoc >= grid.size || yLoc >= grid[0].size  || grid[xLoc][yLoc] == 0 ){
        false;
    } else if ( xLoc == grid.size - 1 && yLoc == grid[0].size - 1 && grid[xLoc][yLoc] == 1 ) {
        true
    } else {
        var moveResult = findPath(xLoc + xMoves[0] , yLoc)
        if ( ! moveResult ){
            moveResult = findPath(xLoc, yLoc + yMoves[0])
        }
        if ( ! moveResult ){
            moveResult = findPath(xLoc + xMoves[0] , yLoc + yMoves[0])
        }

        if ( moveResult ){
            println(" ($xLoc, $yLoc) ")
        }


        return moveResult
    }
}

