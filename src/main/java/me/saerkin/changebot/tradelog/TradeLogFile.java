package me.saerkin.changebot.tradelog;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.util.Objects.requireNonNull;

/**
 * todo: rename to TradeLogCSV
 */
final class TradeLogFile
{
  private final Path path;

  private final CSVFormat format;

  TradeLogFile(Path path)
  {
    this.path = requireNonNull(path);
    this.format = CSVFormat.DEFAULT.withRecordSeparator("\n");
  }

  void list() throws IOException, UnknownFileFormatException
  {
    try (Reader reader = Files.newBufferedReader(path)) {
      try (CSVParser parser = new CSVParser(reader, format)) {
        for (CSVRecord ignored : parser) {
          break;
        }
      }
    }
    catch (IllegalStateException e) {
      throw new UnknownFileFormatException("Not a csv format", e);
    }

    System.out.println(path + " listed");
  }
}
