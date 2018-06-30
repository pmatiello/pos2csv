package pos2csv

class ParsedRow(line: String, columnSizes: List[Int]) {
  val cells: List[String] = columnSizes.foldLeft((List[String](), line)) {
    case ((parts, str), index) =>
      val (h, t) = str.splitAt(index)
      (parts :+ h, t)
  }._1.filterNot(_.isEmpty)
}
