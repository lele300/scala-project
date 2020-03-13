package lectures.part1basics

object CBNvsCBV extends App {

  // In call-by-value functions, the parameter is evaluated before enter in the function and its used
  // at the whole entire function
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // In a call-by-name function, the parameter is evaluated every time its called.
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  printFirst(infinite(), 34) // This crash, because this is used in the function
  printFirst(34, infinite()) // This prints 34. This will not crash because the second parameter is never used in the function.
}
