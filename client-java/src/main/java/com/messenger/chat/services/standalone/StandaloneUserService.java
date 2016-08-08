package com.messenger.chat.services.standalone;

import com.messenger.chat.pipelines.Pipeline;
import com.messenger.chat.pipelines.PipelineFactory;
import com.messenger.chat.services.UserService;
import com.messenger.entities.user.User;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 15:53
 */
public class StandaloneUserService //implements UserService
{
//  private Pipeline pipeline = PipelineFactory.getPipeline();
//
//  @Override
//  public User login( final String login, final String password )
//  {
//    return new User()
//            .setDisplayName( "user" + Math.round( Math.random() * 100 ) )
//            .setUserId( UUID.randomUUID().toString() )
//            .setUserToken( UUID.randomUUID().toString() );
//  }
//
//  @Override
//  public void setDisplayName( final User user, final String displayName )
//  {
//    user.setDisplayName( displayName );
//  }
//
//  @Override
//  public String getUserInfo( final User user, final String userId )
//  {
//    return "";
//  }
//
//  @Override
//  public User changePassword( final User user, final String newPassword )
//  {
//    return new User()
//            .setDisplayName( user.getDisplayName() )
//            .setUserId( user.getUserId() )
//            .setUserToken( UUID.randomUUID().toString() );
//  }
}
