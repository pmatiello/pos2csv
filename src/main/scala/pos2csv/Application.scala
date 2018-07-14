package pos2csv

import java.io.{InputStream, OutputStream}

class Application
(stdin: InputStream, stdout: OutputStream, arguments: List[String]) {
  private val columSizes = new Arguments(arguments).columnSizes

  private def mapFn(line: String) =
    new ParsedRow(line, columSizes).cells.mkString(",")

  def run(): Unit = new IOMap(mapFn).map(stdin, stdout)
}

object Application {
  def main(args: Array[String]): Unit =
    new Application(System.in, System.out, args.toList).run()
}
