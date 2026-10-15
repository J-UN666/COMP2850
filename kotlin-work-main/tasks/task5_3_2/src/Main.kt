// Task 5.3.2: main program
fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Error: Please provide a dice specification such as 3d6 or 2d12.")
        return
    }

    val specification = args[0]
    val parts = specification.split('d', ignoreCase = true)

    if (parts.size != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
        println("Error: Please provide a valid dice specification such as 3d6.")
        return
    }

    val numberOfDice = parts[0].toIntOrNull()
    val sides = parts[1].toIntOrNull()

    if (numberOfDice == null || sides == null) {
        println("Error: Please provide valid integers in the dice specification.")
        return
    }

    rollDice(numberOfDice, sides)
}
