// Task 16.2: abstract Vehicle class

/**
 * An abstract superclass representing any kind of vehicle.
 *
 * The class is abstract for two reasons: it is not meaningful to create a
 * plain Vehicle object, and it declares an abstract method, `describe()`,
 * which every concrete subclass must provide.
 */
abstract class Vehicle(val registration: String, val wheels: Int) {

    /** A one-line description of this vehicle. */
    abstract fun describe(): String

    /** The number of wheels on this vehicle, as a word. */
    val wheelCount: String get() = if (wheels == 1) "1 wheel" else "$wheels wheels"
}
