package com.messenger.services;

import com.messenger.entities.Action;
import com.messenger.entities.encoder.Encoder;
import com.messenger.entities.encoder.JSONEncoder;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 16:40
 */
public class ActionWriter implements AutoCloseable
{
  private final DataOutputStream dataOutputStream;
  private final Encoder encoder = new JSONEncoder();

  public ActionWriter( final OutputStream outputStream )
  {
    this.dataOutputStream = new DataOutputStream( outputStream );
  }

  public void writeAction( final Action action )
  {
    try
    {
      byte[] actionBytes = encoder.encode( action );
      int size = actionBytes.length;
      dataOutputStream.writeInt( size );
      dataOutputStream.write( actionBytes );
      dataOutputStream.flush();
    }
    catch( IOException e )
    {
      throw new RuntimeException( e );
    }
  }

  @Override
  public void close()
  {
    try
    {
      this.dataOutputStream.close();
    }
    catch( IOException e )
    {
      throw new RuntimeException( e );
    }
  }
}
