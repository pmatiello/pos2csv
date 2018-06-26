package pos2csv

import java.io.{InputStream, OutputStream}

class IOMap(fn: String => String) {
  def map(in: InputStream, out: OutputStream): Unit =
    io.Source.fromInputStream(in).getLines().foreach { inStr =>
      val outStr = fn(inStr)
      out.write(s"$outStr\n".getBytes)
    }
}
