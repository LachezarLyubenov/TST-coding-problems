package problem1


//case classes provided in the problem pdf
case class CabinPrice(cabinCode: String, rateCode: String, price: BigDecimal)
case class BestGroupPrice(cabinCode: String, rateCode: String, price: BigDecimal, rateGroup: String)

/**
 * problem1.CabinPrices class that holds the getBestGroupPrices method that does the bulk of the data manipulation
 * and returns a sequence of problem1.BestGroupPrice (sorted by lowest price)
 *
 * Note: Excluded print/logger statements. Those can, should, and need to be added to any code that might warrant debugging in any
 * of the available environments (test/dev/prod). Having good loggers is very helpful for anyone maintaining the code base.
 * @param prices
 * @param rateHandler
 */
class CabinPrices {

  def getBestGroupPrices(prices: Seq[CabinPrice], rates: Rates): Seq[BestGroupPrice] = {
    prices
      .groupBy(cabinPrice => (cabinPrice.cabinCode, rates.getRateGroup(cabinPrice.rateCode)))
      .flatMap {
        case ((cabinCode, Some(rateGroup)), cabinPrices) =>
          cabinPrices.minByOption(_.price).map { bestPrice =>
            BestGroupPrice(bestPrice.cabinCode, bestPrice.rateCode, bestPrice.price, rateGroup)
          }
        case _ => None // Handle cases where rate group is None
      }
      .toSeq
      .sortBy(_.price) // Sorting by price in ascending order
  }
}