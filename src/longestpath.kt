
fun main() {
    val arr1 = intArrayOf(0,2,0,0,0,0)
    val arr2 = intArrayOf(2,0,4,0,0,2)
    val arr3 = intArrayOf(0,4,0,0,0,0)
    val arr4 = intArrayOf(0,0,0,0,0,6)
    val arr5 = intArrayOf(0,0,0,0,0,5)
    val arr6 = intArrayOf(0,0,0,6,5,0)

    val pathList = listOf(
        arr1,
        arr2,
        arr3,
        arr4,
        arr5,
        arr6
    )

    val adjList = MutableList<ArrayList<Int>>(6){
        ArrayList()
    }

    adjList[0].add(1)
    adjList[1].add(0)
    adjList[1].add(2)
    adjList[1].add(5)
    adjList[2].add(1)
    adjList[3].add(5)
    adjList[4].add(5)
    adjList[5].add(1)
    adjList[5].add(3)
    adjList[5].add(4)

    calculateMaxpath(pathList, adjList)
}

fun calculateMaxpath(pathList: List<IntArray>, adjList: MutableList<ArrayList<Int>>) {
    var maxPath = 0
    var curPath: Int

    for ( i in 0 until adjList.size){
        val visited = booleanArrayOf(false,false,false,false,false,false)
        curPath = dfsFindMax(0, i, adjList, pathList, visited)
        maxPath = Math.max(curPath, maxPath)
    }
}

fun dfsFindMax(
    prevMax: Int,
    prevNode: Int,
    allAdjList: MutableList<ArrayList<Int>>,
    pathList: List<IntArray>,
    visited: BooleanArray
): Int {
    visited[prevNode] = true
    var max = 0
    for ( v in allAdjList[prevNode] ){
        if ( ! visited[v] ){
            max = Math.max(dfsFindMax(pathList[prevNode][v] + prevMax, v, allAdjList, pathList, visited), max)
        }
    }
    return Math.max(max, prevMax)
}
