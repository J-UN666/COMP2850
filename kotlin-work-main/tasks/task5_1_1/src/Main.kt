// Task 5.1.1: main program
// Main.kt

fun main(args: Array<String>) {
    
    if (args.size < 2) {
        println("Error: Please provide two words as command line arguments.")
        println("Example: java -jar app.jar listen silent")
        return 
    }

    
    val word1 = args[0]
    val word2 = args[1]

    
    val isAnagram = anagrams(word1, word2)

    
    if (isAnagram) {
        println("'$word1' and '$word2' are anagrams.")
    } else {
        println("'$word1' and '$word2' are not anagrams.")
    }
}