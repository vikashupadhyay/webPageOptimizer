package domain

import org.scalatest.{FunSuite, Matchers}

class QueryTest extends FunSuite with Matchers {

  test("getValue should rating rating of given keyword") {
    val query = Query(List(Keyword("Ford", 8), Keyword("Car", 7)))
    query.getValue("Ford") shouldBe 8
    query.getValue("Car") shouldBe 7
    query.getValue("Bike") shouldBe 0
  }

}
