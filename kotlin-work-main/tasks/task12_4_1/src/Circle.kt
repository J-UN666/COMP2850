// Task 12.4.1: Circle class

import kotlin.math.PI

/**
 * A circle, defined by its [centre] point and its [radius].
 */
class Circle(val centre: Point, val radius: Double) {

    init {
        require(radius > 0.0) { "Radius must be greater than zero" }
    }

    /** The area of this circle. */
    fun area() = PI * radius * radius

    /** The perimeter (circumference) of this circle. */
    fun perimeter() = 2.0 * PI * radius

    /**
     * Returns `true` if [p] lies inside this circle, i.e. if its distance
     * from the centre is less than or equal to the radius.
     */
    fun contains(p: Point) = centre.distanceTo(p) <= radius
}
