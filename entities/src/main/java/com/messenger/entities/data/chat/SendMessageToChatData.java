package com.messenger.entities.data.chat;

import com.messenger.entities.chat.Chat;
import com.messenger.entities.chat.Message;
import com.messenger.entities.data.ActionData;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 21:46
 */
public class SendMessageToChatData implements ActionData
{
  private static final long serialVersionUID = 8903207509009711058L;

  private Chat chat;
  private Message message;

  public SendMessageToChatData()
  {
  }

  public SendMessageToChatData( final Chat chat, final Message message )
  {
    this.chat = chat;
    this.message = message;
  }

  public Chat getChat()
  {
    return chat;
  }

  public void setChat( Chat chat )
  {
    this.chat = chat;
  }

  public Message getMessage()
  {
    return message;
  }

  public void setMessage( Message message )
  {
    this.message = message;
  }
}
