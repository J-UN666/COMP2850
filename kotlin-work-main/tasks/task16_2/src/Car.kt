// Task 16.2: concrete Car class, inheriting from Vehicle

/**
 * A concrete subclass of Vehicle. It must override `describe()`, because
 * that method is abstract in the superclass.
 */
class Car(registration: String, val doors: Int) : Vehicle(registration, wheels = 4) {

    override fun describe() = "Car $registration with $doors doors"
}
