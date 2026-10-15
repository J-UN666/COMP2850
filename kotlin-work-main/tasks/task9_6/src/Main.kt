// Task 9.6: application to compute dataset variance

import java.nio.file.NoSuchFileException
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Usage: kotlin run <datafile>")
        exitProcess(1)
    }

    try {
        val data = readData(args[0])
        println("Variance: ${variance(data)}")
    }
    catch (error: NoSuchFileException) {
        println("Cannot open file ${args[0]}")
        exitProcess(1)
    }
    catch (error: NumberFormatException) {
        println("Data file contains a line that is not a number")
        exitProcess(1)
    }
    catch (error: IllegalArgumentException) {
        println(error.message)
        exitProcess(1)
    }
}
