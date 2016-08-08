package com.messenger.chat.pipelines;

import com.messenger.chat.handlers.MessageHandler;
import com.messenger.entities.Action;
import com.messenger.entities.data.ActionData;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 16:12
 */
public interface Pipeline extends AutoCloseable
{
  void writeMessage(final Action<? extends ActionData> message);

  void writeMessage(final Action<? extends ActionData> message, final MessageHandler<? extends ActionData> handler);
}
