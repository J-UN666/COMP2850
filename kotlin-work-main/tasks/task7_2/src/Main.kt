// Task 7.2: array comparison

fun main() {
    val first = intArrayOf(1, 2, 3)
    val second = intArrayOf(1, 2, 3)
    val sameReference = first

    println("first == second: ${first == second}")
    println("first === second: ${first === second}")
    println("first.contentEquals(second): ${first.contentEquals(second)}")
    println("first === sameReference: ${first === sameReference}")
}

