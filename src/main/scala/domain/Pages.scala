package domain

case class Pages(pages: List[Page]) {
  def getRatings(query: Query): Seq[String] = {
    var ratings: List[(String, Int)] = List()
    pages.foreach(page => {
      ratings = ratings ++ List((page.pageNumber, page.calculateRating(query)))
    })
    ratings.filter { case (_, rating) => rating > 0 }
      .sortWith(_._2 > _._2).map(_._1)

  }
}

