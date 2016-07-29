package com.messenger.chat.handlers;

import com.messenger.chat.Chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 28.07.2016
 * Time: 19:19
 */
public class ServerReader implements Runnable
{
  private final InputStream socketInputStream;
  private final Chat chat;

  public ServerReader( final Chat chat, final InputStream socketInputStream )
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
