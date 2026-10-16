// Task 12.7: data classes vs regular classes

import kotlinx.datetime.LocalDate

/**
 * A regular class. The compiler generates none of equals(), hashCode() or
 * toString() for it, so all three are inherited from Any and are based on
 * the identity of the object rather than on its property values.
 */
class Person(val name: String, val birth: LocalDate, var isMarried: Boolean = false)

/**
 * Exactly the same class, but declared with the `data` modifier. The compiler
 * now generates equals(), hashCode(), toString() and copy() from the
 * properties declared in the primary constructor.
 */
data class DataPerson(val name: String, val birth: LocalDate, var isMarried: Boolean = false)
