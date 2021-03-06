package heapds

fun main() {
    val heap = mutableListOf(0, 2, 1, 4, 3, 5, 7, 6)
    for (i in heap.size / 2 downTo 1) {
        maxHeapify(heap, i)
    }
//    for (i in heap.size / 2 until heap.size) {
//        minHeapify(heap, i)
//    }
//    increaseValue(heap, 7, 1000)
//    increaseValue(heap, 6, 100)
//    increaseValue(heap, 5, 10)
//    addValue(heap,69 )
//    addValue(heap,55 )
    for ( i in 1 until heap.size ){
        println(extractMax(heap))
    }
}

fun addValue(heap: MutableList<Int>, newValue:Int){
    heap.add(-1)
    increaseValue(heap, heap.size - 1, newValue)
}

fun increaseValue(heap: MutableList<Int>, i: Int, newValue: Int){
    if ( newValue < heap[i] ){
        println("cant increase, new newValue is smaller")
        return
    }

    heap[i] = newValue
    var itr = i
    while ( itr > 1 && heap[itr] > heap[itr / 2 ] ){
        swap(heap, itr / 2 , itr)
        itr /= 2
    }
}

fun extractMax(heap: MutableList<Int>): Int {
    val max = heap[1]
    heap[1] = heap[heap.size - 1]
    heap.removeAt(heap.size - 1)
    maxHeapify(heap, 1)
    return max
}

fun extractMin(heap: MutableList<Int>): Int {
    val max = heap[1]
    heap[1] = heap[heap.size - 1]
    heap.removeAt(heap.size - 1)
    minHeapify(heap, 1)
    return max
}

fun maxHeapify(heap: MutableList<Int>, i: Int) {
    var largest = i
    val right = i * 2 + 1
    val left = i * 2
    if (left < heap.size && heap[i] < heap[left]) {
        largest = left
    }

    if (right < heap.size && heap[largest] < heap[right]) {
        largest = right
    }

    if (largest != i) {
        swap(heap, i, largest)
        maxHeapify(heap, largest)
    }
}

fun minHeapify(heap: MutableList<Int>, i: Int) {
    var smallest = i
    val right = i * 2 + 1
    val left = i * 2
    if (left < heap.size && heap[i] > heap[left]) {
        smallest = left
    }

    if (right < heap.size && heap[smallest] > heap[right]) {
        smallest = right
    }

    if (smallest != i) {
        swap(heap, i, smallest)
        minHeapify(heap, smallest)
    }
}

fun swap(heap: MutableList<Int>, i: Int, largest: Int) {
    val temp = heap[i]
    heap[i] = heap[largest]
    heap[largest] = temp
}