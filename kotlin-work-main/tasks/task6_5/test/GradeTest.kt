// Task 6.5: unit tests for grade()

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.withClue
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class GradeTest : FreeSpec({
    "grade()" - {
        "marks below 40 should fail" - {
            listOf(0, 20, 39).forEach { mark ->
                withClue("for mark $mark") {
                    grade(mark) shouldBe "Fail"
                }
            }
        }

        "marks 40 to 69 should pass" - {
            listOf(40, 55, 69).forEach { mark ->
                withClue("for mark $mark") {
                    grade(mark) shouldBe "Pass"
                }
            }
        }

        "marks 70 and above should be distinction" - {
            listOf(70, 85, 100).forEach { mark ->
                withClue("for mark $mark") {
                    grade(mark) shouldBe "Distinction"
                }
            }
        }

        "invalid marks should return ?" - {
            listOf(-1, -5, 101, 105).forEach { mark ->
                withClue("for mark $mark") {
                    grade(mark) shouldBe "?"
                }
            }
        }
    }
})
