package com.messenger;

import com.messenger.entities.Action;
import com.messenger.entities.data.ActionFactory;
import com.messenger.entities.data.BooleanData;
import com.messenger.entities.data.chat.*;
import com.messenger.entities.data.user.*;
import com.messenger.entities.user.ServerUser;
import com.messenger.entities.user.User;
import com.messenger.exceptions.MessagingException;

import java.util.UUID;

public class ActionHandler
{
  public Action handle( Action requestAction )
  {
    if( requestAction.getData() instanceof RegisterData ) {
      return handleRegistrationAction( requestAction );
    } else if ( requestAction.getData() instanceof LoginData ) {
      return handleLoginAction( requestAction );
    } else if ( requestAction.getData() instanceof GetUserInfoData ) {
      return handleGetUserInfoAction( requestAction );
    } else if( requestAction.getData() instanceof ChangePasswordData ) {
      return handleChangePasswordData( requestAction );
    } else if( requestAction.getData() instanceof SetUserDisplayNameData ) {
      return handleSetUserDisplayNameAction( requestAction );
    }
    else if( requestAction.getData() instanceof CreateChatData ) {
      return handleCreateChatAction( requestAction );
    } else if( requestAction.getData() instanceof SendMessageToChatData ) {
      return handleSendMessageAction( requestAction );
    } else if( requestAction.getData() instanceof GetUserChatsData ) {
      return handleGetUserChatsAction( requestAction );
    } else if( requestAction.getData() instanceof FindMessagesInChatData ) {
      return handleFindInChatAction( requestAction );
    }

    throw new MessagingException( "Unsupported handled action type: " + requestAction.getClass().getSimpleName() );
  }

  private Action handleCreateChatAction( Action requestAction )
  {
    return null;
  }

  private Action handleSendMessageAction( Action requestAction )
  {
    return null;
  }

  private Action handleGetUserChatsAction( Action requestAction )
  {
    return null;
  }

  private Action handleFindInChatAction( Action requestAction )
  {
    return null;
  }

  private Action handleRegistrationAction( Action requestAction )
  {
    RegisterData data = (RegisterData) requestAction.getData();
    User user = new User();
    user.setUserId( UUID.randomUUID().toString() );
    user.setDisplayName( data.getLogin() );
    user.setUserToken( UUID.randomUUID().toString() );
    return ActionFactory.createAction( ServerUser.getUser(), requestAction, new UserData( user ) );
  }

  private Action handleLoginAction( Action requestAction )
  {
    LoginData data = (LoginData) requestAction.getData();
    User user = new User();
    user.setUserId( UUID.randomUUID().toString() );
    user.setDisplayName( data.getLogin() );
    user.setUserToken( UUID.randomUUID().toString() );
    return ActionFactory.createAction( ServerUser.getUser(), requestAction, new UserData( user ) );
  }

  private Action handleSetUserDisplayNameAction( Action requestAction )
  {
    SetUserDisplayNameData data = (SetUserDisplayNameData) requestAction.getData();
    String newDisplayName = data.getDisplayName();
    requestAction.getSender().setDisplayName( newDisplayName );
    return ActionFactory.createAction( ServerUser.getUser(), requestAction, new BooleanData( true ) );
  }

  private Action handleGetUserInfoAction( Action requestAction )
  {
    GetUserInfoData data = (GetUserInfoData) requestAction.getData();
    return ActionFactory.createAction( ServerUser.getUser(), requestAction, new UserInfoData( "some info" ) );
  }

  private Action handleChangePasswordData( Action requestAction )
  {
    ChangePasswordData data = (ChangePasswordData) requestAction.getData();
    String oldPassword = data.getOldPassword();
    String newPassword = data.getNewPassword();
    return ActionFactory.createAction( ServerUser.getUser(), requestAction, new UserData( requestAction.getSender() ) );
  }
}
