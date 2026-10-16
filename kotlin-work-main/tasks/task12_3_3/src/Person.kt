// Task 12.3.3: Person class with an initializer block

import kotlinx.datetime.LocalDate

class Person(val name: String, val birth: LocalDate) {

    var isMarried = false

    init {
        require(name.isNotBlank()) { "Name cannot be blank" }
    }

    /** Creates a person whose date of birth is given in ISO 8601 format. */
    constructor(name: String, birth: String) : this(name, LocalDate.parse(birth))
}
