// Task 15.2.3: SavingsAccount class

class SavingsAccount(holder: String, val rate: Double) : BankAccount(holder) {

    /**
     * Accrues interest on the current balance, at the account's rate, which
     * is expressed as a percentage. The accrued interest is then deposited
     * in the account.
     */
    fun applyInterest() {
        val interest = (balance * rate / 100.0).toInt()
        deposit(interest)
    }
}
