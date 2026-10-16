// Task 12.5.4: demo program for class with a computed property

import kotlinx.datetime.LocalDate

fun main() {
    val person = Person("Dave", LocalDate(1997, 8, 23))

    println("${person.name} was born on ${person.birth}")
    println("Today is ${today()}")
    println("${person.name} is ${person.age} years old")
}
