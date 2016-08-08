package com.messenger.entities.chat;

import com.messenger.entities.user.User;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 22:27
 */
public class Message
{
  private Date timestamp;
  private String content;

  public Message()
  {
  }

  public Date getTimestamp()
  {
    return timestamp;
  }

  public void setTimestamp( Date timestamp )
  {
    this.timestamp = timestamp;
  }

  public String getContent()
  {
    return content;
  }

  public void setContent( String content )
  {
    this.content = content;
  }
}
