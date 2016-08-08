package com.messenger.entities.data.user;

import com.messenger.entities.data.ActionData;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 18:39
 */
public class GetUserInfoData implements ActionData
{
  private static final long serialVersionUID = -4505222778944150845L;
  private String userId;

  public GetUserInfoData()
  {
  }

  public GetUserInfoData( String userId )
  {
    this.userId = userId;
  }

  public String getUserId()
  {
    return userId;
  }

  public void setUserId( String userId )
  {
    this.userId = userId;
  }
}
