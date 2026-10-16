// Task 12.3.2: demo of Person class with secondary constructor

fun main() {
    // Date of birth is supplied as an ISO 8601 string, which the secondary
    // constructor parses into a LocalDate.
    val person = Person("Dave", "1997-08-23")

    println("Name:           ${person.name}")
    println("Date of birth:  ${person.birth}")
    println("Marital status: ${if (person.isMarried) "married" else "single"}")
}
