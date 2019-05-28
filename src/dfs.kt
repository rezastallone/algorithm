import java.util.*

fun main(){
    val node1 = Node(1, false, mutableListOf())
    val node2 = Node(2, false, mutableListOf())
    node2.adjList.add(node1)
    node1.adjList.add(node2)

    val node3 = Node(3, false, mutableListOf())
    node3.adjList.add(node2)
    node2.adjList.add(node3)

    val node4 = Node(4, false, mutableListOf())
    node4.adjList.add(node2)
    node2.adjList.add(node4)
    node4.adjList.add(node3)
    node3.adjList.add(node4)

    val node5 = Node(5, false, mutableListOf())
    node5.adjList.add(node4)
    node4.adjList.add(node5)

    val node6 = Node(6, false, mutableListOf())
    node6.adjList.add(node1)
    node1.adjList.add(node6)

    val node7 = Node(7, false, mutableListOf())
    node7.adjList.add(node1)
    node1.adjList.add(node7)

    val node8 = Node(8, false, mutableListOf())
    node8.adjList.add(node7)
    node7.adjList.add(node8)

    val node9 = Node(9, false, mutableListOf())
    node9.adjList.add(node7)
    node7.adjList.add(node9)

    val node10 = Node(10, false, mutableListOf())
    node10.adjList.add(node1)
    node1.adjList.add(node10)

    node10.adjList.add(node9)
    node9.adjList.add(node10)

    val node11 = Node(11, false, mutableListOf())
    node11.adjList.add(node1)
    node1.adjList.add(node11)

    node11.adjList.add(node10)
    node10.adjList.add(node11)

//    dfs(node1)
    bfs(node1)
}

data class Node(
    val value:Int,
    var visited: Boolean = false,
    val adjList: MutableList<Node>
)

fun dfs(initialNode: Node){
    val stackToVisit = Stack<Node>()
    stackToVisit.push(initialNode)
    initialNode.visited = true
    var curNode: Node
    while ( stackToVisit.isNotEmpty() ){
        curNode = stackToVisit.pop()
        println("Visiting ${curNode.value}")
        for ( adjNode in curNode.adjList ){
            if ( ! adjNode.visited ){
                adjNode.visited = true
                stackToVisit.push(adjNode)
            }
        }
    }
}

fun bfs(initialNode: Node){
    val queueToVisit = ArrayDeque<Node>()
    queueToVisit.add(initialNode)
    initialNode.visited = true
    var curNode :Node
    while (queueToVisit.isNotEmpty()){
        curNode = queueToVisit.pop()
        println("Visiting ${curNode.value}")
        for ( adjNode in curNode.adjList ){
//            println("ADJ ${adjNode.value}")
            if ( ! adjNode.visited ){
                adjNode.visited = true
                queueToVisit.add(adjNode)
            }
        }
    }
}