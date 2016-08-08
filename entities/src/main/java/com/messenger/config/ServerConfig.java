package com.messenger.config;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 08.08.2016
 * Time: 19:58
 */
public class ServerConfig
{
  private static final int PORT = 6666;
  private static final String SERVER_HOST = "127.0.0.1";

  public static String getHost()
  {
    return SERVER_HOST;
  }

  public static int getPort()
  {
    return PORT;
  }
}
