// Task 7.7.1: program to compute stats for a numeric dataset

fun main(args: Array<String>) {
    val filename = if (args.isNotEmpty()) args[0] else "data.txt"
    val data = readData(filename)
    displayStats(data)
}

