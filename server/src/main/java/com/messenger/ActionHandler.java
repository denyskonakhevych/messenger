package com.messenger;

import com.messenger.entities.Action;
import com.messenger.entities.data.ActionFactory;
import com.messenger.entities.data.user.RegisterData;
import com.messenger.entities.data.user.UserData;
import com.messenger.entities.user.ServerUser;
import com.messenger.entities.user.User;

import java.util.UUID;

public class ActionHandler
{
  public Action handle( Action requestAction )
  {
    if( requestAction.getData() instanceof RegisterData )
    {
      RegisterData data = (RegisterData) requestAction.getData();
      User user = new User();
      user.setUserId( UUID.randomUUID().toString() );
      user.setDisplayName( data.getLogin() );
      user.setUserToken( UUID.randomUUID().toString() );
      return ActionFactory.createAction( ServerUser.getUser(), requestAction, new UserData( user ) );
    }
    return null;
  }
}
