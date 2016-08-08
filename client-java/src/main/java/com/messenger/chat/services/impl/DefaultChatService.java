package com.messenger.chat.services.impl;

import com.messenger.entities.chat.Chat;
import com.messenger.chat.pipelines.Pipeline;
import com.messenger.chat.handlers.MessageHandler;
import com.messenger.chat.services.ChatService;
import com.messenger.entities.data.ActionFactory;
import com.messenger.entities.Action;
import com.messenger.entities.chat.Message;
import com.messenger.entities.data.chat.*;
import com.messenger.entities.user.User;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 16:05
 */
public class DefaultChatService implements ChatService
{
  //private Pipeline pipeline = PipelineFactory.getPipeline();
  private final Pipeline pipeline;

  public DefaultChatService( final Pipeline pipeline )
  {
    this.pipeline = pipeline;
  }

  @Override
  public void createChat( final User user, final MessageHandler<ChatData> handler, final String... userIds )
  {
    if( userIds == null || userIds.length == 0 )
      throw new RuntimeException( "Cannot create chat without users" );
    Action<CreateChatData> message = ActionFactory.createAction( user, new CreateChatData( userIds ) );
    pipeline.writeMessage( message, handler );
  }

  @Override
  public void sendMessage( final User user, final Chat chat, final Message chatMessage, final MessageHandler<ChatActionData> handler)
  {
    Action<SendMessageToChatData> message = ActionFactory.createAction( user, new SendMessageToChatData( chat, chatMessage ) );
    pipeline.writeMessage( message, handler );
  }

  @Override
  public void getUserChats( final User user, final MessageHandler<ChatsListData> handler )
  {
    Action<GetUserChatsData> message = ActionFactory.createAction( user, new GetUserChatsData() );
    pipeline.writeMessage( message, handler );
  }

  @Override
  public void findInChat( final User user, final Chat chat, final String regex, final MessageHandler<ChatMessagesData> handler)
  {
    Action<FindMessagesInChatData> message = ActionFactory.createAction( user, new FindMessagesInChatData( chat, regex ) );
    pipeline.writeMessage( message, handler );
  }
}
