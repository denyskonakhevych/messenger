package com.messenger.services;

import com.messenger.entities.Action;
import com.messenger.entities.encoder.Encoder;
import com.messenger.entities.encoder.JSONEncoder;
import com.messenger.exceptions.ConnectionTerminatedException;
import com.messenger.exceptions.MessagingException;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 16:40
 */
public class ActionReader implements AutoCloseable
{
  private final DataInputStream dataInputStream;

  private final Encoder encoder = new JSONEncoder();

  public ActionReader( final InputStream inputStream )
  {
    this.dataInputStream = new DataInputStream( inputStream );
  }

  public Action readAction()
  {
    try
    {
      byte[] buffer = new byte[1024 * 8];
      int size = dataInputStream.readInt();
      byte[] actionBytes = new byte[size];

      int total = 0;
      int readCount;
      while ( total < size && (readCount = dataInputStream.read(buffer) ) > -1) {
        System.arraycopy(buffer, 0, actionBytes, total, readCount );
        total += readCount;
      }
      return encoder.decode( actionBytes );
    }
    catch( EOFException e ) {
      throw new ConnectionTerminatedException( e );
    }
    catch( IOException e )
    {
      throw new MessagingException( e );
    }
  }

  @Override
  public void close()
  {
    try
    {
      this.dataInputStream.close();
    }
    catch( IOException e )
    {
      throw new RuntimeException( e );
    }
  }
}
