// Task 15.2.3: demo program

// Note: amounts are printed without a currency symbol, because the Windows
// console cannot render the pound sign in the default character encoding.

fun main() {
    val account = SavingsAccount("Sarah", 1.8)

    account.deposit(1250)
    println("Balance after depositing 1250:      ${account.balance}")

    // Accrue interest for five years
    repeat(5) { year ->
        account.applyInterest()
        println("Balance after year ${year + 1} interest:    ${account.balance}")
    }

    account.withdraw(50)
    println("Balance after withdrawing 50:       ${account.balance}")

    println()
    println("Final balance: ${account.balance}")
}
