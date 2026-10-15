// Task 5.1.2: main program
fun main(args: Array<String>) {
    if (args.size > 1) {
        println("Error: Please provide either zero or one argument for the number of sides.")
        println("Example: java -jar app.jar 6")
        return
    }

    if (args.isEmpty()) {
        rollDie()
        return
    }

    val sides = args[0].toIntOrNull()
    if (sides == null) {
        println("Error: Please provide a valid integer for the number of sides.")
        return
    }

    rollDie(sides)
}