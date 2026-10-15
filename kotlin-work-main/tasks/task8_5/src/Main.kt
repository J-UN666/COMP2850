// Task 8.5: example of using a higher-order function

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val names = listOf("apple", "banana", "kiwi", "pear")

    println("Even numbers: ${howMany(numbers) { it % 2 == 0 }}")
    println("Names longer than 5 letters: ${howMany(names) { it.length > 5 }}")
}
