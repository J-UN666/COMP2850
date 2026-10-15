// Task 7.7.2: phone book simulator

const val CSV_FILENAME = "phone.csv"

fun main() {
    val database = createDatabase()
    database.load(CSV_FILENAME)
    println("Database loaded. ${database.size} contacts found.")

    while (true) {
        print("\nEnter contact name (or 'exit' to quit): ")
        val input = readlnOrNull()?.trim() ?: break

        if (input.isEmpty()) continue
        if (input.equals("exit", ignoreCase = true)) break

        val existingPhone = database[input]
        if (existingPhone != null) {
            println("Phone number for $input: $existingPhone")
        } else {
            print("Contact '$input' not found. Please enter phone number: ")
            val phone = readlnOrNull()?.trim()

            if (phone.isNullOrBlank()) {
                println("Error: Phone number cannot be empty.")
            } else if (!phone.all { it.isDigit() }) {
                println("Error: Phone number must contain only digits.")
            } else {
                database[input] = phone
                database.save(CSV_FILENAME)
                println("Contact saved successfully!")
            }
        }
    }

    println("Goodbye!")
}