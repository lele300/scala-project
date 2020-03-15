package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2)) // Returns the character at the index passed by parameter
  println(str.substring(7, 11)) // Returns a string that includes the character at the 7 index and excludes the character of the 11 index
  println(str.split(" ").toList) // Returns an array with the elements separated by the delimiter.
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-")) // Replaces all white spaces with -
  println(str.toLowerCase()) // Turns all the string characters into lower case
  println(str.toUpperCase()) // Turns all the string characters into UPPER CASE
  println(str.length) // Returns the length of the string

  val aNumberString = "45"
  val aNumber = aNumberString.toInt // Parse a string int into a Int
  println('a' +: aNumberString :+ 'z') // Prepend a value in the string | Append a value in the string
  println(str.reverse) // Reverts the whole string and the characters
  println(str.take(2)) // Take the two first characters

  // Scala-specific: String interpolators.

  // S-interpolators

  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old."
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old."
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burguers per minute"
  println(myth)

  // raw interpolator
  println(raw"This is a \n newline") // This evaluates the \n literally
  val escaped = "This is a \n newline"
  println(raw"$escaped") // When use the raw interpolator, that will not be escaped.

}
