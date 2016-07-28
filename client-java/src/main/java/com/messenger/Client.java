package com.messenger;

import com.messenger.chat.Chat;
import com.messenger.chat.handlers.ConsoleClientHandler;
import com.messenger.chat.services.ChatService;
import com.messenger.entities.ActionType;
import com.messenger.entities.Message;
import com.messenger.entities.Sender;

import java.util.Scanner;

public class Client
{
  public static void main( String[] ar )
  {

    Client client = new Client();
    client.run();
  }

  private void run()
  {
    try ( Scanner keyboard = new Scanner( System.in ) )
    {
      Sender user = ChatService.createUser();
      Chat chat = ChatService.startChat( user, new ConsoleClientHandler() );

      while( true )
      {
        String line = keyboard.nextLine();
        if( "quit".equals( line ) )
        {
          Message message = new Message().setContent( null )
                  .setActionType( ActionType.EXIT );
          chat.writeMessage( message );
          break;
        }

        Message message = new Message()
                .setContent( line )
                .setActionType( ActionType.SEND );
        chat.writeMessage( message );
      }
    }
    catch( Exception e )
    {
      throw new RuntimeException( e );
    }
  }
}
