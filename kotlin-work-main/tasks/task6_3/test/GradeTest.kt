// Task 6.3: unit tests for grade()

import kotlin.test.Test
import kotlin.test.assertEquals

class GradeTest {
    @Test
    fun testFailMarks() {
        assertEquals("Fail", grade(0))
        assertEquals("Fail", grade(39))
    }

    @Test
    fun testPassMarks() {
        assertEquals("Pass", grade(40))
        assertEquals("Pass", grade(50))
        assertEquals("Pass", grade(70))
    }

    @Test
    fun testDistinctionMarks() {
        assertEquals("Distinction", grade(75))
        assertEquals("Distinction", grade(100))
    }

    @Test
    fun testInvalidMarks() {
        assertEquals("?", grade(-1))
        assertEquals("?", grade(101))
    }
}
