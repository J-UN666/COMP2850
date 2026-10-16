// Task 13.5: unit tests for CurrencyConverter
// (using a stub for ExchangeRateService)

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
// Note: any(), firstArg() and answers() need no import - they are members of
// the MockKMatcherScope and MockKStubScope receivers that every {} and
// answers {} provide.

const val tolerance = 0.00001

class CurrencyConverterTest : FreeSpec({

    // ----- Test fixture -----
    // The real ExchangeRateService fetches live rates over the network, which
    // would make these tests slow, unreliable and dependent on the internet.
    // Instead, each test uses a stand-in service that returns a fixed set of
    // rates, so that only the CurrencyConverter itself is under test.

    fun serviceWithRates(rates: Map<String, Double>): ExchangeRateService {
        val service = mockk<ExchangeRateService>()
        every { service.updateRates() } just Runs
        every { service.rateFor(any()) } answers {
            val currency = firstArg<String>()
            rates[currency] ?: throw IllegalArgumentException("Unsupported currency: $currency")
        }
        return service
    }

    val converter = CurrencyConverter(
        serviceWithRates(mapOf("USD" to 1.28, "JPY" to 192.45, "EUR" to 1.17))
    )

    // NOTE: the tolerance expression must be parenthesised. Infix functions
    // all share one precedence level and associate to the left, so writing
    //
    //     result shouldBe 1.92 plusOrMinus tolerance
    //
    // actually parses as
    //
    //     (result shouldBe 1.92) plusOrMinus tolerance
    //
    // which compares for exact equality (and then throws the Tolerance away).
    // That silently passes whenever the arithmetic happens to be exact, and
    // fails by one ulp when it is not.

    "Converts an amount to another currency using the supplied rate" {
        converter.convertTo("USD", 1.50) shouldBe (1.92 plusOrMinus tolerance)
        converter.convertTo("EUR", 1.50) shouldBe (1.755 plusOrMinus tolerance)
        converter.convertTo("JPY", 1.50) shouldBe (288.675 plusOrMinus tolerance)
    }

    "Converts exactly one unit of currency" {
        // The converted amount should just be the rate itself
        converter.convertTo("USD", 1.0) shouldBe (1.28 plusOrMinus tolerance)
    }

    "Converting a zero amount gives a zero amount" {
        converter.convertTo("USD", 0.0) shouldBe (0.0 plusOrMinus tolerance)
    }

    "Converting a negative amount reverses the sign" {
        converter.convertTo("USD", -1.50) shouldBe (-1.92 plusOrMinus tolerance)
    }

    "Converting to the same currency preserves the amount" {
        val service = serviceWithRates(mapOf("GBP" to 1.0))
        val identity = CurrencyConverter(service)

        identity.convertTo("GBP", 42.50) shouldBe (42.50 plusOrMinus tolerance)
    }

    "Conversion fails for a currency with no known rate" {
        shouldThrow<IllegalArgumentException> {
            converter.convertTo("XYZ", 10.0)
        }
    }
})
