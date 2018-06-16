package domain

case class Page(pageNumber: String, keywords: List[Keyword]) {

  def calculateRating(query: Query): Int = {
    var rating = 0
    for ((keyword) <- keywords) {
      rating += keyword.rating * query.getValue(keyword.name)
    }
    rating
  }
}
