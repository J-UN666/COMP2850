// Task 8.3: weather station temperature analysis program

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Error: no filename on command line")
        exitProcess(1)
    }

    val data = fetchData(args[0])

    val lowest = data.minByOrNull { it.second }!!
    val highest = data.maxByOrNull { it.second }!!
    val average = data.map { it.second }.average()

    println("Lowest temperature: ${lowest.first} (${lowest.second})")
    println("Highest temperature: ${highest.first} (${highest.second})")
    println("Average temperature: $average")
}
