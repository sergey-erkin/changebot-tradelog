package me.saerkin.changebot.tradelog;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;

import static java.nio.file.Files.isHidden;
import static java.nio.file.Files.isRegularFile;

/**
 * Accept only not hidden files
 */
final class AcceptVisibleFileFilter implements DirectoryStream.Filter<Path>
{
  @Override
  public boolean accept(Path path) throws IOException
  {
    return isRegularFile(path) && !isHidden(path);
  }
}
