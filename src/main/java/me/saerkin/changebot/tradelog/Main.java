package me.saerkin.changebot.tradelog;

import java.io.IOException;

/**
 *
 */
public final class Main
{
  public static void main(String[] args) throws IOException
  {
    new TradeLogFolder()
      .listAllLogs();
  }
}
