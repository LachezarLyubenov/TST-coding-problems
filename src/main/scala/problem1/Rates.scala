package problem1


case class Rate(rateCode: String, rateGroup: String)


/**
 * Class that deals with rates and their translation to groups.
 * Holds getRateGroup method that returns the rateGroup based on a rateCode.
 */
class Rates {
  import SampleDataProb1._

  private val rateCodeToGroup: Map[String, String] = rates.map { rate => rate.rateCode -> rate.rateGroup}.toMap

  def getRateGroup(rateCode: String): Option[String] = rateCodeToGroup.get(rateCode)
}