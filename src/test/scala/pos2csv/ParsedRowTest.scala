package pos2csv

import org.scalatest._

class ParsedRowTest extends FunSpec with Matchers {
  describe("ParsedRow") {
    it("splits line at the given column sizes") {
      val lineRow = new ParsedRow("01xyzABCD", 2 :: 3 :: 4 :: Nil)
      lineRow.cells shouldEqual "01" :: "xyz" :: "ABCD" :: Nil
    }

    it("accepts columns not going through the whole line") {
      val lineRow = new ParsedRow("01xyzABCD", 2 :: 3 :: Nil)
      lineRow.cells shouldEqual "01" :: "xyz" :: Nil
    }

    it("accepts columns finishing after line end") {
      val lineRow = new ParsedRow("01xyzABCD", 2 :: 3 :: 5 :: Nil)
      lineRow.cells shouldEqual "01" :: "xyz" :: "ABCD" :: Nil
    }

    it("ignores columns starting after line end") {
      val lineRow = new ParsedRow("01xyzABCD", 2 :: 3 :: 4 :: 5 :: Nil)
      lineRow.cells shouldEqual "01" :: "xyz" :: "ABCD" :: Nil
    }
  }
}
