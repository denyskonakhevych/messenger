package com.messenger.chat;

import com.messenger.chat.handlers.SyncMessageHandler;
import com.messenger.chat.pipelines.Pipeline;
import com.messenger.chat.pipelines.PipelineFactory;
import com.messenger.chat.services.ChatService;
import com.messenger.chat.services.UserService;
import com.messenger.chat.services.impl.DefaultChatService;
import com.messenger.chat.services.impl.DefaultUserService;
import com.messenger.entities.chat.Chat;
import com.messenger.entities.chat.Message;
import com.messenger.entities.data.chat.ChatData;
import com.messenger.entities.data.chat.ChatActionData;
import com.messenger.entities.data.chat.ChatsListData;
import com.messenger.entities.data.user.UserData;
import com.messenger.entities.user.User;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ChatServicesTest extends Assert
{
  private final static Pipeline pipeline = PipelineFactory.getPipeline();
  private UserService userService = new DefaultUserService( pipeline );
  private ChatService chatService = new DefaultChatService( pipeline );

  @AfterClass
  static void closePipeline() throws Exception
  {
    pipeline.close();
  }

  @Test
  public void createChatTest() {

    final User chatStarter = registerRandomUser();
    final Chat chat = createRandomChat( chatStarter );
    assertNotNull( chat );
  }

  @Test
  public void sendMessageTest() {

    final User user = registerRandomUser();
    final Chat chat = createRandomChat( user );
    final SyncMessageHandler<ChatActionData> sendMessageHandler = new SyncMessageHandler<>();

    final String messageContent = "Hello world";
    final Message message = new Message();
    message.setTimestamp( new Date() );
    message.setContent( messageContent );

    chatService.sendMessage(user, chat, message, sendMessageHandler);

    final Message sentChatMessage = sendMessageHandler.getMessage().getData().getChatMessage();
    assertEquals( message.getTimestamp(), sentChatMessage.getTimestamp() );
    assertEquals( message.getContent(), sentChatMessage.getContent() );
  }

  @Test
  public void getUserChatsTest() {

    final User user = registerRandomUser();
    final int chatsToCreate = 5;
    final List<Chat> chats = new ArrayList<>( chatsToCreate );
    for( int i = 0; i < chatsToCreate; i++ )
      chats.add( createRandomChat( user ) );
    final SyncMessageHandler<ChatsListData> getUserChatsHandler = new SyncMessageHandler<>();

    chatService.getUserChats( user, getUserChatsHandler );

    final List<Chat> userChats = getUserChatsHandler.getMessage().getData().getChats();
    assertEquals( chatsToCreate, userChats.size() );
    long countRetrieved = userChats.stream()
            .filter( chats::contains )
            .count();
    assertEquals( chatsToCreate, countRetrieved );
  }

  @Test
  public void findInChatTest() {

    assertTrue( true );
  }

  private Chat createRandomChat( User chatStarter )
  {
    final SyncMessageHandler<ChatData> createHandler = new SyncMessageHandler<>();
    final String[] recepientsIds = createRandomRecepients();
    chatService.createChat( chatStarter, createHandler, recepientsIds );
    return createHandler.getMessage().getData().getChat();
  }

  private String[] createRandomRecepients()
  {
    final int recepientsNumber = 5;
    String[] recepientsIds = new String[recepientsNumber];
    for( int i = 0; i < recepientsNumber; i++ )
    {
      recepientsIds[i] = registerRandomUser().getUserId();
    }
    return recepientsIds;
  }

  private User registerRandomUser()
  {
    final SyncMessageHandler<UserData> registerHandler = new SyncMessageHandler<>();
    final String password = generatePassword();
    final String login = generateLogin();
    registerUser( password, login, registerHandler );
    return registerHandler.getMessage().getData().getUser();
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
