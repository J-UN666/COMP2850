// Task 12.7: data classes vs regular classes

import kotlinx.datetime.LocalDate

fun main() {
    val birthDate = LocalDate(1997, 8, 23)

    // ----- A regular class: equality and hashing use object identity -----
    println("=== Regular class ===")
    val p1 = Person("Dave", birthDate)
    val p2 = Person("Dave", birthDate)

    println("p1 == p1?     : ${p1 == p1}")
    println("p1 == p2?     : ${p1 == p2}")

    println("p1.hashCode() : %08x".format(p1.hashCode()))
    println("p2.hashCode() : %08x".format(p2.hashCode()))

    println("p1.toString() : $p1")
    println("p2.toString() : $p2")

    // ----- A data class: equality and hashing use the property values -----
    println()
    println("=== Data class ===")
    val d1 = DataPerson("Dave", birthDate)
    val d2 = DataPerson("Dave", birthDate)

    println("d1 == d1?     : ${d1 == d1}")
    println("d1 == d2?     : ${d1 == d2}")

    println("d1.hashCode() : %08x".format(d1.hashCode()))
    println("d2.hashCode() : %08x".format(d2.hashCode()))

    println("d1.toString() : $d1")
    println("d2.toString() : $d2")

    // ----- The danger of mutable properties in a data class -----
    // `isMarried` is declared as a `var` in the primary constructor, so it
    // takes part in equals(), hashCode() and toString(). Changing it changes
    // the object's hash code, which would corrupt any hash-based collection
    // that the object had been added to. Data classes should be immutable.
    println()
    println("=== Data class with a mutable property ===")
    println("d1 marries")
    d1.isMarried = true

    println("d1 == d2?     : ${d1 == d2}")
    println("d1.hashCode() : %08x".format(d1.hashCode()))
    println("d1.toString() : $d1")

    // ----- copy() is another member that only a data class provides -----
    println()
    println("d1.copy(name = \"Diane\") : ${d1.copy(name = "Diane")}")
}
