package me.saerkin.changebot.tradelog;

import java.nio.file.Path;

import static java.util.Objects.requireNonNull;

/**
 *
 */
final class TradeLogFile
{
  private final Path path;

  TradeLogFile(Path path)
  {
    this.path = requireNonNull(path);
  }

  void list() throws UnknownFileFormatException
  {
    if (!path.toString().endsWith(".csv"))
      throw new UnknownFileFormatException();

    System.out.println(path + " listed");
  }
}
