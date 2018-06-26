package pos2csv

import java.io.{InputStream, OutputStream}

class Application(stdin: InputStream, stdout: OutputStream) {
  def run(): Unit = new IOMap(identity).map(stdin, stdout)
}

object Application {
  def main(args: Array[String]): Unit = {
    new Application(System.in, System.out).run()
  }
}
