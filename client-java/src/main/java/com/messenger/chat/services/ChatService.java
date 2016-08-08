package com.messenger.chat.services;

import com.messenger.entities.chat.Chat;
import com.messenger.chat.handlers.MessageHandler;
import com.messenger.entities.chat.Message;
import com.messenger.entities.data.chat.ChatData;
import com.messenger.entities.data.chat.ChatActionData;
import com.messenger.entities.data.chat.ChatMessagesData;
import com.messenger.entities.data.chat.ChatsListData;
import com.messenger.entities.user.User;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 15:44
 */
public interface ChatService
{
  void createChat(final User user, final MessageHandler<ChatData> handler, final String... userIds);

  void sendMessage(final User user, final Chat chat, final Message message, final MessageHandler<ChatActionData> handler);

  void getUserChats(final User user, final MessageHandler<ChatsListData> handler);

  void findInChat(final User user, final Chat chat, final String regex, final MessageHandler<ChatMessagesData> handler);
}
