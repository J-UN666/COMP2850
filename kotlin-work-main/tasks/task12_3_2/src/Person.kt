// Task 12.3.2: Person class with secondary constructor

import kotlinx.datetime.LocalDate

class Person(val name: String, val birth: LocalDate) {

    var isMarried = false

    /** Creates a person whose date of birth is given in ISO 8601 format. */
    constructor(name: String, birth: String) : this(name, LocalDate.parse(birth))
}
