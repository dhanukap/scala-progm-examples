object Ex1 extends Application {
  def ex1() = {
    val greetStrings = new Array[String](3)
    greetStrings(0) = "Hello 1"
    greetStrings(1) = ", "
    greetStrings(2) = "world!\n"
    for (i <- 0 to 2)
      print(greetStrings(i))
  }

  //Use lists
  def ex2 = {
    val oneTwo = List(1, 2)
    val threeFour = List(3, 4)
    val oneTwoThreeFour = oneTwo ::: threeFour
    println("" + oneTwo + " and " + threeFour + " were not mutated.")
    println("Thus, " + oneTwoThreeFour + " is a new list.")
  }

  //Use tuples
  def ex3 = {
    val pair = (99, "Luftballons")
    println(pair._1)
    println(pair._2)
  }

  //Use sets and maps
  def ex4_1 = {
    var jetSet = Set("Boeing", "Airbus")
    jetSet += "Lear"
    println(jetSet.contains("Cessna"))
    jetSet = jetSet + "Lear"
  }

  def ex4_2 = {
    import scala.collection.mutable.Set

    val movieSet = Set("Hitch", "Poltergeist")
    movieSet += "Shrek"
    println(movieSet)
  }

  def ex4_3 = {
    import scala.collection.immutable.HashSet

    val hashSet = HashSet("Tomatoes", "Chilies")
    println(hashSet + "Coriander")
  }

  def ex4_4 = {
    import scala.collection.mutable.Map

    val treasureMap = Map[Int, String]()
    treasureMap += (1 -> "Go to island.")
    treasureMap += (2 -> "Find big X on ground.")
    treasureMap += (3 -> "Dig.")
    println(treasureMap(2))
  }

  //Read lines from a file
  //Ex1.ex5_1(Array("test-1.txt"))
  def ex5_1(args: Array[String]) = {
    import scala.io.Source

    def widthOfLength(s: String) = s.length.toString.length

    if (args.length > 0) {

      val lines = Source.fromFile(args(0)).getLines.toList

      val longestLine = lines.reduceLeft(
        (a, b) => if (a.length > b.length) a else b)
      val maxWidth = widthOfLength(longestLine)

      for (line <- lines) {
        val numSpaces = maxWidth - widthOfLength(line)
        val padding = " " * numSpaces
        println(padding + line.length + " | " + line)
      }
    } else
      Console.err.println("Please enter filename")

  }
}
