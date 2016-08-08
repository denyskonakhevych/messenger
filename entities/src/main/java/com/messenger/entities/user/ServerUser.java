package com.messenger.entities.user;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 18:51
 */
public class ServerUser extends User
{
  private static final User user = new ServerUser();

  public static User getUser()
  {
    return user;
  }
  private ServerUser()
  {
  }
}
