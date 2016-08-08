package com.messenger.old.handlers;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 28.07.2016
 * Time: 19:59
 */
@FunctionalInterface
public interface ClientReceiveHandler
{
  void handleMessage( String message );
}
