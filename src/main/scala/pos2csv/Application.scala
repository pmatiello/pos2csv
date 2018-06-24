package pos2csv

import java.io.{InputStream, OutputStream}

class Application(stdin: InputStream, stdout: OutputStream) {
  def run(): Unit = {
    io.Source.fromInputStream(stdin).getLines().foreach { str =>
      stdout.write(s"$str\n".getBytes)
    }
  }
}

object Application {
  def main(args: Array[String]): Unit = {
    new Application(System.in, System.out).run()
  }
}
