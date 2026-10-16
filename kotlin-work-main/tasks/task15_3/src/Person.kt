// Task 15.3: Person class

open class Person(val name: String) {

    /**
     * A one-line description of this person. Declared `open` so that
     * subclasses are allowed to override it.
     */
    open fun describe() = "Person called $name"
}
