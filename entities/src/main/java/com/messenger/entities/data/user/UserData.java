package com.messenger.entities.data.user;

import com.messenger.entities.data.ActionData;
import com.messenger.entities.user.User;

public class UserData implements ActionData
{
  private static final long serialVersionUID = -4724977630437672504L;
  private User user;

  public UserData()
  {
  }

  public UserData( User user )
  {
    this.user = user;
  }

  public User getUser()
  {
    return user;
  }

  public void setUser( User user )
  {
    this.user = user;
  }
}
