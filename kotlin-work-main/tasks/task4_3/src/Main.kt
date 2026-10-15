// Task 4.3: grade calculation using a when expression
import kotlin.math.roundToInt

fun main(args: Array<String>) {
    if (args.size != 3) {
        println("Please provide three grades as command line arguments.")
        return
    }

    val mark1 = args[0].toDoubleOrNull()
    val mark2 = args[1].toDoubleOrNull()
    val mark3 = args[2].toDoubleOrNull()

    if (mark1 == null || mark2 == null || mark3 == null) {
        println("Please provide valid numeric grades.")
        return
    }

    val average = ((mark1 + mark2 + mark3) / 3.0).roundToInt()
    val grade = when (average) {
        in 70..100 -> "Distinction"
        in 40..69 -> "Pass"
        in 0..39 -> "Fail"
        else -> "Invalid average"
    }

    println("Average: $average, Grade: $grade")
}