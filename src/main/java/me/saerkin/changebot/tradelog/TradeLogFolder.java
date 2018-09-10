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
    // get current directory
    path = Paths.get("");
  }

  void listAllLogs() throws IOException
  {
    int total = 0;
    try (DirectoryStream<Path> stream = selectVisibleFiles()) {
      for (Path child : stream) {
        try {
          new TradeLogFile(child).list();
          total++;
        }
        catch (UnknownFileFormatException e) {
          System.out.println(child + " skipped due it's not a trade log: " + e.getMessage());
        }
      }
    }
    System.out.println(total + " logs listed total");
  }

  private DirectoryStream<Path> selectVisibleFiles() throws IOException
  {
    return Files.newDirectoryStream(path, new AcceptOnlyVisibleFilesFilter());
  }
}
