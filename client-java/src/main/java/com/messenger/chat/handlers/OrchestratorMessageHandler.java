package com.messenger.chat.handlers;

import com.messenger.entities.Action;
import com.messenger.entities.data.ActionData;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 18:00
 */
public class OrchestratorMessageHandler implements MessageHandler
{
  private Map<String, MessageHandler<? extends ActionData>> handlers = new ConcurrentHashMap<>();

  @Override
  public void onReceive( final Action action )
  {
    if( handlers.containsKey( action.getCorrelationId() ) )
      handlers.get( action.getCorrelationId() ).onReceive( action );
    else
      declineAction(action);
  }

  public void addHandler(final String id, final MessageHandler<? extends ActionData> handler)
  {
    handlers.put( id, handler );
  }

  public void removeHandler(final String id)
  {
    handlers.remove( id );
  }

  private void declineAction( final Action action )
  {
    System.out.println( "Could not find handler for action with id: " + action.getId() );
  }
}
