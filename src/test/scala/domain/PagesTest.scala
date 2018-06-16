package domain

import org.scalatest.{FunSuite, Matchers}

class PagesTest extends FunSuite with Matchers {

  test("getRatings should return page rating") {
    val p1 = Page("P1", List(Keyword("Ford", 8), Keyword("Car", 7), Keyword("Review", 6)))
    val p2 = Page("P2", List(Keyword("Review", 8), Keyword("Car", 7)))
    val p3 = Page("P3", List(Keyword("Review", 8), Keyword("Ford", 7)))
    val p4 = Page("P4", List(Keyword("Toyota", 8), Keyword("Car", 7)))
    val p5 = Page("P5", List(Keyword("Honda", 8), Keyword("Car", 7)))
    val p6 = Page("P6", List(Keyword("Car", 8)))

    val q1 = Query(List(Keyword("Ford", 8)))
    val q2 = Query(List(Keyword("Car", 8)))
    val q3 = Query(List(Keyword("Review", 8)))
    val q4 = Query(List(Keyword("Ford", 8), Keyword("Review", 7)))
    val q5 = Query(List(Keyword("Ford", 8), Keyword("Car", 7)))
    val q6 = Query(List(Keyword("Cooking", 8), Keyword("French", 7)))
    val pages = Pages(List(p1, p2, p3, p4, p5, p6))

    pages.getRatings(q1) shouldBe List("P1", "P3")
    pages.getRatings(q2) shouldBe List("P6", "P1", "P2", "P4", "P5")
    pages.getRatings(q3) shouldBe List("P2", "P3", "P1")
    pages.getRatings(q4) shouldBe List("P3", "P1", "P2")
    pages.getRatings(q5) shouldBe List("P1", "P3", "P6", "P2", "P4", "P5")
    pages.getRatings(q6) shouldBe List()
  }

}
