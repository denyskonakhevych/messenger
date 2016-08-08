package com.messenger.entities.encoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.messenger.entities.Action;
import com.messenger.entities.data.ActionData;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 01.08.2016
 * Time: 18:31
 */
public class JSONEncoder implements Encoder
{
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public byte[] encode(final Action action )
  {
    try
    {
      byte[] messageBytes = objectMapper.writeValueAsBytes( action );
      debug( "send", messageBytes );
      return messageBytes;
    }
    catch( IOException e )
    {
      throw new RuntimeException( e );
    }
  }

  @Override
  public Action<ActionData> decode( final byte[] messageBytes )
  {
    try
    {
      debug( "decode", messageBytes );
      return objectMapper.readValue( messageBytes, Action.class );
    }
    catch( IOException e )
    {
      throw new RuntimeException( e );
    }
  }

  private void debug( final String sufix, final byte[] messageBytes )
  {
    System.out.println( sufix + ":\n" + new String( messageBytes ) );
  }
}
