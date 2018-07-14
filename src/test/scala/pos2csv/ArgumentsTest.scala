package pos2csv

import org.scalatest._

class ArgumentsTest extends FunSpec with Matchers {
  describe("Arguments") {
    it("extracts the column sizes") {
      new Arguments("2,4,8" :: Nil).columnSizes shouldEqual List(2, 4, 8)
    }

    it("throws an exception on invalid column size") {
      a[NumberFormatException] shouldBe thrownBy {
        new Arguments("2,a,8" :: Nil).columnSizes
      }
    }

    it("throws an exception on empty colum size") {
      a[NumberFormatException] shouldBe thrownBy {
        new Arguments("2,,8" :: Nil).columnSizes
      }
    }
  }
}
