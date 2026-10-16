// Task 12.4.2: demo program for Point with overridden toString()

fun main() {
    // Before toString() was overridden, this printed the class name followed
    // by the object's identity hash code, e.g. "Point@1b6d3586". It now
    // prints the point's coordinates, because println() calls toString().
    val p = Point(3.0, 4.0)
    println(p)

    // The method can also be called explicitly.
    println(p.toString())
}
