// Task 12.5.3: demo program for class with custom setter

import kotlinx.datetime.LocalDate

fun main() {
    val person = Person("Dave", LocalDate(1997, 8, 23))
    println(person.name)

    // Assigning an empty string to the name property triggers the custom
    // setter, which rejects it with an IllegalArgumentException.
    person.name = ""
    println(person.name)
}
