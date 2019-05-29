package heapds

fun main() {
    val heap = mutableListOf(0, 1, 2, 4, 3, 5, 7, 6)
//    val heap = mutableListOf(0, 7, 5, 6, 3, 1, 4, 2)
    var isHeap = true
    for ( i in heap.size / 2 downTo 1 ){
        if ( ! checkHeapify(heap, i) ) {
            isHeap = false
            break
        }
    }
    println("IS MAX HEAP ? $isHeap")
}

fun checkHeapify(heap: MutableList<Int>, i:Int): Boolean {
    var isHeap = false
    val left = i * 2
    val right = i * 2 + 1
    isHeap = left >= heap.size || heap[left] < heap[i]

    isHeap = isHeap && ( right >= heap.size || heap[right] < heap[i] )

    return isHeap
}