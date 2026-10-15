// Task 5.3.2: rollDice() function
import kotlin.random.Random

fun rollDice(numberOfDice: Int = 1, sides: Int = 6) {
    if (numberOfDice <= 0) {
        println("Error: number of dice must be positive")
        return
    }

    if (sides !in setOf(4, 6, 8, 10, 12, 20)) {
        println("Error: cannot have a $sides-sided die")
        return
    }

    var total = 0
    for (i in 1..numberOfDice) {
        total += Random.nextInt(1, sides + 1)
    }

    println("Rolling $numberOfDice d$sides...")
    println("You rolled $total")
}
