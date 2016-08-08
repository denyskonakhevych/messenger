package com.messenger.entities.data.user;

import com.messenger.entities.data.ActionData;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 18:39
 */
public class UserInfoData implements ActionData
{

  private static final long serialVersionUID = -88481818661809235L;
  private String userInfo;

  public UserInfoData()
  {
  }

  public UserInfoData( String userInfo )
  {
    this.userInfo = userInfo;
  }

  public String getUserInfo()
  {
    return userInfo;
  }

  public void setUserInfo( String userInfo )
  {
    this.userInfo = userInfo;
  }
}
