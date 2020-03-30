package lectures.part2oop

object Generics extends App {

  // Generic class
  // Covariant List
  class MyList[+A] {
    def add[B >: A](element: B): MyList[B] = ???
    /*
        A = Cat
        B = Dog = Animal
        This will return a list of Animals. This means that if I have a list of Cats, and I add a another subclass (Dog) which differs to Cat
        I will return a list of my superclass(animal)
     */
  }

  class MyMap[Key, Value]
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // Generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Questions
  // 1. If Cat extends Animal, does a list of Animals extends a list of Cats?
  // Answer: Yes, a List[Cat] extends List[Animal] = COVARIANCE
  // Notice that you can put a subclass in a covariant type. That means you can put everything extends the superclass as a generic type.
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // 2. Can I add a Dog in animalList? animalList.add(new Dog) ??? HARD QUESTION => we return a list of Animals
  // Answer: No. List of Cats and List of Animals are two separate things = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  // I do not understand it. I need to revise.
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  // This means that class Cage only accepts type parameters A which are subtypes of Animal.
  // BOUNDED TYPE solves a variance problem when we want to write covariant collections
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  // The code below will not run, because a car is not a subtype of an Animal
  class Car
  //generic type needs proper bounded type
  // val newCage = new Cage(new Car)


}
