package com.messenger.old;

import com.messenger.old.handlers.ChatMonitor;
import com.messenger.old.handlers.ClientReceiveHandler;
import com.messenger.old.handlers.ChatServerReader;
import com.messenger.old.handlers.ChatServerWriter;
import com.messenger.entities.Action;
import com.messenger.entities.user.User;

import java.io.IOException;
import java.net.Socket;

public class ChatInstance implements AutoCloseable
{
  private final User user;
  private final Socket socket;

  private ChatServerReader reader;
  private ChatServerWriter writer;

  private ClientReceiveHandler messageHandler;

  public ChatInstance( final Socket socket, User user, ClientReceiveHandler messageHandler )
  {
    try
    {
      this.socket = socket;
      reader = ChatMonitor.handleReader( new ChatServerReader( this, socket.getInputStream() ) );
      writer = ChatMonitor.handleWriter( new ChatServerWriter( this, socket.getOutputStream() ) );
    }
    catch( IOException e )
    {
      throw new RuntimeException( e );
    }
    this.user = user;
    this.messageHandler = messageHandler;
  }

  public void handleMessageFromServer( String message )
  {
    messageHandler.handleMessage( message );
  }

  public void writeMessage( Action message )
  {
    message.setSender( user );
    writer.write( message );
  }

  @Override
  public void close()
  {
    try
    {
      socket.close();
    }
    catch( IOException e )
    {
      throw new RuntimeException( e );
    }
    finally
    {
      reader.close();
      writer.close();
    }
  }
}
