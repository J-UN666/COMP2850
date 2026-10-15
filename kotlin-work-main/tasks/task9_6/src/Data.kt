// Task 9.6: readData() function

import kotlin.io.path.Path
import kotlin.io.path.forEachLine

fun readData(filename: String): List<Double> {
    val data = mutableListOf<Double>()

    Path(filename).forEachLine { line ->
        val text = line.trim()
        if (text.isNotEmpty()) {
            data.add(text.toDouble())
        }
    }

    return data
}
