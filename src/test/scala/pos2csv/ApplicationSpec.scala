package pos2csv

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

import org.scalatest._

class ApplicationSpec extends FunSpec with Matchers {
  describe("ApplicationSpec") {
    it("copies stdin to stdout") {
      val stdin = new ByteArrayInputStream("abc001\ndef002\n".getBytes)
      val stdout = new ByteArrayOutputStream

      new Application(stdin, stdout).run()

      stdout.toString shouldEqual "abc001\ndef002\n"
    }
  }
}
