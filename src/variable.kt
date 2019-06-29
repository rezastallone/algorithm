fun main() {
    val a = 2437
    val b = 875
    var x = a
    var y = b
    while (x != y ){
        if ( x > y ){
            x = x - y
        } else if ( x < y ){
            y = y - x
        }
    }
    println("x : $x y $y")
}