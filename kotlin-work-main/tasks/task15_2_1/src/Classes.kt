// Task 15.2.1: syntax for subclasses

open class Parent

// Child needs the `open` modifier as well, otherwise it is final and cannot
// be inherited from. Without it, adding GrandChild below gives the error
// "This type is final, so it cannot be extended."
open class Child : Parent()

class GrandChild : Child()
