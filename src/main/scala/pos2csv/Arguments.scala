package pos2csv

class Arguments(args: List[String]) {
  val columnSizes: List[Int] = args.head.split(",").map(_.toInt).toList
}
