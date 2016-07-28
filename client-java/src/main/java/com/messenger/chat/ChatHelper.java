package com.messenger.chat;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 28.07.2016
 * Time: 19:48
 */
public class ChatHelper
{
  public static InetAddress getInetAddress( String host )
  {
    try
    {
      return InetAddress.getByName( host );
    }
    catch( UnknownHostException e )
    {
      throw new RuntimeException( e );
    }
  }
}
