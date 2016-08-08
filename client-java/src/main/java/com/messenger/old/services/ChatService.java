package com.messenger.old.services;

import com.messenger.config.ServerConfig;
import com.messenger.old.ChatInstance;
import com.messenger.chat.ChatHelper;
import com.messenger.old.handlers.*;
import com.messenger.entities.user.User;

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

  public static User createUser()
  {
    return new User()
            .setDisplayName( "user" + Math.round( Math.random() * 100 ) )
            .setUserId( UUID.randomUUID().toString() );
  }

  public static ChatInstance startChat( User user, ClientReceiveHandler messageHandler )
  {
    final InetAddress ipAddress = ChatHelper.getInetAddress( ServerConfig.getHost() );
    try
    {
      return new ChatInstance( new Socket( ipAddress, ServerConfig.getPort() ),
                               user,
                               messageHandler );
    }
    catch( IOException e )
    {
      throw new RuntimeException( e );
    }
  }
}
