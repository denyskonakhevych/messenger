package com.messenger.entities.data.chat;

import com.messenger.entities.chat.Message;
import com.messenger.entities.data.ActionData;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 21:46
 */
public class ChatActionData implements ActionData
{
  private static final long serialVersionUID = -8023645913532029678L;
  private Message chatMessage;

  public ChatActionData()
  {
  }

  public ChatActionData( Message chatMessage )
  {
    this.chatMessage = chatMessage;
  }

  public Message getChatMessage()
  {
    return chatMessage;
  }

  public void setChatMessage( Message chatMessage )
  {
    this.chatMessage = chatMessage;
  }
}
