// Task 12.5.2: demo program for class with custom getter

import kotlinx.datetime.LocalDate

fun main() {
    val person = Person("Dave", LocalDate(1997, 8, 23))

    // The custom getter converts the stored value to upper case before
    // returning it, so the name is printed in upper case.
    println(person.name)
}
