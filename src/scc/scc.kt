package scc

import java.util.*

fun main() {
    val adjList = getGraph()
//    printList(adjList)
    val stack = getEndVertexStack(adjList)
    val transposeAdjList = transpose(adjList)
    printScc(stack,transposeAdjList)

}

fun printScc(stack: Stack<Int>, transposeAdjList: MutableList<ArrayList<Int>>) {
    val visited = MutableList(7){false}
    println("scc : ")
    while (stack.isNotEmpty()){
        val v = stack.pop()
        if ( ! visited[v] ){
            dfsPrint(v, transposeAdjList, visited)
        }
        println()
    }
}

fun dfsPrint(
    v: Int,
    transposeAdjList: MutableList<ArrayList<Int>>,
    visited: MutableList<Boolean>
) {
    print("${v+1} ")
    visited[v] = true
    for ( adj in transposeAdjList[v]){
        if ( !visited[adj] ){
            dfsPrint(adj, transposeAdjList, visited)
        }
    }
}

fun getEndVertexStack(adjList: MutableList<ArrayList<Int>>): Stack<Int> {
    val stack = Stack<Int>()
    val visited = MutableList(7){false}
    for ( i in 0 until  adjList.size ){
        if ( ! visited[i] ){
            dfsStack(i, adjList, stack, visited)
        }
    }
    return stack
}

fun dfsStack(i: Int, adjList: MutableList<ArrayList<Int>>, stack: Stack<Int>, visited: MutableList<Boolean>) {
    visited[i] = true
    for ( v in adjList[i]){
        if ( ! visited[v] ){
            dfsStack(v, adjList, stack, visited)
        }
    }
    stack.add(i)
}

fun transpose(adjList: MutableList<ArrayList<Int>>): MutableList<ArrayList<Int>> {
    val transposeAdjList = MutableList<ArrayList<Int>>(7){
        ArrayList()
    }

    for (i in 0 until adjList.size){
        for ( v in adjList[i] ){
            transposeAdjList[v].add(i)
        }
    }

    return transposeAdjList
}

fun printList(adjList: MutableList<ArrayList<Int>>) {
    for ( i in 0 until adjList.size){
        val adj = adjList[i]
        print("${i+1} : ")
        for ( v in adj ){
            print("${v+1} ,")
        }
        println()
    }
}


fun getGraph(): MutableList<ArrayList<Int>> {
    val adjList = MutableList<ArrayList<Int>>(7){
        ArrayList()
    }

    adjList[0].add(1)
    adjList[1].add(2)
    adjList[2].add(0)
    adjList[2].add(4)
    adjList[3].add(4)
    adjList[4].add(5)
    adjList[5].add(3)
    adjList[6].add(5)

    return adjList
}

