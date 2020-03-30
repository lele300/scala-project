package lectures.part2oop

import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")

  object Person { // TYPE + its only instance
    // "static/class" level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // Factory Method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // instance-level functionality

  }

  // COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val mary = new Person("Mary")
  val john = new Person("John")

  println(mary == john) //true

  val person1 = Person
  val person2 = Person

  val bobbie = Person(mary, john)

  println(bobbie.name)
  println(person1 == person2)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit

}
