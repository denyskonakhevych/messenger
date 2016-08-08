package com.messenger.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 08.08.2016
 * Time: 19:45
 */
public class MessagingException extends RuntimeException
{
  public MessagingException()
  {
  }

  public MessagingException( String message )
  {
    super( message );
  }

  public MessagingException( String message, Throwable cause )
  {
    super( message, cause );
  }

  public MessagingException( Throwable cause )
  {
    super( cause );
  }

  public MessagingException( String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace )
  {
    super( message, cause, enableSuppression, writableStackTrace );
  }
}
