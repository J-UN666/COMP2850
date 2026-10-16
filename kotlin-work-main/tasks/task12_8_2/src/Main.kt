// Task 12.8.2: program to manipulate playing cards

fun main() {
    // Build a full deck of 52 cards: one of each rank in each of the four suits.
    val deck = mutableListOf<Card>()

    for (suit in Suit.entries) {
        for (rank in Rank.entries) {
            deck.add(Card(rank, suit))
        }
    }

    // Shuffle the deck into a random order.
    deck.shuffle()

    for (card in deck) {
        println(card.fullName)
    }
}
