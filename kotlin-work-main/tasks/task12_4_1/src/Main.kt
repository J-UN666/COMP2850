// Task 12.4.1: main program

fun main() {
    val centre = Point(0.0, 0.0)
    val circle = Circle(centre, 5.0)

    println("Circle with centre (${centre.x}, ${centre.y}) and radius ${circle.radius}")
    println("Area:      ${circle.area()}")
    println("Perimeter: ${circle.perimeter()}")

    val inside = Point(1.0, 1.0)
    val onEdge = Point(0.0, 5.0)
    val outside = Point(6.0, 0.0)

    println("Contains (${inside.x}, ${inside.y})?  ${circle.contains(inside)}")
    println("Contains (${onEdge.x}, ${onEdge.y})?  ${circle.contains(onEdge)}")
    println("Contains (${outside.x}, ${outside.y})? ${circle.contains(outside)}")
}
