package lectures.part2oop

import scala.annotation.tailrec

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.x)
  println(person.greet("Daniel"))
  println(person.greet())


  val author = new Writer("Leonardo", "Lopes", 1996)
  val impostor = new Writer("Leonardo", "Lopes", 1996)
  val novel = new Novel("C# Patterns", 2020, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))

  val counter = new Counter
  counter.increment.print
  counter.increment.increment.increment.print
  counter.increment(10).print
}

// Constructor

// class parameters are NOT FIELDS
// To do it, you need to specify like this -> Person(val name: String, val age: Int)
class Person(name: String, val age: Int = 0) {
  //body
  val x = 2

  println(1 + 3)

  //Method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // Overloading methods
  def greet(): Unit = println(s"Hi, I am $name")

  // Multiple constructor

  // The auxiliary constructor is defined by
  def this(name: String) = this(name, 0)

  def this() = this("John Doe")

  // The implementation of the multiple constructor is only call another constructor
}

/*
  Novel and a Writer
    Writer: first name, surname, year
      -method fullname


    Novel: name, year of release, author
      - method authorAge
      - method isWrittenBy(author)
      - copy (new year of release) = new instance of Novel

 */


/*

  Counter class
    - receives an int value
    - method current count
    - method to increment/ decrement => new Counter
    - overload inc/dec to receive an amount => new Counter
 */

  //1.

  class Writer(val firstname: String, val surname: String, val year: Int) {

    def fullname(): String = s"${firstname + " " + surname}"
  }

  class Novel(val name: String, val yearOfRelease: Int, author: Writer) {

    def authorAge: Int = yearOfRelease - author.year
    def isWrittenBy(author: Writer) = author == this.author
    def copy(newYear: Int): Novel = new Novel(name, newYear, author)
  }


  // 2.
  class Counter(val count: Int = 0) {

    def increment: Counter = {
      println("incrementing")
      new Counter(count + 1)
    } // immutability

    def decrement: Counter = {
      println("decrementing")
      new Counter(count - 1)
    }

    def increment(value: Int): Counter = {
      if (value <= 0) this
      else increment.increment(value - 1)
    }

    def decrement(value: Int): Counter = {
      if (value <= 0) this
      else decrement.decrement(value - 1)
    }

    def print = println(count)
  }
