// Task 13.2: unit tests for Time class

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.withClue
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TimeTest : FreeSpec({

    // ----- Test fixture -----
    // A set of Time objects shared by the tests below. Building each of them
    // once, here, removes the need to repeat the same constructions in every
    // test. Each object's own string representation makes a convenient clue.

    val midnight = Time(0, 0, 0)
    val fiveSec = Time(0, 0, 5)
    val thirtySec = Time(0, 0, 30)
    val fiveMin = Time(0, 5, 0)
    val thirtyMin = Time(0, 30, 0)
    val fiveHours = Time(5, 0, 0)
    val noon = Time(12, 0, 0)
    val endOfDay = Time(23, 59, 59)

    // All the invalid constructions below should raise the same exception,
    // so this helper removes the repeated withClue/shouldThrow scaffolding.
    fun shouldReject(clue: String, create: () -> Time) {
        withClue(clue) { shouldThrow<IllegalArgumentException> { create() } }
    }

    // ----- Storing the components -----

    "Hours stored correctly" {
        fiveHours.hours shouldBe 5
        noon.hours shouldBe 12
        midnight.hours shouldBe 0
    }

    "Minutes stored correctly" {
        thirtyMin.minutes shouldBe 30
        midnight.minutes shouldBe 0
    }

    "Seconds stored correctly" {
        thirtySec.seconds shouldBe 30
        midnight.seconds shouldBe 0
    }

    // ----- Validating the arguments -----

    "Exception if hours are invalid" {
        shouldReject("-1") { Time(-1, 0, 0) }
        shouldReject("24") { Time(24, 0, 0) }
    }

    "Exception if minutes are invalid" {
        shouldReject("-1") { Time(0, -1, 0) }
        shouldReject("60") { Time(0, 60, 0) }
    }

    "Exception if seconds are invalid" {
        shouldReject("-1") { Time(0, 0, -1) }
        shouldReject("60") { Time(0, 0, 60) }
    }

    // ----- The secondsSinceMidnight computed property -----

    "Seconds since midnight are computed correctly" {
        withClue("$midnight") { midnight.secondsSinceMidnight shouldBe 0 }
        withClue("$thirtySec") { thirtySec.secondsSinceMidnight shouldBe 30 }
        withClue("$fiveMin") { fiveMin.secondsSinceMidnight shouldBe 300 }
        withClue("$fiveHours") { fiveHours.secondsSinceMidnight shouldBe 18_000 }
        withClue("$endOfDay") { endOfDay.secondsSinceMidnight shouldBe 86_399 }
    }

    // ----- The string representation -----

    "Components formatted correctly as string" {
        withClue("midnight") { midnight.toString() shouldBe "00:00:00" }
        withClue("5am") { fiveHours.toString() shouldBe "05:00:00" }
        withClue("noon") { noon.toString() shouldBe "12:00:00" }
        withClue("5 sec") { fiveSec.toString() shouldBe "00:00:05" }
        withClue("30 sec") { thirtySec.toString() shouldBe "00:00:30" }
        withClue("5 min") { fiveMin.toString() shouldBe "00:05:00" }
        withClue("30 min") { thirtyMin.toString() shouldBe "00:30:00" }
    }
})
