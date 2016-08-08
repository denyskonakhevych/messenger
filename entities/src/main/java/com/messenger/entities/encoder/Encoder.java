package com.messenger.entities.encoder;

import com.messenger.entities.Action;
import com.messenger.entities.data.ActionData;

public interface Encoder
{
  byte[] encode(final Action action);

  Action<ActionData> decode(final byte[] data);
}
