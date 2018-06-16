package domain

case class Query(query: List[Keyword]) {
  def getValue(key: String): Int = {
    val keyword = query.find((keyword) => keyword.name == key)
    keyword match {
      case None => 0
      case _ => if (keyword.get.name == key) {
        keyword.get.rating
      } else {
        0
      }
    }
  }
}