// Task 12.9: class implementing the Static Factory Method pattern

import kotlinx.datetime.LocalDate

/**
 * The constructor is private, so Person objects can only be created by the
 * `create()` factory method in the companion object.
 */
class Person private constructor(val name: String, val birth: LocalDate) {

    companion object {

        /** The names of all the people created so far. */
        private val names = mutableSetOf<String>()

        /**
         * Creates a new Person. Names must be unique, so an attempt to
         * create a second person with the same name as an existing one
         * fails with an IllegalArgumentException.
         */
        fun create(name: String, birth: LocalDate): Person {
            require(names.add(name)) { "There is already a person called $name" }
            return Person(name, birth)
        }
    }
}
