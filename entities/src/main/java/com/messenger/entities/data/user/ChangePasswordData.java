package com.messenger.entities.data.user;

import com.messenger.entities.data.ActionData;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 18:39
 */
public class ChangePasswordData implements ActionData
{

  private static final long serialVersionUID = 9003003398384314384L;
  private String oldPassword;
  private String newPassword;

  public ChangePasswordData()
  {
  }

  public ChangePasswordData( String oldPassword, String newPassword )
  {
    this.newPassword = newPassword;
    this.oldPassword = oldPassword;
  }

  public String getOldPassword()
  {
    return oldPassword;
  }

  public void setOldPassword( String oldPassword )
  {
    this.oldPassword = oldPassword;
  }

  public String getNewPassword()
  {
    return newPassword;
  }

  public void setNewPassword( String newPassword )
  {
    this.newPassword = newPassword;
  }
}
