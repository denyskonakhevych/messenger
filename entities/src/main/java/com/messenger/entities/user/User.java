package com.messenger.entities.user;

import java.util.Objects;

public class User
{
    private String userId;
    private String userToken;
    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    public User setDisplayName( String displayName ) {
        this.displayName = displayName;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public User setUserId( String userId ) {
        this.userId = userId;
        return this;
    }

    public String getUserToken()
    {
        return userToken;
    }

    public User setUserToken( String userToken )
    {
        this.userToken = userToken;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User sender = (User) o;
        return Objects.equals( userId, sender.userId );
    }

    @Override
    public int hashCode() {
        return Objects.hash( userId );
    }
}
