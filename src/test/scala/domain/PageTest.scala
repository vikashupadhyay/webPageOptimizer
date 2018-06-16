package domain

import org.scalatest.{FunSuite, Matchers}

class PageTest extends FunSuite with Matchers {

  test("calculateRating should calculate rating of a page") {
    val page = Page("P1", List(Keyword("Ford", 8), Keyword("Car", 7), Keyword("Review", 6)))
    val query = Query(List(Keyword("Ford", 8), Keyword("Car", 7)))
    page.calculateRating(query) shouldBe 113
  }

}
