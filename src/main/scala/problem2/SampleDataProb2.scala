package problem2

/**
 * Object that holds the test data provided with the problem.
 * If additional test data is needed or extra test cases, make the changes here.
 */
object SampleDataProb2 {
  val inputPromotions: Seq[Promotion] = Seq(
    Promotion("P1", Seq("P3")),
    Promotion("P2", Seq("P4", "P5")),
    Promotion("P3", Seq("P1")),
    Promotion("P4", Seq("P2")),
    Promotion("P5", Seq("P2"))
  )

  //Simple validation method to check
  def validate(): Unit = {
    if (inputPromotions == null) throw new IllegalArgumentException("promotion sequence is null")
    if (inputPromotions.isEmpty) throw new IllegalArgumentException("promotion sequence is empty")
    if (inputPromotions.contains(null)) throw new IllegalArgumentException("promotion sequence contains null element")
  }
}