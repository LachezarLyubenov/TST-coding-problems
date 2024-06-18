package problem1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/**
 * Please find sample data in the SampleData object (editing data there will result in different readout here).
 * Please make changes to the problem1.BestGroupPricesSpec and SampleData Object.
 * To run the problem1 test spec, open terminal and use the command: 'sbt test'.
 */
class BestGroupPricesSpec extends AnyFlatSpec with Matchers {
  import problem1.SampleDataProb1._

  "SampleData" should "not contain null values in its sequences" in {
    noException should be thrownBy SampleDataProb1.validate()
  }

  "getBestGroupPrices1" should "give best prices for each cabin+rate group" in {
    val rateHelperClass = new Rates
    val cabinPriceHelperClass = new CabinPrices

    val bestGroupPrices = cabinPriceHelperClass.getBestGroupPrices(prices, rateHelperClass)

    val expected = Seq(
      BestGroupPrice("CA", "M1", 200.00, "Military"),
      BestGroupPrice("CA", "S1", 225.00, "Senior"),
      BestGroupPrice("CB", "M1", 230.00, "Military"),
      BestGroupPrice("CB", "S1", 245.00, "Senior")
    )

    bestGroupPrices shouldEqual expected
  }

  "getBestGroupPrices2" should "handle duplicate prices" in {
    val duplicatePrices = Seq(
      CabinPrice("CA", "M1", 200.00),
      CabinPrice("CA", "M1", 200.00),
      CabinPrice("CA", "S1", 225.00),
      CabinPrice("CB", "M1", 230.00)
    )
    val rateHandler = new Rates
    val cabinPriceHandler = new CabinPrices

    val bestGroupPrices = cabinPriceHandler.getBestGroupPrices(duplicatePrices, rateHandler)

    val expected = Seq(
      BestGroupPrice("CA", "M1", 200.00, "Military"),
      BestGroupPrice("CA", "S1", 225.00, "Senior"),
      BestGroupPrice("CB", "M1", 230.00, "Military")
    )

    bestGroupPrices shouldEqual expected
  }

  "getBestGroupPrices3" should "handle large price values" in {
    val largePrices = Seq(
      CabinPrice("CA", "M1", BigDecimal("9999999999.99")),
      CabinPrice("CA", "S1", 225.00),
      CabinPrice("CB", "M1", BigDecimal("9999999999.99"))
    )
    val rateHandler = new Rates
    val cabinPriceHandler = new CabinPrices

    val bestGroupPrices = cabinPriceHandler.getBestGroupPrices(largePrices, rateHandler)

    val expected = Seq(
      BestGroupPrice("CA", "S1", 225.00, "Senior"),
      BestGroupPrice("CA", "M1", BigDecimal("9999999999.99"), "Military"),
      BestGroupPrice("CB", "M1", BigDecimal("9999999999.99"), "Military")
    )

    bestGroupPrices shouldEqual expected
  }
}