package com.messenger.entities.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.messenger.entities.data.user.RegisterData;
import com.messenger.entities.data.user.UserData;

import java.io.Serializable;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RegisterData.class, name = "RegisterData"),
        @JsonSubTypes.Type(value = UserData.class, name = "UserData")
})
public interface ActionData extends Serializable
{
}
