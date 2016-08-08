package com.messenger.entities.data.chat;

import com.messenger.entities.data.ActionData;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 21:46
 */
public class CreateChatData implements ActionData
{
  private static final long serialVersionUID = -8023645913532029678L;
  private String[] userIds;

  public CreateChatData()
  {
  }

  public CreateChatData( String[] userIds )
  {
    this.userIds = userIds;
  }

  public String[] getUserIds()
  {
    return userIds;
  }

  public void setUserIds( String[] userIds )
  {
    this.userIds = userIds;
  }
}
