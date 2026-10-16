// Task 16.2: main program

fun main() {
    // A Vehicle variable can refer to a Car object, but we are not allowed
    // to create a Vehicle object itself. Uncommenting the next line gives
    // the error "Cannot create an instance of an abstract class":
    //
    //     val v = Vehicle("AB12 CDE", 4)

    val vehicles: List<Vehicle> = listOf(
        Car("AB12 CDE", 5),
        Car("XY34 ZAB", 3)
    )

    for (vehicle in vehicles) {
        // describe() is abstract in Vehicle, so the version that runs is
        // chosen at run time from the actual type of the object
        println("${vehicle.describe()} - ${vehicle.wheelCount}")
    }
}
