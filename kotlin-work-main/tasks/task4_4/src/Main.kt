// Task 4.4: temperature conversion using a while loop

import kotlin.system.exitProcess

import com.github.ajalt.mordant.rendering.AnsiLevel
import com.github.ajalt.mordant.rendering.TextAlign
import com.github.ajalt.mordant.rendering.TextColors.*
import com.github.ajalt.mordant.table.table
import com.github.ajalt.mordant.terminal.Terminal

fun main(args: Array<String>) {
    if (args.size != 3) {
        println("Please provide an initial temperature in Celsius; a maximum temperature in Celsius; and a temperature increment.")
        return
    }
    val initialTemp = args[0].toDouble()
    val maxTemp = args[1].toDouble()
    val increment = args[2].toDouble()
    var currentTemp = initialTemp
    while (currentTemp <= maxTemp) {
        val fahrenheit = (currentTemp * 9 / 5) + 32
        currentTemp += increment
        if (currentTemp <= maxTemp) {
            println("%8.1f C | %8.1f F".format(currentTemp, fahrenheit))
        }
    }
    
}
