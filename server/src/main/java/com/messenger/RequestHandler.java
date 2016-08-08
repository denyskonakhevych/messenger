package com.messenger;

import com.messenger.entities.Action;
import com.messenger.exceptions.ConnectionTerminatedException;
import com.messenger.services.ActionReader;
import com.messenger.services.ActionWriter;

import java.io.IOException;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 08.08.2016
 * Time: 20:12
 */
public class RequestHandler implements Runnable
{
  private final Socket socket;
  private final ActionHandler handler = new ActionHandler();

  public RequestHandler( Socket socket )
  {
    this.socket = socket;
  }

  @Override
  public void run()
  {
    log( "Accepted" );

    try (ActionReader reader = new ActionReader(socket.getInputStream());
         ActionWriter writer = new ActionWriter(socket.getOutputStream())) {
      while (true) {
        Action requestAction = reader.readAction();
        log( "Action came " + requestAction.getData().getClass().getSimpleName() );
        Action responseAction = handler.handle( requestAction );
        writer.writeAction( responseAction );
      }
    } catch (ConnectionTerminatedException e) {
      log( e.getMessage() + " : Interrupting" );
    } catch (IOException e) {
      log( e.getMessage() );
    }
    finally {
      try {
        socket.close();
      }
      catch( IOException e ) {
        log( e.getMessage() );
      }
      finally
      {
        Thread.currentThread().interrupt();
      }
    }
  }

  private void log( String message )
  {
    System.out.println( message );
  }
}
