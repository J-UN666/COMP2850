// Task 12.9: demo program for class implementing Static Factory Method

import kotlinx.datetime.LocalDate

fun main() {
    // Calling the constructor directly, like this:
    //
    //     val p = Person("Dave", LocalDate(1997, 8, 23))
    //
    // no longer compiles, because the constructor is private. The only way
    // to create a Person is via the create() method in the companion object.
    val p = Person.create("Dave", LocalDate(1997, 8, 23))
    println("Created ${p.name}, born ${p.birth}")

    // create() enforces the invariant that names are unique, so this second
    // attempt fails at run time with an IllegalArgumentException.
    println("Attempting to create a second person called ${p.name}...")
    Person.create("Dave", LocalDate(2001, 1, 1))
}
