package com.messenger.entities.data.chat;

import com.messenger.entities.chat.Chat;
import com.messenger.entities.data.ActionData;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 21:46
 */
public class ChatData implements ActionData
{
  private static final long serialVersionUID = -8023645913532029678L;
  private Chat chat;

  public ChatData()
  {
  }

  public ChatData( Chat chat )
  {
    this.chat = chat;
  }

  public Chat getChat()
  {
    return chat;
  }

  public void setChat( Chat chats )
  {
    this.chat = chat;
  }
}
