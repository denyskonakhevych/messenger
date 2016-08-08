package com.messenger.entities.data;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 18:38
 */
public class BooleanData implements ActionData
{
  private static final long serialVersionUID = -7954102257863724149L;
  private Boolean isOk;

  public BooleanData()
  {
  }

  public BooleanData( Boolean isOk )
  {
    this.isOk = isOk;
  }

  public Boolean isOk()
  {
    return isOk;
  }

  public void setOk( Boolean isOk )
  {
    this.isOk = isOk;
  }
}
