package com.messenger.entities.data.user;

import com.messenger.entities.data.ActionData;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 18:39
 */
public class SetUserDisplayNameData implements ActionData
{

  private static final long serialVersionUID = 5837974361572484824L;
  private String displayName;

  public SetUserDisplayNameData()
  {
  }

  public SetUserDisplayNameData( String displayName )
  {
    this.displayName = displayName;
  }

  public String getDisplayName()
  {
    return displayName;
  }

  public void setDisplayName( String displayName )
  {
    this.displayName = displayName;
  }
}
