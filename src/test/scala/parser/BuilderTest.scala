package parser

import domain.{Keyword, Page, Query, Pages => KPages}
import org.scalatest.{FunSuite, Matchers}


class BuilderTest extends FunSuite with Matchers {
  test("buildPages should build page based on keyword rating") {
    val pages = List("Ford Car Review", "Review Car", "Review Ford", "Toyota Car", "Honda Car", "Car")
    val actualsPages = Builder.buildPages(allowedKeywords = 8, pages)

    val P1 = Page("P1", List(Keyword("Ford", 8), Keyword("Car", 7), Keyword("Review", 6)))
    val P2 = Page("P2", List(Keyword("Review", 8), Keyword("Car", 7)))
    val P3 = Page("P3", List(Keyword("Review", 8), Keyword("Ford", 7)))
    val P4 = Page("P4", List(Keyword("Toyota", 8), Keyword("Car", 7)))
    val P5 = Page("P5", List(Keyword("Honda", 8), Keyword("Car", 7)))
    val P6 = Page("P6", List(Keyword("Car", 8)))

    val expectedPages = KPages(List(P1, P2, P3, P4, P5, P6))

    actualsPages shouldBe expectedPages
  }

  test("buildQueries should build query based on keyword rating") {

    val queries = List("Ford", "Car", "Review", "Ford Review", "Ford Car", "Cooking French")

    val Q1 = Query(List(Keyword("Ford", 8)))
    val Q2 = Query(List(Keyword("Car", 8)))
    val Q3 = Query(List(Keyword("Review", 8)))
    val Q4 = Query(List(Keyword("Ford", 8), Keyword("Review", 7)))
    val Q5 = Query(List(Keyword("Ford", 8), Keyword("Car", 7)))
    val Q6 = Query(List(Keyword("Cooking", 8), Keyword("French", 7)))

    val expectedQueries = List(Q1, Q2, Q3, Q4, Q5, Q6)
    Builder.buildQuery(allowedKeywords = 8, queries) shouldBe expectedQueries
  }
}
