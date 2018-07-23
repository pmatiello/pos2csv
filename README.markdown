# pos2csv

Command-line utility for converting positional flat files into delimited text.

## Building

Run this command in order to build an universal package for this utility:

```
$ sbt universal:packageBin
```

The package will be built as a zip file located in the `target/universal` directory.

## Running

The pos2csv utility converts a positional flat file (read from stdin) to a CSV file (written to stdout).
The column sizes are passed as comma-separated integer command-line arguments.

```
$ bin/pos2csv column-size1,column-size2,... < input.pos > output.csv
```

Example:

```
$ echo "abc123" | bin/pos2csv 1,2,3
a,bc,123
```

## Developing

This is a regular [Scala](https://www.scala-lang.org) project managed by [sbt](https://www.scala-sbt.org).

```
$ sbt
```

### Running the tests

```
sbt:pos2csv> test
```

### Running the program

```
sbt:pos2csv> run column-size1,column-size2,...
```
