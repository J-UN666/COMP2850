// Task 12.3.3: demo of initializer block

fun main() {
    val person = Person("Dave", "1997-08-23")
    println("Name:           ${person.name}")
    println("Date of birth:  ${person.birth}")
    println("Marital status: ${if (person.isMarried) "married" else "single"}")

    // Before the init block was added, both of the following succeeded and
    // created Person objects with useless names. They now throw an
    // IllegalArgumentException, so the first one aborts the program.
    println()
    println("Attempting to create a Person with an empty name...")
    Person("", "1997-08-23")

    println("Attempting to create a Person with a blank name...")
    Person("   ", "1997-08-23")
}
