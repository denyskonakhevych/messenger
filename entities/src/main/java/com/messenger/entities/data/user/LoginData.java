package com.messenger.entities.data.user;

import com.messenger.entities.data.ActionData;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 18:39
 */
public class LoginData implements ActionData
{
  private static final long serialVersionUID = 2582421045945300343L;

  private String login;
  private String password;

  public LoginData()
  {
  }

  public LoginData( String login, String password )
  {
    this.login = login;
    this.password = password;
  }

  public String getLogin()
  {
    return login;
  }

  public void setLogin( String login )
  {
    this.login = login;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword( String password )
  {
    this.password = password;
  }

  @Override
  public String toString()
  {
    return "LoginAction{" +
            "login='" + login + '\'' +
            ", password='" + password + '\'' +
            '}';
  }
}
