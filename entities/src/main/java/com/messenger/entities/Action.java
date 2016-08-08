package com.messenger.entities;

import com.messenger.entities.data.ActionData;
import com.messenger.entities.user.User;

import java.util.Date;
import java.util.UUID;

public class Action<E extends ActionData> {

    private String id;
    private String correlationId;
    private E data;
    private Date timestamp;
    private User sender;
    private ActionType actionType;

    public Action()
    {
        id = UUID.randomUUID().toString();
    }

    public void setId( String id )
    {
        this.id = id;
    }

    public E getData() {
        return data;
    }

    public Action<E> setData( E data ) {
        this.data = data;
        return this;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Action<E> setTimestamp( Date timestamp ) {
        this.timestamp = timestamp;
        return this;
    }

    public User getSender() {
        return sender;
    }

    public Action<E> setSender(User sender) {
        this.sender = sender;
        return this;
    }

    public ActionType getActionType()
    {
        return actionType;
    }

    public Action<E> setActionType( ActionType actionType )
    {
        this.actionType = actionType;
        return this;
    }

    public String getId()
    {
        return id;
    }

    public Action<E> setCorrelationId( String correlationId )
    {
        this.correlationId = correlationId;
        return this;
    }

    public String getCorrelationId()
    {
        return correlationId;
    }

    @Override
    public String toString()
    {
        return "Message{" +
                "id='" + id + '\'' +
                ", correlationId='" + correlationId + '\'' +
                ", content='" + data + '\'' +
                ", sent=" + timestamp +
                ", sender=" + sender +
                ", actionType=" + actionType +
                '}';
    }
}
