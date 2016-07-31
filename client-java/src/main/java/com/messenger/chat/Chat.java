package com.messenger.chat;

import com.messenger.chat.handlers.ChatMonitor;
import com.messenger.chat.handlers.ClientReceiveHandler;
import com.messenger.chat.handlers.ServerReader;
import com.messenger.chat.handlers.ServerWriter;
import com.messenger.entities.Message;
import com.messenger.entities.Sender;

import java.io.IOException;
import java.net.Socket;

public class Chat implements AutoCloseable
{
  private final Sender user;
  private final Socket socket;

  private ServerReader reader;
  private ServerWriter writer;

  private ClientReceiveHandler messageHandler;

  public Chat( final Socket socket, Sender user, ClientReceiveHandler messageHandler )
  {
    try
    {
      this.socket = socket;
      reader = ChatMonitor.handleReader( new ServerReader( this, socket.getInputStream() ) );
      writer = ChatMonitor.handleWriter( new ServerWriter( this, socket.getOutputStream() ) );
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

  public void writeMessage( Message message )
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
