package com.messenger.old;

import com.messenger.old.handlers.ConsoleClientHandler;
import com.messenger.old.services.ChatService;
import com.messenger.entities.ActionType;
import com.messenger.entities.Action;
import com.messenger.entities.user.User;

import java.util.Scanner;

public class ClientOld
{
  public static void main( String[] ar )
  {

    ClientOld client = new ClientOld();
    client.run();
  }

  private void run()
  {
    final User user = ChatService.createUser();
    try ( Scanner keyboard = new Scanner( System.in );
          final ChatInstance chat = ChatService.startChat( user, new ConsoleClientHandler() )
    )
    {
      while( true )
      {
        String line = keyboard.nextLine();
        if( "quit".equals( line ) )
        {
          Action message = new Action().setData( null )
                  .setActionType( ActionType.EXIT );
          chat.writeMessage( message );
          break;
        }

        Action message = new Action()
                //.setData( line )
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
