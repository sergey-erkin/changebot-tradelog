package me.saerkin.changebot.tradelog;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 */
final class TradeLogFolder
{
  private final Path path;

  TradeLogFolder()
  {
    path = Paths.get("");
  }

  void listAllLogs() throws IOException
  {
    int total = 0;
    try (DirectoryStream<Path> stream = selectFiles()) {
      for (Path child : stream) {
        try {
          new TradeLogFile(child).list();
          total++;
        }
        catch (UnknownFileFormatException e) {
          System.out.println(child + " skipped due it's not a trade log");
        }
      }
    }
    System.out.println(total + " logs listed total");
  }

  private DirectoryStream<Path> selectFiles() throws IOException
  {
    return Files.newDirectoryStream(path, new AcceptVisibleFileFilter());
  }
}
