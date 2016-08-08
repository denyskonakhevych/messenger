package com.messenger;

import com.messenger.entities.Action;
import com.messenger.entities.user.User;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatManager {
    private Set<StreamSender> participants;
    private ExecutorService executorService = Executors.newCachedThreadPool();

    public ChatManager() {
        this.participants = new HashSet<>();
    }

    public synchronized void sendMessage(Action message) {
        User sender = message.getSender();
        String nickName = sender.getDisplayName();
        String utfMessage = nickName + " >" + message.getData();
        participants.forEach( participant -> executorService.submit( () -> writeMessage( participant, utfMessage ) ) );
    }

    private void writeMessage( StreamSender participant, String utfMessage )
    {
        try {
            participant.getStream().writeUTF(utfMessage);
            participant.getStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerParticipants(StreamSender participant) {
        if (participants.contains(participant))
            return;
        participants.add(participant);
    }


}
