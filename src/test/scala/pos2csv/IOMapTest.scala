package pos2csv

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

import org.scalatest._

class IOMapTest extends FunSpec with Matchers {
  describe("IOMap") {
    it("applies the given function to each line in stdin and writes the result to stdout") {
      val fn = (str: String) => s"fn($str)"
      val in = new ByteArrayInputStream("abc001\ndef002\n".getBytes)
      val out = new ByteArrayOutputStream

      new IOMap(fn).map(in, out)

      out.toString shouldEqual "fn(abc001)\nfn(def002)\n"
    }
  }
}
