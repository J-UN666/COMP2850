// Task 8.5: example of a higher-order function

fun <T> howMany(items: List<T>, condition: (T) -> Boolean): Int {
    var count = 0
    for (item in items) {
        if (condition(item)) {
            count++
        }
    }
    return count
}
