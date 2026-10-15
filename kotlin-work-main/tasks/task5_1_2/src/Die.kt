// Task 5.1.2: rollDie() function
// Die.kt
// Die.kt
import kotlin.random.Random

fun rollDie(sides: Int) {
    // 检查面数是否合法
    if (sides in setOf(4, 6, 8, 10, 12, 20)) {
        println("Rolling a d$sides...")
        // 注意：Random.nextInt 的区间是左闭右开的 [1, sides + 1)
        // 所以这里用 sides + 1 才能包含最大面数
        val result = Random.nextInt(1, sides + 1)
        println("You rolled $result")
    } else {
        println("Error: cannot have a $sides-sided die")
    }
}