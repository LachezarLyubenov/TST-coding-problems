package problem2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/**
 * Please find sample data in the SampleData object (editing data there will result in different readout here).
 * Please make changes to the problem1.BestGroupPricesSpec and SampleData Object.
 * To run the problem2 test spec, open terminal and use the command: 'sbt test'.
 */
class PromotionsSpec extends AnyFlatSpec with Matchers {
  import problem2.SampleDataProb2._

  "SampleDataProb2" should "not contain null values in its sequence" in {
    noException should be thrownBy SampleDataProb2.validate()
  }

  "allCombinablePromotions1" should "give all combinable promotions" in {
    val promotions = new Promotions()
    val allCombos = promotions.allCombinablePromotions(inputPromotions)

    val expected = Seq(
      PromotionCombo(Seq("P1", "P2")),
      PromotionCombo(Seq("P1", "P4", "P5")),
      PromotionCombo(Seq("P2", "P3")),
      PromotionCombo(Seq("P3", "P4", "P5"))
    )

    allCombos shouldEqual expected
  }

  "allCombinablePromotions2" should "handle the case with no conflicts" in {
    val promotions = new Promotions()
    val inputPromotions = Seq(
      Promotion("P1", Seq()),
      Promotion("P2", Seq()),
      Promotion("P3", Seq()),
      Promotion("P4", Seq()),
      Promotion("P5", Seq())
    )

    val result = promotions.allCombinablePromotions(inputPromotions)

    val expected = Seq(
      PromotionCombo(Seq("P1", "P2", "P3", "P4", "P5"))
    )

    result.map(_.promotionCodes) shouldEqual expected.map(_.promotionCodes)
  }

  "combinablePromotions3" should "handle promotions with one that excludes all other promotions" in {
    val promotions = new Promotions()
    val inputPromotions = Seq(
      Promotion("P1", Seq("P2", "P3", "P4", "P5")),
      Promotion("P5", Seq("P1", "P2"))
    )

    val expectedCombosForAll = Seq.empty[PromotionCombo]

    val result = promotions.combinablePromotions("P1", inputPromotions)

    result.map(_.promotionCodes) shouldEqual expectedCombosForAll.map(_.promotionCodes)
  }

}