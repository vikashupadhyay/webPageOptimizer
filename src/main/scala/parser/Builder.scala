package parser

import domain.{Keyword, Page, Pages, Query}

object Builder {
  def buildPages(allowedKeywords: Int, pagesStr: List[String]): Pages = {
    var pageNumber = 1
    var pagesList: List[Page] = List.empty
    pagesStr.foreach((page) => {
      val keywords = buildKeywords(page, allowedKeywords)
      pagesList = pagesList ++ List(Page("P" + pageNumber, keywords))
      pageNumber = pageNumber + 1
    })
    Pages(pagesList)
  }

  def buildKeywords(page: String, allowedKeywords: Int): List[Keyword] = {
    var keywords: List[Keyword] = List.empty
    var counter = 0
    page.split(" ").foreach((word) => {
      keywords = keywords ++ List(Keyword(word, allowedKeywords - counter))
      counter = counter + 1
    })
    keywords
  }

  def buildQuery(allowedKeywords: Int, queriesStr: List[String]): List[Query] = {
    var pageNumber = 1
    var queries: List[Query] = List.empty
    queriesStr.foreach((page) => {
      val keywords = buildKeywords(page, allowedKeywords)
      queries = queries ++ List(Query(keywords))
      pageNumber = pageNumber + 1
    })
    queries
  }

}
