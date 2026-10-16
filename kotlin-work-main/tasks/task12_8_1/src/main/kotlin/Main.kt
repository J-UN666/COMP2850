// Task 12.8.1: demo program for Day enum class

fun main() {
    print("Enter a day of the week: ")
    val input = readlnOrNull()?.trim().orEmpty()

    try {
        // Day.valueOf() only accepts the exact name of one of the enum
        // constants, so "Monday" works but "monday" does not.
        val day = Day.valueOf(input)
        println("You entered $day")
    } catch (_: IllegalArgumentException) {
        // Handle the error gracefully, and tell the user what the valid
        // options are.
        println("Sorry, '$input' is not a day of the week.")
        println("Please enter one of: ${Day.entries.joinToString(", ")}")
        println("(Day names are case-sensitive, so they must start with a capital letter.)")
    }
}
