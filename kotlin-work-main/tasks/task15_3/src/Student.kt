// Task 15.3: Student class, demonstrating method overriding

class Student(name: String, val degree: String) : Person(name) {

    /**
     * Overrides Person.describe(). The `override` keyword is compulsory:
     * without it, the compiler reports that this function hides a member of
     * the superclass and needs it.
     */
    override fun describe() = "Student called $name, studying $degree"
}
