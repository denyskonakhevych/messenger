package com.messenger.chat;

import com.messenger.chat.handlers.SyncMessageHandler;
import com.messenger.chat.pipelines.Pipeline;
import com.messenger.chat.pipelines.PipelineFactory;
import com.messenger.chat.services.UserService;
import com.messenger.chat.services.impl.DefaultUserService;
import com.messenger.entities.data.BooleanData;
import com.messenger.entities.data.user.UserData;
import com.messenger.entities.data.user.UserInfoData;
import com.messenger.entities.user.User;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class UserServicesTest extends Assert
{
  private final static Pipeline pipeline = PipelineFactory.getPipeline();
  private UserService userService = new DefaultUserService( pipeline );

  @AfterClass
  static void closePipeline() throws Exception
  {
    pipeline.close();
  }

  @Test
  public void registerUserTest() {
    System.out.println( "start test" );
    final SyncMessageHandler<UserData> registerHandler = new SyncMessageHandler<>();
    final String password = generatePassword();
    final String login = generateLogin();
    registerUser( password, login, registerHandler );
    final User registeredUser = registerHandler.getMessage().getData().getUser();
    assertNotNull( registeredUser );
  }

  @Test
  public void loginUserTest() {

    SyncMessageHandler<UserData> registerHandler = new SyncMessageHandler<>();
    final String password = generatePassword();
    final String login = generateLogin();
    registerUser( password, login, registerHandler );
    final User registeredUser = registerHandler.getMessage().getData().getUser();
    assertNotNull( registeredUser );

    final SyncMessageHandler<UserData> loginHandler = new SyncMessageHandler<>();
    userService.login( password, login, loginHandler );
    final User loggedInUser = loginHandler.getMessage().getData().getUser();
    assertNotNull( loggedInUser );
  }

  @Test
  public void setDisplayNameTest() {

    SyncMessageHandler<UserData> registerHandler = new SyncMessageHandler<>();
    final String password = generatePassword();
    final String login = generateLogin();
    registerUser( password, login, registerHandler );
    final User registeredUser = registerHandler.getMessage().getData().getUser();
    assertNotNull( registeredUser );

    final SyncMessageHandler<BooleanData> setDisplayNameHandler = new SyncMessageHandler<>();
    String displayName = generateDisplayName();
    userService.setDisplayName( registeredUser, displayName, setDisplayNameHandler );
    final Boolean setDisplayName = setDisplayNameHandler.getMessage().getData().isOk();
    assertTrue( setDisplayName );
  }

  @Test
  public void getUserInfoTest() {

    SyncMessageHandler<UserData> registerHandler = new SyncMessageHandler<>();
    final String password = generatePassword();
    final String login = generateLogin();
    registerUser( password, login, registerHandler );
    final User registeredUser = registerHandler.getMessage().getData().getUser();
    assertNotNull( registeredUser );

    final SyncMessageHandler<UserInfoData> userInfoHandler = new SyncMessageHandler<>();
    userService.getUserInfo( registeredUser, registeredUser.getUserId(), userInfoHandler );
    final String userInfo = userInfoHandler.getMessage().getData().getUserInfo();
    assertNotNull( userInfo );
  }

  @Test
  public void changePasswordTest() {

    SyncMessageHandler<UserData> registerHandler = new SyncMessageHandler<>();
    final String password = generatePassword();
    final String login = generateLogin();
    registerUser( password, login, registerHandler );
    final User registeredUser = registerHandler.getMessage().getData().getUser();
    assertNotNull( registeredUser );

    final String newPassword = generatePassword();
    final SyncMessageHandler<UserData> changePasswordHandler = new SyncMessageHandler<>();
    userService.changePassword( registeredUser, password, newPassword, changePasswordHandler );
    final User userWithChangedPassword = changePasswordHandler.getMessage().getData().getUser();
    assertNotNull( userWithChangedPassword );
    assertEquals( registeredUser.getUserId(), userWithChangedPassword.getUserId() );
    assertNotEquals( registeredUser.getUserToken(), userWithChangedPassword.getUserToken() );
  }

  private void registerUser( final String password, final String login, final SyncMessageHandler<UserData> handler )
  {
    userService.register( password, login, handler );
  }

  private static String generatePassword()
  {
    return "password" + new Random().nextInt( 1000 );
  }

  private static String generateLogin()
  {
    return "password" + new Random().nextInt( 1000 );
  }

  private static String generateDisplayName()
  {
    return "name" + new Random().nextInt( 1000 );
  }
}
