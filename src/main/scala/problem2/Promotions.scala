package problem2

case class Promotion(code: String, notCombinableWith: Seq[String])
case class PromotionCombo(promotionCodes: Seq[String])

/**
 * problem2.Promotions class that holds the allCombinablePromotions and combinablePromotions method
 * allCombinablePromotions -> method that makes a Set of all promo codes, folds it to generate combinations, and then converts it back to sequence of combo promos.
 * combinablePromotions -> method that takes allCombinablePromotions's return sequence and further filters based on a defined promotionCode.
 * Note: Excluded print/logger statements. Those can, should, and need to be added to any code that might warrant debugging in any
 * of the available environments (test/dev/prod). Having good loggers is very helpful for anyone maintaining the code base.
 */
class Promotions {

  // main method to combine all promos into a sequence of promotional combos
  def allCombinablePromotions(allPromotions: Seq[Promotion]): Seq[PromotionCombo] = {
    // Start with the set of all promotion codes
    val initialSet: Set[String] = allPromotions.map(_.code).toSet
    val initialCombinations: Seq[Set[String]] = Seq(initialSet)

    // Fold over all promotions to generate combinations
    val allCombinations: Seq[Set[String]] = allPromotions.foldLeft(initialCombinations) { (combinations, promo) =>
      combinations.flatMap(combination => generateNewCombinations(combination, promo))
    }

    // Convert sets back to PromotionCombo objects with sorted promotion codes and filter out subsets
    val uniqueCombinations = allCombinations.distinct
    val filteredCombinations: Seq[Set[String]] = uniqueCombinations.filterNot(set => uniqueCombinations.exists(otherSet => otherSet.size > set.size && set.subsetOf(otherSet)))

    // Returns a sorted sequence of all promo combos
    val finalSequencePromos: Seq[PromotionCombo] = filteredCombinations.map(combo => PromotionCombo(combo.toSeq.sorted))
    finalSequencePromos
  }

  // Function to generate new combinations excluding incompatible promotions
  private def generateNewCombinations(existingCombination: Set[String], promo: Promotion): Seq[Set[String]] = {
    if (existingCombination.contains(promo.code)) {
      // Remove exclusions based on notCombinableWith
      val combinationWithoutExclusions = existingCombination -- promo.notCombinableWith.toSet
      // Create a new set excluding the current promotion code if exclusions are removed
      val combinationWithoutPromo = if (combinationWithoutExclusions.size < existingCombination.size) existingCombination - promo.code else Set.empty[String]
      // Filter and retain sets with more than one element
      Seq(combinationWithoutExclusions, combinationWithoutPromo).filter(_.size > 1)
    } else {
      Seq(existingCombination)
    }
  }

  // Function that takes sequence returned by allCombinablePromotions and further filters it based on provided promotionCode.
  def combinablePromotions(promotionCode: String, allPromotions: Seq[Promotion]): Seq[PromotionCombo] = {

    val data: Seq[PromotionCombo] = allCombinablePromotions(allPromotions)
    data.filter(x => x.promotionCodes.contains(promotionCode))
  }
}
