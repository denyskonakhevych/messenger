package com.messenger.chat.pipelines;

import com.messenger.chat.ChatHelper;
import com.messenger.config.ServerConfig;

/**
 * Created with IntelliJ IDEA.
 * User: Denys Konakhevych
 * Date: 31.07.2016
 * Time: 18:17
 */
public class PipelineFactory
{

  private static final SocketPipeline pipeline = new SocketPipeline( ChatHelper.getInetAddress( ServerConfig.getHost() ), ServerConfig.getPort() );

  public static Pipeline getPipeline()
  {
    return pipeline;
  }
}
