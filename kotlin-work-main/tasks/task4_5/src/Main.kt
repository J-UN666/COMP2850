// Task 4.5: summing odd integers with a for loop

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Please provide a maximum integer as a command line argument.")
        exitProcess(1)
    }
    val max = args[0].toLongOrNull()
    if (max == null) {
        println("Please provide a valid integer as a command line argument.")
        exitProcess(1)
    }
    var sum = 0L
    for (i in 1L..max step 2) {
        sum += i
    }
    println("The sum of odd integers from 1 to $max is: $sum")
}