// Task 4.7: finding the longest line in a file

import java.io.File

fun main(args: Array<String>) {
	if (args.size != 1) {
		println("Please provide the name of an input file.")
		return
	}

	var longestLineNumber = 0
	var longestLength = -1

	File(args[0]).useLines { lines ->
		lines.forEachIndexed { index, line ->
			if (line.length > longestLength) {
				longestLineNumber = index + 1
				longestLength = line.length
			}
		}
	}

	if (longestLineNumber == 0) {
		println("The file is empty.")
	} else {
		println("Line $longestLineNumber is the longest (length = $longestLength)")
	}
}
