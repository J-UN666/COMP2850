// Task 12.1: program that uses a Point object

fun main() {
    // A point built from its primary constructor (double coordinates)
    val p = Point(3.0, 4.0)
    println("p = $p")
    println("Distance of p from the origin: ${p.distance()}")

    // A point built from the secondary constructor that takes integers
    val q = Point(4, 7)
    println("q = $q")

    // A point built from the secondary constructor with no arguments
    val origin = Point()
    println("origin = $origin")

    // The distance between two points
    println("Distance between p and q: ${p.distanceTo(q)}")

    // The properties are mutable, so a point can be moved
    p.x = 0.0
    p.y = 5.0
    println("After moving p: $p")
    println("Distance of p from the origin: ${p.distance()}")
}
