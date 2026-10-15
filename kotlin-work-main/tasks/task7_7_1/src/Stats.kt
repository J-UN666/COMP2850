// Task 7.7.1: statistics functions

fun median(data: List<Double>): Double {
    require(data.isNotEmpty()) { "Cannot compute median of an empty list" }

    val sorted = data.sorted()
    val middle = sorted.size / 2

    return if (sorted.size % 2 == 0) {
        (sorted[middle - 1] + sorted[middle]) / 2.0
    } else {
        sorted[middle]
    }
}

fun displayStats(data: List<Double>) {
    if (data.isEmpty()) {
        println("No data available.")
        return
    }

    val sorted = data.sorted()
    println("Count: ${data.size}")
    println("Minimum: ${sorted.first()}")
    println("Maximum: ${sorted.last()}")
    println("Mean: ${data.average()}")
    println("Median: ${median(data)}")
}

