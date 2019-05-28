package transitiveclosuregraph

/*

fillingList.add( a )
a -> d
matrix[a][d] = 1
fillingList.add( d )
d -> c
matrix[a][c] = 1
matrix[d][c] = 1
fillingList.add( c )

 */

data class Node(val value: Int, val adjList: MutableList<Node>)

fun main() {
    val initNode = getGraphNoCycle()
    buildTraversalMatrix(initNode)
}

fun buildTraversalMatrix(allNode: List<Node>) {
    val transitiveMatrix = MutableList(5) {
        IntArray(5)
    }

    for (node in allNode) {
        calculateTransitive(node, node, transitiveMatrix)
    }

    println()
    for (row in transitiveMatrix) {
        for (col in row) {
            print("$col, ")
        }
        println()
    }
}

fun calculateTransitive(prevNode: Node, node: Node, transitiveMatrix: MutableList<IntArray>) {
    transitiveMatrix[prevNode.value][node.value] = 1
    for (adjNode in node.adjList) {
        if (transitiveMatrix[prevNode.value][adjNode.value] == 0) {
            calculateTransitive(prevNode, adjNode, transitiveMatrix)
        }
    }
}

fun getGraphNoCycle(): List<Node> {
    val node1 = Node(0, mutableListOf())
    val node2 = Node(1, mutableListOf())
    val node3 = Node(2, mutableListOf())
    val node4 = Node(3, mutableListOf())
    val node5 = Node(4, mutableListOf())

    node1.adjList.add(node4)
    node1.adjList.add(node2)

    node3.adjList.add(node2)

    node4.adjList.add(node3)
    node4.adjList.add(node5)

    node5.adjList.add(node3)

    return listOf(node1, node2, node3, node4, node5)
}