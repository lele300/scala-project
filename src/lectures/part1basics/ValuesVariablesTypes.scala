package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 42
  println(x)

  // VALS ARE IMMUTABLE

  // COMPILER CAN INFER TYPES

  val aString: String = "Hello"
  val anotherString = "Hello "

  val aBoolean: Boolean = false
  val aChar: Char = 'A'
  val anInt: Int = x
  val aShort: Short = 1238
  val aLong: Long = 3290909322L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // VARIABLES
  var aVariable = 4
  aVariable = 10 // SIDE EFFECTS
}
