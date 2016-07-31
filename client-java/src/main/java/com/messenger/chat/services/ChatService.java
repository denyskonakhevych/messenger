package com.messenger.chat.services;

import com.messenger.chat.Chat;
import com.messenger.chat.ChatHelper;
import com.messenger.chat.handlers.*;
import com.messenger.entities.Sender;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 28.07.2016
 * Time: 19:04
 */
public class ChatService
{
  private static final String SERVER_HOST = "127.0.0.1";
  private static final int SERVER_PORT = 6666;

  public static Sender createUser()
  {
    return new Sender()
            .setNickName( "user" + Math.round( Math.random() * 100 ) )
            .setUuid( UUID.randomUUID().toString() );
  }

  public static Chat startChat( Sender user, ClientReceiveHandler messageHandler )
  {
    final InetAddress ipAddress = ChatHelper.getInetAddress( SERVER_HOST );
    try
    {
      final Socket socket = new Socket( ipAddress, SERVER_PORT );
      return new Chat( socket, user, messageHandler );
    }
    catch( IOException e )
    {
      throw new RuntimeException( e );
    }
  }
}
