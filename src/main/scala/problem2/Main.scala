package problem2

object Main extends App {
  // Sample data
  import SampleDataProb2._

  try {
    SampleDataProb2.validate()
  } catch {
    case e: IllegalArgumentException =>
      println(s"Validation failed: ${e.getMessage}")
      Seq() // Send empty sequence since there is issue.
  }

  val promotionHelper = new Promotions()

  //All combinable promotions output below
  val allCombos = promotionHelper.allCombinablePromotions(inputPromotions)
  println("Expected Output for All Promotion Combinations: ")
  allCombos.foreach(println)

  //All combinable promotions output for P1 below
  val combosP1 = promotionHelper.combinablePromotions("P1", inputPromotions)
  println("\nExpected Output for Promotion Combinations for promotionCode = P1: ")
  combosP1.foreach(println)

  //All combinable promotions output for P2 below
  val combosP3 = promotionHelper.combinablePromotions("P3", inputPromotions)
  println("\nExpected Output for Promotion Combinations for promotionCode = P3: ")
  combosP3.foreach(println)
}
