package com.messenger.entities.chat;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 16:08
 */
public class Chat
{
  private final String chatId;

  public Chat( final String chatId )
  {
    this.chatId = chatId;
  }

  public String getChatId()
  {
    return chatId;
  }
}
