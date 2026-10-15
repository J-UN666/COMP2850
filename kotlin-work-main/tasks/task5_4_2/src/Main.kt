// Task 5.4.2: main program

fun main() {
    val tests = listOf(
        "short",
        "this is exactly 20",
        "this is definitely too long"
    )

    for (text in tests) {
        println("\"$text\" -> ${text.isTooLong}")
    }
}
