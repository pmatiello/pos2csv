package pos2csv

import org.scalatest.{FunSpec, Matchers}

class FormattedRowTest extends FunSpec with Matchers {
  describe("FormattedRow") {
    it("outputs row as string with separated columns") {
      new FormattedRow("first" :: "second" :: "third" :: Nil, ",")
        .toString shouldEqual "first,second,third"
    }

    it("supports different separators") {
      new FormattedRow("first" :: "second" :: "third" :: Nil, ";")
        .toString shouldEqual "first;second;third"
    }

    it("wraps cells with the separator character in double quotes") {
      new FormattedRow("1,2" :: "x" :: Nil, ",")
        .toString shouldEqual "\"1,2\",x"
    }

    it("escapes the double-quote character") {
      new FormattedRow("x\"y" :: "z" :: Nil, ",")
        .toString shouldEqual "\"x\"\"y\",z"
    }
  }
}
