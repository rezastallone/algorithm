package heapds

fun main() {
    val array = mutableListOf(3, 1, 4, 2, 7, 5, 6)
    val k = 3
    val heap = MutableList(k) {
        -1
    }
    for (i in 0 until k) {
        insertToHeap(heap, i,array[i])
    }

    for (i in k until array.size) {
        if (array[i] > heap[0]) {
            heap[0] = array[i]
            minHeapify1(heap, 0)
        }
    }

    println("Smallest : ")
    for (i in 0 until heap.size) {
        val smallest = extractMinZeroIndex(heap)
        println("${smallest}")
    }
}

fun insertToHeap(heap: MutableList<Int>, i: Int, newValue: Int) {
    heap[i] = newValue
    var itr = i
    while ( itr > 1 && heap[itr] < heap[itr / 2 - 1]) {
        swap(heap, itr, itr / 2 - 1)
        itr = itr/ 2 -1
    }
}

fun extractMinZeroIndex(heap: MutableList<Int>): Int {
    val max = heap[0]
    heap[0] = heap[heap.size - 1]
    heap.removeAt(heap.size - 1)
    minHeapify1(heap, 0)
    return max
}

fun minHeapify1(heap: MutableList<Int>, i: Int) {
    var smallest = i
    val left = i * 2 + 1
    val right = i * 2 + 2
    if (left < heap.size && heap[left] < heap[i]) {
        smallest = left
    }

    if (right < heap.size && heap[right] < heap[smallest]) {
        smallest = right
    }

    if (smallest != i) {
        swap(heap, smallest, i)
        minHeapify1(heap, smallest)
    }
}