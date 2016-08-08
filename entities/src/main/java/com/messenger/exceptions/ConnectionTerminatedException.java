package com.messenger.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 08.08.2016
 * Time: 19:45
 */
public class ConnectionTerminatedException extends MessagingException
{
  public ConnectionTerminatedException()
  {
    super( "Connection terminated" );
  }

  public ConnectionTerminatedException( Throwable cause )
  {
    super( "Connection terminated", cause );
  }
}
