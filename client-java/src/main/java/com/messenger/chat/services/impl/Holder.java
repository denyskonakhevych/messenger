package com.messenger.chat.services.impl;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 21:52
 */
public class Holder<E>
{
  private E data;

  public void setData( E data )
  {
    this.data = data;
  }

  public E get()
  {
    return data;
  }
}
