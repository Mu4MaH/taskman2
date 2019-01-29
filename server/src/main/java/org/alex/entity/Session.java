package org.alex.entity;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.UUID;

public class Session {

    private final String sessionId = String.valueOf(UUID.randomUUID());
    private String userId;
    private long timestamp;

    public Session() {
        this.timestamp = new Date().getTime();
    }

    @Override
    public String toString() {
        return sessionId + ":" + userId + ":" + timestamp;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(@NotNull String userId) {
        this.userId = userId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@NotNull long timestamp) {
        this.timestamp = new Date().getTime();
    }

}
