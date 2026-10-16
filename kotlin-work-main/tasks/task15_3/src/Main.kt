// Task 15.3: program demonstrating dynamic binding

fun main() {
    // The list is declared to hold Person objects, but it actually contains
    // a mixture of Person objects and Student objects. This is fine, because
    // every Student is also a Person.
    val people: List<Person> = listOf(
        Person("Dave"),
        Student("Sarah", "Computer Science"),
        Person("Ali"),
        Student("Chloe", "Mathematics")
    )

    for (person in people) {
        // Dynamic binding: the version of describe() that runs is chosen at
        // run time, according to the actual type of the object - not the
        // declared type of the variable. So the Students print the overridden
        // message, and the plain Persons print the inherited one.
        println(person.describe())
    }
}
