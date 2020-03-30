package lectures.part2oop

import lectures.part2oop.Inheritance.Animal

object Inheritance extends App {

  // single class inheritance
   sealed class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }

    override def eat = super.eat // This will call the superclass method
  }

  val cat = new Cat
  cat.crunch
  cat.eat

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  // You can override a super class attribute in the subclass by subclass's constructor
  class Dog(override val creatureType: String) extends Animal {
    override def eat = println("crunch, crunch")
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polimorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - seal the class = extend classes in THIS FILE, prevent extension in other files

}
