package com.messenger.entities.data.chat;

import com.messenger.entities.chat.Chat;
import com.messenger.entities.data.ActionData;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 21:46
 */
public class FindMessagesInChatData implements ActionData
{
  private static final long serialVersionUID = 8903207509009711058L;

  private Chat chat;
  private String regex;

  public FindMessagesInChatData()
  {
  }

  public FindMessagesInChatData( final Chat chat, final String regex )
  {
    this.chat = chat;
    this.regex = regex;
  }

  public Chat getChat()
  {
    return chat;
  }

  public void setChat( Chat chat )
  {
    this.chat = chat;
  }

  public String getRegex()
  {
    return regex;
  }

  public void setRegex( String regex )
  {
    this.regex = regex;
  }
}
