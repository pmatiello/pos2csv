package pos2csv

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

import org.scalatest._

class ApplicationSpec extends FunSpec with Matchers {
  describe("Application") {
    it("copies stdin to stdout") {
      val stdin = new ByteArrayInputStream("abc001\ndef002\n".getBytes)
      val stdout = new ByteArrayOutputStream
      val arguments = "1,2,3" :: Nil

      new Application(stdin, stdout, arguments).run()

      stdout.toString shouldEqual "a,bc,001\nd,ef,002\n"
    }
  }
}
