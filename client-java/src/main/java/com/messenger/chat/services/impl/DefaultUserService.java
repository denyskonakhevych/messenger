package com.messenger.chat.services.impl;

import com.messenger.chat.pipelines.Pipeline;
import com.messenger.chat.handlers.MessageHandler;
import com.messenger.entities.data.ActionFactory;
import com.messenger.chat.services.UserService;
import com.messenger.entities.Action;
import com.messenger.entities.data.BooleanData;
import com.messenger.entities.data.user.*;
import com.messenger.entities.user.AnonymousUser;
import com.messenger.entities.user.User;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 15:53
 */
public class DefaultUserService implements UserService
{
  //private Pipeline pipeline = PipelineFactory.getPipeline();
  private final Pipeline pipeline;

  public DefaultUserService( final Pipeline pipeline )
  {
    this.pipeline = pipeline;
  }

  @Override
  public void register( final String login, final String password, final MessageHandler<UserData> handler )
  {
    Action<RegisterData> action = ActionFactory.createAction( AnonymousUser.getUser(), new RegisterData( login, password ) );
    pipeline.writeMessage( action, handler );
  }

  @Override
  public void login( final String login, final String password, final MessageHandler<UserData> handler )
  {
    Action<LoginData> message = ActionFactory.createAction( AnonymousUser.getUser(), new LoginData( login, password ) );
    pipeline.writeMessage( message, handler );
  }

  @Override
  public void setDisplayName( final User user, final String displayName, final MessageHandler<BooleanData> handler )
  {
    Action<SetUserDisplayNameData> message = ActionFactory.createAction( user, new SetUserDisplayNameData( displayName ) );
    pipeline.writeMessage( message, handler );
  }

  @Override
  public void getUserInfo( final User user, final String userId, final MessageHandler<UserInfoData> handler )
  {
    Action<UserInfoData> message = ActionFactory.createAction( user, new UserInfoData( userId ) );
    pipeline.writeMessage( message, handler );
  }

  @Override
  public void changePassword( final User user, final String oldPassword, final String newPassword, final MessageHandler<UserData> handler )
  {
    Action<ChangePasswordData> message = ActionFactory.createAction( user, new ChangePasswordData( oldPassword, newPassword ) );
    pipeline.writeMessage( message, handler );
  }
}
