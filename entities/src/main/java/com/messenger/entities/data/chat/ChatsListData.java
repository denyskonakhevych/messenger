package com.messenger.entities.data.chat;

import com.messenger.entities.chat.Chat;
import com.messenger.entities.data.ActionData;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 21:46
 */
public class ChatsListData implements ActionData
{
  private static final long serialVersionUID = -8023645913532029678L;
  private List<Chat> chats;

  public ChatsListData()
  {
  }

  public ChatsListData( List<Chat> chats )
  {
    this.chats = chats;
  }

  public List<Chat> getChats()
  {
    return chats;
  }

  public void setChats( List<Chat> chats )
  {
    this.chats = chats;
  }
}
