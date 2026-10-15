// Task 7.7.2: database-handling functions

import java.io.File


typealias Database = MutableMap<String, String>

fun createDatabase(): Database = mutableMapOf()

fun Database.load(filename: String) {
    val file = File(filename)
    if (!file.exists()) {
        clear()
        return
    }

    clear()
    file.readLines()
        .filter { it.isNotBlank() }
        .forEach { line ->
            val parts = line.split(",", limit = 2)
            if (parts.size == 2) {
                val name = parts[0].trim()
                val phone = parts[1].trim()
                if (name.isNotEmpty()) {
                    this[name] = phone
                }
            }
        }
}

fun Database.save(filename: String) {
    val file = File(filename)
    val content = entries.joinToString("\n") { "${it.key},${it.value}" }
    file.writeText(content)
}