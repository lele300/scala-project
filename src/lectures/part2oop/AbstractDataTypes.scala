package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract
  // abstract classes cannot be instantiated
  // abstract classes forces the subclasses to implement a value
  abstract class Animal {
    val creatureType: String = "wild"// abstract attribute
    def eat: Unit // abstract method
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"
    override def eat: Unit = "nomnomnom"
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val crocodile = new Crocodile
  crocodile.eat(dog)

  // traits vs abstract classes
  // 1 - Traits do not have constructor parameters
  // 2 - Multiple traits may be inherited by the same class
  // 3 - Traits = behavior, abstract class = "thing"
}
