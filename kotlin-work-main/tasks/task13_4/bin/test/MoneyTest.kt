// Task 13.4: unit tests for Money class

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.withClue
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class MoneyTest : FreeSpec({

    // ----- Test fixture -----

    val zero = Money(0, 0)
    val tenPence = Money(0, 10)
    val onePound = Money(1, 0)
    val twelveNinetyNine = Money(12, 99)
    val nineteenNinetyNine = Money(19, 99)

    fun shouldReject(clue: String, create: () -> Money) {
        withClue(clue) { shouldThrow<IllegalArgumentException> { create() } }
    }

    // ----- Storing the components -----

    "Pounds stored correctly" {
        onePound.pounds shouldBe 1
        twelveNinetyNine.pounds shouldBe 12
        zero.pounds shouldBe 0
    }

    "Pence stored correctly" {
        tenPence.pence shouldBe 10
        twelveNinetyNine.pence shouldBe 99
        zero.pence shouldBe 0
    }

    // ----- Validating the arguments -----

    "Exception if pounds are negative" {
        shouldReject("-1") { Money(-1, 0) }
    }

    "Exception if pence are negative" {
        shouldReject("-1") { Money(0, -1) }
    }

    "Exception if pence are 100 or more" {
        shouldReject("100") { Money(0, 100) }
        shouldReject("150") { Money(0, 150) }
    }

    // ----- The totalPence computed property -----

    "Total pence are computed correctly" {
        withClue("$zero") { zero.totalPence shouldBe 0 }
        withClue("$tenPence") { tenPence.totalPence shouldBe 10 }
        withClue("$onePound") { onePound.totalPence shouldBe 100 }
        withClue("$twelveNinetyNine") { twelveNinetyNine.totalPence shouldBe 1299 }
    }

    // ----- The fromPence factory method -----

    "Money can be created from a total number of pence" {
        withClue("0") { Money.fromPence(0) shouldBe zero }
        withClue("10") { Money.fromPence(10) shouldBe tenPence }
        withClue("100") { Money.fromPence(100) shouldBe onePound }
        withClue("1299") { Money.fromPence(1299) shouldBe twelveNinetyNine }
    }

    "Exception if the total number of pence is negative" {
        shouldReject("-1") { Money.fromPence(-1) }
    }

    // ----- Arithmetic -----

    "Amounts can be added" {
        withClue("£0.00 + £0.00") { zero + zero shouldBe zero }
        withClue("£0.10 + £0.10") { tenPence + tenPence shouldBe Money(0, 20) }
        withClue("£1.00 + £0.10") { onePound + tenPence shouldBe Money(1, 10) }
    }

    "Adding amounts carries into pounds" {
        // This is the case that makes the pence field need normalising
        withClue("£0.99 + £0.01") { Money(0, 99) + Money(0, 1) shouldBe onePound }
        withClue("£12.99 + £7.00") { twelveNinetyNine + Money(7, 0) shouldBe nineteenNinetyNine }
    }

    "Amounts can be subtracted" {
        withClue("£1.00 - £0.10") { onePound - tenPence shouldBe Money(0, 90) }
        withClue("£19.99 - £7.00") { nineteenNinetyNine - Money(7, 0) shouldBe twelveNinetyNine }
    }

    "Subtracting amounts borrows from pounds" {
        withClue("£1.00 - £0.01") { onePound - Money(0, 1) shouldBe Money(0, 99) }
    }

    "Exception if the result of a subtraction would be negative" {
        shouldReject("£0.10 - £1.00") { tenPence - onePound }
    }

    "Amounts can be multiplied by a whole number" {
        withClue("£12.99 × 3") { twelveNinetyNine * 3 shouldBe Money(38, 97) }
        withClue("£12.99 × 0") { twelveNinetyNine * 0 shouldBe zero }
    }

    "Exception if multiplying by a negative number" {
        shouldReject("× -1") { twelveNinetyNine * -1 }
    }

    // ----- The string representation -----

    "Amounts formatted correctly as string" {
        withClue("£0.00") { zero.toString() shouldBe "£0.00" }
        withClue("£0.10") { tenPence.toString() shouldBe "£0.10" }
        withClue("£1.00") { onePound.toString() shouldBe "£1.00" }
        withClue("£0.05") { Money(0, 5).toString() shouldBe "£0.05" }
        withClue("£12.99") { twelveNinetyNine.toString() shouldBe "£12.99" }
    }
})
