import parser.Builder

import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    /*
      1. First arg should be no of keyword allowed for rating per page
      2. Second arg should be data file path. In the file each line will represent data for per page
      3. Third arg should be query file path. In the file each line will represent data for per query

      Note:- In data file, data should be white space separated. For exmaple look 'src/pagedata.txt' path in this project
      SourceCodeUrl:- https://github.com/vikashupadhyay/webPageOptimizer
    */
    val totalNumberOfKeywordAllowed = args.headOption.get.toInt

    def readFile(pageFilePath: String) = {
      var pages: List[String] = List.empty
      for (line <- Source.fromFile(pageFilePath).getLines) {
        pages = pages ++ List(line)
      }
      pages
    }

    val pages = Builder.buildPages(totalNumberOfKeywordAllowed, readFile(args(1)))

    val queries = Builder.buildQuery(totalNumberOfKeywordAllowed, readFile(args(2)))

    queries.foreach(query => {
      println(pages.getRatings(query))
    })
  }
}
