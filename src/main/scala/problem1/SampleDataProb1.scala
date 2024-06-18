package problem1

/**
 * Object that holds the test data provided with the problem.
 * If additional test data is needed or extra test cases, make the changes here.
 */
object SampleDataProb1 {

  val rates: Seq[Rate] = Seq(
      Rate("M1", "Military"),
      Rate("M2", "Military"),
      Rate("S1", "Senior"),
      Rate("S2", "Senior")
    )

  val prices: Seq[CabinPrice] = Seq(
    CabinPrice("CA", "M1", 200.00),
    CabinPrice("CA", "M2", 250.00),
    CabinPrice("CA", "S1", 225.00),
    CabinPrice("CA", "S2", 260.00),
    CabinPrice("CB", "M1", 230.00),
    CabinPrice("CB", "M2", 260.00),
    CabinPrice("CB", "S1", 245.00),
    CabinPrice("CB", "S2", 270.00)
  )

  def validate(): Unit = {
    if (rates == null) throw new IllegalArgumentException("Rates sequence is null")
    if (prices == null) throw new IllegalArgumentException("Prices sequence is null")
    if (rates.contains(null)) throw new IllegalArgumentException("Rates sequence contains null element")
    if (prices.contains(null)) throw new IllegalArgumentException("Prices sequence contains null element")
  }
}
