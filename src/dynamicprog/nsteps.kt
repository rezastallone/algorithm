package dynamicprog

fun main() {
    val testcases = arrayOf(
        10,20,1,0,-1,3,2,5
    )

    testcases.forEach {
        val table = Array(it+1){
            -1
        }
//        println("${takeSteps(it)} ways to take $it stair")
        println("${takeStepsMemo(it, table)} ways to take $it stair")
    }
}

fun takeSteps(remainingSteps: Int): Int {
    return if ( remainingSteps < 0 ){
        0
    } else if ( remainingSteps == 0 ){
        1
    } else {
        return takeSteps(remainingSteps-1) + takeSteps(remainingSteps - 2) + takeSteps(remainingSteps - 3)
    }
}

fun takeStepsMemo(remainingSteps: Int, table: Array<Int>): Int {
    return if ( remainingSteps < 0 ){
        0
    } else if ( table[remainingSteps] != -1){
        table[remainingSteps]
    } else if ( remainingSteps == 0 ){
        1
    } else {
        val totalStepsForNTh = takeStepsMemo(remainingSteps-1, table) + takeStepsMemo(remainingSteps - 2, table) + takeStepsMemo(remainingSteps - 3, table)
        table[remainingSteps] = totalStepsForNTh
        totalStepsForNTh
    }
}