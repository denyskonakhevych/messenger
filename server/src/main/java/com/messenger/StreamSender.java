package com.messenger;

import com.messenger.entities.user.User;

import java.io.DataOutputStream;
import java.util.Objects;

public class StreamSender extends User
{
    private User sender;
    private DataOutputStream stream;

    public StreamSender(User sender, DataOutputStream stream) {
        this.sender = sender;
        this.stream = stream;
    }

    public User getSender() {
        return sender;
    }

    public StreamSender setSender(User sender) {
        this.sender = sender;
        return this;
    }

    public DataOutputStream getStream() {
        return stream;
    }

    public StreamSender setStream(DataOutputStream stream) {
        this.stream = stream;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StreamSender that = (StreamSender) o;
        return Objects.equals(sender, that.sender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sender);
    }
}
