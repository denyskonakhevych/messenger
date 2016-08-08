package com.messenger.entities.data.chat;

import com.messenger.entities.chat.Message;
import com.messenger.entities.data.ActionData;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 21:46
 */
public class ChatMessagesData implements ActionData
{
  private static final long serialVersionUID = -8023645913532029678L;
  private List<Message> chatMessages;

  public ChatMessagesData()
  {
  }

  public ChatMessagesData( List<Message> chatMessages )
  {
    this.chatMessages = chatMessages;
  }

  public List<Message> getChatMessage()
  {
    return chatMessages;
  }

  public void setChatMessage( List<Message> chatMessages )
  {
    this.chatMessages = chatMessages;
  }
}
