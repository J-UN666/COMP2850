// Task 14.1: program that uses Customer

// Customer now belongs to the myapp.orders package, so it has to be either
// imported like this, or referred to by its fully qualified name,
// myapp.orders.Customer. Both approaches work; the import is tidier.
import myapp.orders.Customer

fun main() {
    val customer = Customer("Joe Smith", "joe@example.com")
    println(customer)
}
