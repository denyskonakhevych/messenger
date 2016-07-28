package com.messenger.chat;

import com.messenger.chat.handlers.ChatMonitor;
import com.messenger.chat.handlers.ClientReceiveHandler;
import com.messenger.chat.handlers.ServerReader;
import com.messenger.chat.handlers.ServerWriter;
import com.messenger.entities.Message;
import com.messenger.entities.Sender;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Chat implements Runnable
{
  private final String host;
  private final Integer port;
  private final Sender user;

  private ServerReader reader;
  private ServerWriter writer;

  private ClientReceiveHandler messageHandler;

  public Chat( String host, Integer port, Sender user, ClientReceiveHandler messageHandler )
  {
    this.host = host;
    this.port = port;
    this.user = user;
    this.messageHandler = messageHandler;
  }

  @Override
  public void run()
  {
    InetAddress ipAddress = ChatHelper.getInetAddress( host );
    try (
            Socket socket = new Socket( ipAddress, port );
            DataInputStream in = new DataInputStream( socket.getInputStream() );
            DataOutputStream out = new DataOutputStream( socket.getOutputStream() ) )
    {
      reader = ChatMonitor.handleReader( new ServerReader( this, in ) );
      writer = ChatMonitor.handleWriter( new ServerWriter( this, out ) );
      while( !Thread.currentThread().isInterrupted() )
      {
        try
        {
          Thread.sleep( 1000L );
        }
        catch( InterruptedException e )
        {
          e.printStackTrace();
        }
      }
    }
    catch( IOException e )
    {
      throw new RuntimeException( e );
    }
    finally
    {
      reader.interrupt();
      writer.interrupt();
    }
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
}
