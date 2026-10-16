// Task 12.1: Point class

import kotlin.math.hypot

/**
 * A point in 2D space, with `x` and `y` coordinates.
 */
class Point(var x: Double, var y: Double) {

    /** Creates a point at the origin. */
    constructor() : this(0.0, 0.0)

    /** Creates a point from integer coordinates. */
    constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble())

    /** The distance of this point from the origin. */
    fun distance() = hypot(x, y)

    /** The distance of this point from another point. */
    fun distanceTo(other: Point) = hypot(x - other.x, y - other.y)

    override fun toString() = "($x, $y)"
}
