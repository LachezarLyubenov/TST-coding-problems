package problem1

/**
 * Please find sample data in the SampleData object (editing data there will result in different printout here).
 * Also the BestGroupPricesSpec will need to be changed to reflect any changes to sample data made.
 * To run the problem1, open terminal and use the command: 'sbt run'.
 */
object Main extends App {
  // Sample data
  import SampleDataProb1._

  try {
    SampleDataProb1.validate()
  } catch {
    case e: IllegalArgumentException =>
      println(s"Validation failed: ${e.getMessage}")
      Seq() // Send empty sequence
  }

  // Initiating classes
  val rates = new Rates()
  val cabinPriceHelperClass = new CabinPrices()

  // Calculate best group prices in ascending order
  val bestGroupPrices = cabinPriceHelperClass.getBestGroupPrices(prices, rates)

  // Prints out solution
  println("Here are the best rates in ascending order: ")
  bestGroupPrices.foreach(println)
}
