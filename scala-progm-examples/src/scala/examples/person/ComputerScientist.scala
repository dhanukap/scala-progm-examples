package scala.examples.person

class ComputerScientist (
  firstName: String,
  lastName: String,
  age: Int,
  val speciality: String,
  favoriteProgrammingLanguage: String
) extends Person(firstName, lastName, age, "computer scientist") with Worker {

  def workGreeting =
    "As a " + occupation + ", I work on " + speciality + ". Much of my code is written in " + favoriteProgrammingLanguage + "."

}