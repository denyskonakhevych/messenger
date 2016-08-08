package com.messenger.entities.data;

import com.messenger.entities.Action;
import com.messenger.entities.user.User;
import com.messenger.entities.data.ActionData;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 18:08
 */
public class ActionFactory
{
  public static <E extends ActionData> Action<E> createAction( User user, E actionData )
  {
    final Action<E> action = new Action<>();
    action.setTimestamp( new Date() );
    action.setSender( user );
    action.setData( actionData );
    return action;
  }

  public static <E extends ActionData> Action<E> createAction( User user, Action requestAction, E actionData )
  {
    final Action<E> action = new Action<>();
    action.setTimestamp( new Date() );
    action.setSender( user );
    action.setData( actionData );
    action.setCorrelationId( requestAction.getId() );
    return action;
  }
}
