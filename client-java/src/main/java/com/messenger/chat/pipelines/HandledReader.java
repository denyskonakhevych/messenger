package com.messenger.chat.pipelines;

import com.messenger.chat.handlers.MessageHandler;
import com.messenger.entities.Action;
import com.messenger.entities.data.ActionData;
import com.messenger.services.ActionReader;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 08.08.2016
 * Time: 19:21
 */
public class HandledReader implements AutoCloseable
{
  private final ActionReader reader;
  private final MessageHandler<ActionData> messageHandler;

  public HandledReader( final ActionReader reader, final MessageHandler<ActionData> messageHandler )
  {
    this.reader = reader;
    this.messageHandler = messageHandler;
  }

  public void readMessage()
  {
    final Action<ActionData> action = reader.readAction();
    messageHandler.onReceive( action );
  }

  @Override
  public void close()
  {
    reader.close();
  }
}
