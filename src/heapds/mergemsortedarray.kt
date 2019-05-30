package heapds

data class Element(val value: Int, val arrayNumber: Int)

fun main() {
    val array1 = mutableListOf<Int>(10, 20, 30, 40)
    val array2 = mutableListOf<Int>(15, 25, 35)
    val array3 = mutableListOf<Int>(27, 29, 37, 48, 93)
    val array4 = mutableListOf<Int>(32, 33)
    val arrayAll = mutableListOf(array1, array2, array3, array4)

    val m = 4
    val minHeap = MutableList<Element>(m) {
        Element(0, 0)
    }

    for (i in 0 until m) {
        val element = Element(arrayAll[i][0], i)
        insertElement(minHeap, element, i)
    }
    array1.removeAt(0)
    array2.removeAt(0)
    array3.removeAt(0)
    array4.removeAt(0)

    while (array1.isNotEmpty() || array2.isNotEmpty() || array3.isNotEmpty() || array4.isNotEmpty()) {
        val root = extractMin(minHeap)
        if (arrayAll[root.arrayNumber].isEmpty()) {
            println("${root.value}")
            continue
        }
        val nextToAdd = arrayAll[root.arrayNumber][0]
        val element = Element(nextToAdd, root.arrayNumber)
        minHeap.add(element)
        insertElement(minHeap, element, minHeap.size - 1)
        arrayAll[root.arrayNumber].removeAt(0)
        println("${root.value}")
    }
}

fun extractMin(minHeap: MutableList<Element>): Element {
    val root = minHeap[0]
    minHeap[0] = minHeap[minHeap.size - 1]
    minHeap.removeAt(minHeap.size - 1)
    minHeapify3(minHeap, 0)
    return root
}

fun insertElement(minHeap: MutableList<Element>, newValue: Element, index: Int) {
    minHeap[index] = newValue
    var itr = index
    while (itr > 1 && minHeap[itr].value < minHeap[itr / 2 - 1].value) {
        swap(minHeap, itr, itr / 2 - 1)
        itr = itr / 2 - 1
    }
}

fun swap(heap: MutableList<Element>, i: Int, largest: Int) {
    val temp = heap[i]
    heap[i] = heap[largest]
    heap[largest] = temp
}

fun minHeapify3(heap: MutableList<Element>, index: Int) {
    var smallest = index
    val left = index * 2 + 1
    val right = index * 2 + 2
    if (left < heap.size && heap[left].value < heap[smallest].value) {
        smallest = left
    }
    if (right < heap.size && heap[right].value < heap[smallest].value) {
        smallest = right
    }
    if (smallest != index) {
        swap(heap, smallest, index)
        minHeapify3(heap, smallest)
    }
}