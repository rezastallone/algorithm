package string

private data class Node(
    val char: Char,
    var count: Int = 0,
    var isWord: Boolean = false,
    val child: HashMap<Char, Node>
)

private data class HeapNode(
    val word: CharArray,
    val count: Int
)

fun main() {
    val keys = listOf(
        "code", "coder", "coding", "codable", "codec", "codecs", "coded",
        "codeless", "codec", "codecs", "codependence", "codex", "codify",
        "codependents", "codes", "code", "coder", "codesign", "codec",
        "codeveloper", "codrive", "codec", "codecs", "codiscovered"
    )

    val root = Node(' ', 0, false, HashMap())
    insert("code", root)
    insert("codecs", root)
    var maxLength = 0
    for (key in keys) {
        maxLength = Math.max(maxLength, key.length)
        insert(key, root)
    }
    traverse(root, CharArray(maxLength + 1), 0)

    val heap = MutableList<HeapNode>(4) {
        HeapNode(CharArray(0), 0)
    }


}

private fun insert(word: String, root: Node) {
    var curNode = root
    for (i in 0 until word.length) {
        val char = word[i]
        var charNode = curNode.child[char]
        if (charNode == null) {
            charNode = Node(char, 0, false, HashMap())
            curNode.child[char] = charNode
        }
        curNode = charNode
    }
    curNode.isWord = true
    curNode.count++
}

private fun traverse(curNode: Node, displayString: CharArray, level: Int) {
    if (curNode == null) {
        return
    }
    if (curNode.isWord) {
        displayString[level] = curNode.char
        print("count : ${curNode.count} word : ")
        printString(displayString, level)
    }
    for (node in curNode.child) {
        displayString[level] = curNode.char
        traverse(node.value, displayString, level + 1)
    }
    displayString[level] = ' '
}

private fun printString(displayString: CharArray, level: Int) {
    for (i in 0..level) {
        print(displayString[i])
    }
    println()
}

private fun extractMax(heap: MutableList<HeapNode>): HeapNode {
    val max = heap[0]
    heap[0] = heap[heap.size - 1]
    heap.removeAt(heap.size - 1)
    return max
}

private fun insertHeapNode(heap: MutableList<HeapNode>, node: HeapNode, i: Int) {
    heap[i] = node
    var itr = i
    while (i > 1 && heap[itr].count > heap[itr / 2 - 1].count) {
        swap(heap, itr, itr / 2 - 1)
        itr = itr / 2 - 1
    }
}

private fun swap(heap: MutableList<HeapNode>, i: Int, parent: Int) {
    val temp = heap[i]
    heap[i] = heap[parent]
    heap[parent] = temp
}