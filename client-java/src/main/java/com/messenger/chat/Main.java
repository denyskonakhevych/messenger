package com.messenger.chat;

import com.messenger.chat.handlers.MessageHandler;
import com.messenger.chat.handlers.SyncMessageHandler;
import com.messenger.chat.pipelines.Pipeline;
import com.messenger.chat.pipelines.PipelineFactory;
import com.messenger.chat.services.UserService;
import com.messenger.chat.services.impl.DefaultUserService;
import com.messenger.entities.data.user.UserData;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 02.08.2016
 * Time: 19:53
 */
public class Main
{
  public static void main( String[] args )
  {
    try( Pipeline pipeline = PipelineFactory.getPipeline() )
    {
      UserService userService = new DefaultUserService( pipeline );
      final SyncMessageHandler<UserData> handler = new SyncMessageHandler<>();
      userService.register( "log", "pass", handler );
      System.out.println( handler.getMessage().toString() );
    }
    catch( Exception e )
    {
      throw new RuntimeException( e );
    }
  }
}
