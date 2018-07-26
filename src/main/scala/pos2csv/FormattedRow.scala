package pos2csv

import pos2csv.FormattedRow.Quote

object FormattedRow {
  private val Quote = "\""
}

class FormattedRow(cells: List[String], separator: String) {
  private def quoted(str: String): String =
    if (str.contains(separator) || str.contains(Quote)) s"$Quote$str$Quote"
    else str

  private def escaped(str: String): String =
    str.replaceAll(Quote, s"$Quote$Quote")

  override def toString: String =
    cells.map(escaped).map(quoted).mkString(separator)
}
