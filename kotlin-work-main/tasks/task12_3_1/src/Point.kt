// Task 12.3.1: class with secondary constructors

class Point(var x: Double, var y: Double) {

    /** Creates a point at the origin. */
    constructor() : this(0.0, 0.0)

    /** Creates a point from integer coordinates. */
    constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble())
}
