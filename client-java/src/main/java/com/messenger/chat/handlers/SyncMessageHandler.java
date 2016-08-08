package com.messenger.chat.handlers;

import com.messenger.entities.Action;
import com.messenger.entities.data.ActionData;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 17:57
 */
public class SyncMessageHandler<E extends ActionData> implements MessageHandler<E>
{
  private final CountDownLatch latch = new CountDownLatch( 1 );
  private Action<E> message;

  @Override
  public void onReceive( Action<E> message )
  {
    this.message = message;
    latch.countDown();
  }

  public Action<E> getMessage()
  {
    try
    {
      latch.await();
    }
    catch( InterruptedException e )
    {
      throw new RuntimeException( e );
    }
    return message;
  }
}
