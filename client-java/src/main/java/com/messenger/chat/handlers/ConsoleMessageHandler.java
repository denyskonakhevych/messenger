package com.messenger.chat.handlers;

import com.messenger.entities.Action;
import com.messenger.entities.data.ActionData;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 17:57
 */
public class ConsoleMessageHandler<E extends ActionData> implements MessageHandler<E>
{

  @Override
  public void onReceive( Action<E> message )
  {
    System.out.println( message );
  }
}
