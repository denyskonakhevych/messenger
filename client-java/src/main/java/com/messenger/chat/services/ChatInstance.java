package com.messenger.chat.services;

import com.messenger.chat.handlers.MessageHandler;
import com.messenger.chat.pipelines.Pipeline;
import com.messenger.chat.pipelines.PipelineFactory;
import com.messenger.chat.services.impl.DefaultChatService;
import com.messenger.chat.services.impl.DefaultUserService;
import com.messenger.entities.chat.Chat;
import com.messenger.entities.chat.Message;
import com.messenger.entities.data.BooleanData;
import com.messenger.entities.data.chat.ChatData;
import com.messenger.entities.data.chat.ChatActionData;
import com.messenger.entities.data.chat.ChatMessagesData;
import com.messenger.entities.data.chat.ChatsListData;
import com.messenger.entities.data.user.UserData;
import com.messenger.entities.data.user.UserInfoData;
import com.messenger.entities.user.User;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 02.08.2016
 * Time: 18:21
 */
public class ChatInstance implements UserService, ChatService, AutoCloseable
{
  private final Pipeline pipeline = PipelineFactory.getPipeline();
  private UserService userService = new DefaultUserService( pipeline );
  private ChatService chatService = new DefaultChatService( pipeline );

  @Override
  public void register( String login, String password, MessageHandler<UserData> handler )
  {
    userService.register( login, password, handler );
  }

  @Override
  public void login( String login, String password, MessageHandler<UserData> handler )
  {
    userService.login( login, password, handler );
  }

  @Override
  public void setDisplayName( User user, String displayName, MessageHandler<BooleanData> handler )
  {
    userService.setDisplayName( user, displayName, handler );
  }

  @Override
  public void getUserInfo( User user, String userId, MessageHandler<UserInfoData> handler )
  {
    userService.getUserInfo( user, userId, handler );
  }

  @Override
  public void changePassword( User user, String oldPassword, String newPassword, MessageHandler<UserData> handler )
  {
    userService.changePassword( user, oldPassword, newPassword, handler );
  }

  @Override
  public void createChat( User user, MessageHandler<ChatData> handler, String... userIds )
  {
    chatService.createChat( user, handler, userIds );
  }

  @Override
  public void sendMessage( User user, Chat chat, Message message, MessageHandler<ChatActionData> handler )
  {
    chatService.sendMessage( user, chat, message, handler );
  }

  @Override
  public void getUserChats( User user, MessageHandler<ChatsListData> handler )
  {
    chatService.getUserChats( user, handler );
  }

  @Override
  public void findInChat( User user, Chat chat, String regex, MessageHandler<ChatMessagesData> handler )
  {
    chatService.findInChat( user, chat, regex, handler );
  }

  @Override
  public void close() throws Exception
  {
    pipeline.close();
  }
}
