package com.messenger.chat.handlers;

import com.messenger.chat.Chat;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 28.07.2016
 * Time: 19:19
 */
public class ServerReader implements Runnable
{
  private final DataInputStream serverInputStream;
  private final Chat chat;

  public ServerReader( final Chat chat, final DataInputStream serverInputStream )
  {
    this.chat = chat;
    this.serverInputStream = serverInputStream;
  }

  @Override
  public void run()
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

  public void interrupt()
  {
    Thread.currentThread().interrupt();
  }
}
