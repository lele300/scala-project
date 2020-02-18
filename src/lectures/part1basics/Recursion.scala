package lectures.part1basics

object Recursion extends App {
  def factorial(n: Int): BigInt = {

     def factorialTailRecursive(number: Int, accumulator: BigInt): BigInt = {
       println("WITH TALE RECURSION")
      if(number == 1) accumulator
      else factorialTailRecursive(number - 1, number * accumulator)
    }

    def factorialRecursive(number: Int): Int = {
      println("WITHOUT TALE RECURSION")
      if(number == 1) 1
      else number * factorialRecursive(number - 1)
    }

    factorialTailRecursive(n, 1)
//    factorialRecursive(n)
  }

  println(factorial(5))
}
