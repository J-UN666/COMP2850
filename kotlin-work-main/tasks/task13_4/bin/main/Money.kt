// Task 13.4: Money class

/**
 * An amount of money, in pounds and pence.
 *
 * This class was developed test-first: the tests in `MoneyTest.kt` were
 * written before this implementation, and each piece of code below was added
 * only in order to make a failing test pass.
 */
data class Money(val pounds: Int, val pence: Int) {

    companion object {
        const val PENCE_PER_POUND = 100

        /** Creates a Money object from a total number of pence. */
        fun fromPence(total: Int): Money {
            require(total >= 0) { "amount cannot be negative" }
            return Money(total / PENCE_PER_POUND, total % PENCE_PER_POUND)
        }
    }

    init {
        require(pounds >= 0) { "pounds cannot be negative" }
        require(pence in 0 until PENCE_PER_POUND) { "pence must be in the range 0..99" }
    }

    /** The value of this amount, expressed as a total number of pence. */
    val totalPence: Int get() = pounds * PENCE_PER_POUND + pence

    operator fun plus(other: Money) = fromPence(totalPence + other.totalPence)

    operator fun minus(other: Money): Money {
        require(totalPence >= other.totalPence) { "result cannot be negative" }
        return fromPence(totalPence - other.totalPence)
    }

    operator fun times(factor: Int): Money {
        require(factor >= 0) { "factor cannot be negative" }
        return fromPence(totalPence * factor)
    }

    override fun toString() = "£%d.%02d".format(pounds, pence)
}
