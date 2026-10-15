// Task 4.2: use of if and ranges

fun main() {
    println("Choose your pizza (a-d):")
    println("(a) Margherita")
    println("(b) Quattro Stagioni")
    println("(c) Seafood")
    println("(d) Hawaiian")
    val choice = readln().lowercase()
    val message = if(choice.length == 1 && choice[0] in 'a'..'d') {
        "Choose your pizza (a-d): $choice\nOrder accepted"                                
    } else {
        "Invalid choice!"
    }
    println(message)
}
