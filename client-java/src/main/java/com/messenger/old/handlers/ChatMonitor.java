package com.messenger.old.handlers;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 28.07.2016
 * Time: 19:10
 */
public class ChatMonitor
{
  public static ChatServerReader handleReader( ChatServerReader reader )
  {
    new Thread( reader ).start();
    return reader;
  }

  public static ChatServerWriter handleWriter( ChatServerWriter writer )
  {
    new Thread( writer ).start();
    return writer;
  }
}
