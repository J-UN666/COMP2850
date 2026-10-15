// Task 9.6: variance() function

fun variance(data: List<Double>): Double {
    require(data.size >= 2) { "Cannot compute variance of fewer than two values" }

    val mean = data.average()
    val sumOfSquares = data.sumOf { (it - mean) * (it - mean) }

    return sumOfSquares / (data.size - 1)
}
