package com.messenger.chat.services;

import com.messenger.chat.Chat;
import com.messenger.chat.handlers.ChatMonitor;
import com.messenger.chat.handlers.ClientReceiveHandler;
import com.messenger.chat.handlers.ConsoleClientHandler;
import com.messenger.entities.Sender;

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
    return ChatMonitor.handleChat( new Chat( SERVER_HOST, SERVER_PORT, user, messageHandler ) );
  }
}
