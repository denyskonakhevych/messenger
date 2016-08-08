package com.messenger.chat.handlers;

import com.messenger.entities.Action;
import com.messenger.entities.data.ActionData;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 17:33
 */
public interface MessageHandler<E extends ActionData>
{
  void onReceive(Action<E> message);
}
