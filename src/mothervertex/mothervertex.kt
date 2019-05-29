package mothervertex

fun main() {
    val adjList = getTestCase1()

    calculateMotherVertex(adjList)
}

private fun getTestCase1(): MutableList<ArrayList<Int>> {
    val adjList = MutableList<ArrayList<Int>>(7) {
        ArrayList()
    }

    adjList[0].add(1)
    adjList[0].add(2)
    adjList[1].add(3)
    adjList[4].add(1)
    adjList[5].add(2)
    adjList[5].add(6)
    adjList[6].add(4)
    adjList[6].add(0)
    return adjList
}

private fun getTestCase2(): MutableList<ArrayList<Int>> {
    val adjList = MutableList<ArrayList<Int>>(5) {
        ArrayList()
    }

    adjList[0].add(3)
    adjList[0].add(2)
    adjList[1].add(0)
    adjList[2].add(1)
    adjList[3].add(4)

    return adjList
}

fun calculateMotherVertex(adjList: MutableList<ArrayList<Int>>) {
    for ( i in 0 until adjList.size){
        println("start $i")
        val count = isMotherVertex(i, adjList, MutableList(adjList.size){false})
        if ( count == adjList.size ){
            println("$i is mother vertex $count")
        }
    }
}

fun isMotherVertex(i:Int,adjList: MutableList<ArrayList<Int>>, visited: MutableList<Boolean>): Int {
    println("Visiting $i")
    var count = 1
    visited[i] = true
    for ( adj in adjList[i]){
        if ( ! visited[adj] ){
          count += isMotherVertex(adj, adjList, visited)
        }
    }
    return count
}
