// Task 7.3.1: list element access

fun main() {
    val fruits = listOf("apple", "banana", "cherry")

    println("First fruit: ${fruits[0]}")
    println("Second fruit: ${fruits[1]}")
    println("Last fruit: ${fruits[fruits.lastIndex]}")
    println("Third fruit via get(): ${fruits.get(2)}")
}
