package com.messenger.chat.handlers;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 28.07.2016
 * Time: 19:10
 */
public class ChatMonitor
{
  public static ServerReader handleReader( ServerReader reader )
  {
    new Thread( reader ).start();
    return reader;
  }

  public static ServerWriter handleWriter( ServerWriter writer )
  {
    new Thread( writer ).start();
    return writer;
  }
}
