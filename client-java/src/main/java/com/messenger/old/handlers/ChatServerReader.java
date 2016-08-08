package com.messenger.old.handlers;

import com.messenger.old.ChatInstance;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 28.07.2016
 * Time: 19:19
 */
public class ChatServerReader implements Runnable
{
  private final InputStream socketInputStream;
  private final ChatInstance chat;

  public ChatServerReader( final ChatInstance chat, final InputStream socketInputStream )
  {
    this.chat = chat;
    this.socketInputStream = socketInputStream;
  }

  @Override
  public void run()
  {
    try( DataInputStream serverInputStream = new DataInputStream( socketInputStream ) )
    {
      while( !Thread.currentThread().isInterrupted() )
      {
        try
        {
          String message = serverInputStream.readUTF();
          chat.handleMessageFromServer( message );
        }
        catch( IOException e )
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

  public void close()
  {
    Thread.currentThread().interrupt();
  }
}
