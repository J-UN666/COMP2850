# Task 3.2

Run the program in the following ways:

    ./kotlin run 19
    ./kotlin run 19.5
    ./kotlin run nineteen
    ./kotlin run 92682

The second and third of these should cause the program to crash.

The first and fourth should run without errors, but the fourth example
should produce an incorrect result. Make sure that you understand
why this is the case!
4.在 Kotlin/Java 里，整数运算溢出时不会报错，而是按 32 位二进制的“循环回绕”方式处理：
 
修正方式:val number = args[0].toLong()
println(number * number)