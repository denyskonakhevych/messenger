package com.messenger.old.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.messenger.old.ChatInstance;
import com.messenger.entities.Action;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 28.07.2016
 * Time: 19:19
 */
public class ChatServerWriter implements Runnable
{
  private final OutputStream socketOutputStream;
  private final ChatInstance chat;
  private final ObjectMapper objectMapper = new ObjectMapper();

  private final BlockingQueue<Action> queue = new ArrayBlockingQueue<>(1024) ;

  public ChatServerWriter( final ChatInstance chat, final OutputStream socketOutputStream )
  {
    this.chat = chat;
    this.socketOutputStream = socketOutputStream;
  }

  @Override
  public void run()
  {
    try( DataOutputStream serverOutputStream = new DataOutputStream( socketOutputStream ) )
    {
      while( !Thread.currentThread().isInterrupted() )
      {
        try
        {
          Action message = queue.take();
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
    catch( IOException e )
    {
      throw new RuntimeException( e );
    }
  }

  public void write( Action message )
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

  public void close()
  {
    Thread.currentThread().interrupt();
  }
}
