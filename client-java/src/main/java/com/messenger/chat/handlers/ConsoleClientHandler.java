package com.messenger.chat.handlers;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 28.07.2016
 * Time: 20:00
 */
public class ConsoleClientHandler implements ClientReceiveHandler
{
  @Override
  public void handleMessage( String message)
  {
    System.out.println( message );
  }
}
