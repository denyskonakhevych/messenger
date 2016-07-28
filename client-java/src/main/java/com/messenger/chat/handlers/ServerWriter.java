package com.messenger.chat.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.messenger.chat.Chat;
import com.messenger.entities.Message;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 28.07.2016
 * Time: 19:19
 */
public class ServerWriter implements Runnable
{
  private final DataOutputStream serverOutputStream;
  private final Chat chat;
  private final ObjectMapper objectMapper = new ObjectMapper();

  private final BlockingQueue<Message> queue = new ArrayBlockingQueue<>(1024) ;

  public ServerWriter( final Chat chat, final DataOutputStream serverOutputStream )
  {
    this.chat = chat;
    this.serverOutputStream = serverOutputStream;
  }

  @Override
  public void run()
  {
    while( !Thread.currentThread().isInterrupted() )
    {
      try
      {
        Message message = queue.take();
        byte[] actionBytes = objectMapper.writeValueAsBytes( message );
        int size = actionBytes.length;
        serverOutputStream.writeByte( message.getActionType().getCode() );
        serverOutputStream.writeInt( size );
        serverOutputStream.write( actionBytes );
        serverOutputStream.flush();
      }
      catch( InterruptedException | IOException e )
      {
        throw new RuntimeException( e );
      }
    }
  }

  public void write( Message message )
  {
    try
    {
      queue.put( message );
    }
    catch( InterruptedException e )
    {
      throw new RuntimeException( e );
    }
  }

  public void interrupt()
  {
    Thread.currentThread().interrupt();
  }
}
