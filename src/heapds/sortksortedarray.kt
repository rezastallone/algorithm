package heapds

fun main() {
    val array = mutableListOf(1, 4, 5, 2, 3, 7, 8, 6, 10, 9)
    val k = 2
    val minHeap = ArrayList<Int>(k+1)

    for ( i in 0 until k + 1){
        insertToMinHeap(minHeap, array[i], i)
    }

    for ( i in k + 1 until array.size ) {
        println("${extractMinZeroIndex(minHeap)}")
        insertToMinHeap(minHeap, array[i], k)
    }
}

fun insertToMinHeap(minHeap: ArrayList<Int>, newValue: Int, index: Int) {
    minHeap.add(newValue)
    var itr = index
    while (itr > 1 && minHeap[itr] < minHeap[itr / 2 - 1]) {
        swap(minHeap, itr, itr / 2 - 1)
        itr = itr / 2 - 1
    }
}

fun minHeapify2(minHeap: ArrayList<Int>, i: Int) {
    var smallest = i
    val left = i * 2 + 1
    val right = i * 2 + 2
    var itr = i
    if (left < minHeap.size && minHeap[left] < minHeap[itr]) {
        smallest = left
    }

    if (right < minHeap.size && minHeap[right] < minHeap[smallest]) {
        smallest = right
    }

    if (smallest != i) {
        swap(minHeap, itr, smallest)
        minHeapify2(minHeap, smallest)
    }
}