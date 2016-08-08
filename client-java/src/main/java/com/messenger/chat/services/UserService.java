package com.messenger.chat.services;

import com.messenger.chat.handlers.MessageHandler;
import com.messenger.entities.data.BooleanData;
import com.messenger.entities.data.user.UserData;
import com.messenger.entities.data.user.UserInfoData;
import com.messenger.entities.user.User;

public interface UserService
{
  void register( final String login, final String password, final MessageHandler<UserData> handler );

  void login( final String login, final String password, final MessageHandler<UserData> handler );

  void setDisplayName(final User user, final String displayName, final MessageHandler<BooleanData> handler);

  void getUserInfo(final User user, final String userId, final MessageHandler<UserInfoData> handler);

  void changePassword(final User user, final String oldPassword, final String newPassword, final MessageHandler<UserData> handler);

}
