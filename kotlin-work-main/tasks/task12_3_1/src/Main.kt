// Task 12.3.1: demo of secondary constructors

fun main() {
    // The original version of this program called Point(4.5, 7.0). Removing
    // the arguments gave an error ("no value passed for parameter 'x'"), so
    // the no-argument secondary constructor was added to Point.
    val p = Point()
    println("(${p.x}, ${p.y})")

    // Calling Point(4, 7) gave a type error (Int where Double was expected),
    // so a second secondary constructor, taking Int coordinates, was added.
    val q = Point(4, 7)
    println("(${q.x}, ${q.y})")

    // The primary constructor still works as before.
    val r = Point(4.5, 7.0)
    println("(${r.x}, ${r.y})")
}
