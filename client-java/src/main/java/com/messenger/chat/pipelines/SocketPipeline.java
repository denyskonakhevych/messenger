package com.messenger.chat.pipelines;

import com.messenger.chat.handlers.MessageHandler;
import com.messenger.chat.handlers.OrchestratorMessageHandler;
import com.messenger.entities.Action;
import com.messenger.entities.data.ActionData;
import com.messenger.services.ActionReader;
import com.messenger.services.ActionWriter;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 16:22
 */
public class SocketPipeline implements Pipeline
{
  private final Socket socket;
  private final ActionWriter writer;
  private final HandledReader reader;
  private final OrchestratorMessageHandler handler;

  public SocketPipeline( final InetAddress ipAddress, final int serverPort )
  {
    this.handler = new OrchestratorMessageHandler();
    try
    {
      this.socket = new Socket( ipAddress, serverPort );
      this.writer = new ActionWriter( socket.getOutputStream() );
      this.reader = new HandledReader( new ActionReader( socket.getInputStream() ), this.handler );
    }
    catch( IOException e )
    {
      throw new RuntimeException( e );
    }
  }

  @Override
  public void writeMessage( final Action<? extends ActionData> message )
  {
    writer.writeAction( message );
    reader.readMessage();
  }

  @Override
  public void writeMessage( Action<? extends ActionData> message, MessageHandler<? extends ActionData> handler )
  {
    try
    {
      this.handler.addHandler( message.getId(), handler );
      writer.writeAction( message );
    }
    catch( Exception e )
    {
      this.handler.removeHandler( message.getId() );
      throw e;
    }
    reader.readMessage();
  }

  @Override
  public void close()
  {
    try
    {
      this.socket.close();
      this.writer.close();
      this.reader.close();
    }
    catch( IOException e )
    {
      throw new RuntimeException( e );
    }
  }
}
