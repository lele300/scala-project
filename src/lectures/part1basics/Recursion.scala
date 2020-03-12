package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): BigInt = {
    if(n <= 1) 1
    else
      {
        println("Computing factorial of " + n + " I first need factorial of " + (n-1))
        val result = n * factorial(n - 1)

        println("Computed factorial of " + n)
        result
      }
  }

  println(factorial(10))
  //println(factorial(5000))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accummulator: BigInt): BigInt =
      if (x <= 1) accummulator
      else factorialHelper(x - 1, x * accummulator) // TAIL RECURSION = Use recursive call as the LAST expression

    factorialHelper(n, 1)
  }

  println(anotherFactorial(10))
  /*
  anotherFactorial(10) = factorialHelper(10, 1)
  = factorialHelper(9, 10 * 1)
  = factorialHelper(8, 9 * 10 * 1)
  = factorialHelper(7, 8 * 9 * 10 * 1)
  = ...
  = factorialHelper(2, 3 * 4 * ... * 10 * 1)
  = factorialHelper(1, 1 * 2 * 3 * 4 * ... * 10 * 1)
  = 1 * 2 * 3 * 4 * ... * 10
 */

  // WHEN YOU NEED LOOPS, USE _TAIL_RECURSION.

  /*
    1.  Concatenate a string N time using tail recursion
    2.  IsPrime function tail recursion
    3.  Fibonacci function tail recursion
   */

  //1.
  @tailrec
  def concatenateString(string: String, times: Int, accumulator: String): String = {
    if (times <= 0) accumulator
    else concatenateString(string, times - 1, accumulator + " " + string)
  }

  println(concatenateString(string = "Hello", times = 3, ""))

  //2.
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  //3.
  def fibonacci(n: Int): Int = {
    // i = the number that i want to compute
    // last = f(n-1) accummulator
    // nextToLast = f(n-2) accummulator
    // Hint: many recursive calls you have on the same code path, that how many accumulators you need to have in the tail recursive function
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

      if (n <= 2) 1
      else fiboTailrec(2, 1, 1)

  }


  /*
    fibonacci(8)AS
   */
  println(fibonacci(8)) // 1 1 2 3 5 8 13 21
}


