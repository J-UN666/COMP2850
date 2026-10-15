// Task 5.5: infix extension function
infix fun String.anagramOf(other: String): Boolean {
    if (this.length != other.length) {
        return false
    }
    val firstChars = this.lowercase().toList().sorted()
    val secondChars = other.lowercase().toList().sorted()
    return firstChars == secondChars
}
