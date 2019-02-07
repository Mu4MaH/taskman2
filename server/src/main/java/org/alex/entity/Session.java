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
    @NotNull public String toString() {
        return sessionId + ":" + userId + ":" + timestamp;
    }

    @NotNull public String getSessionId() {
        return sessionId;
    }

    @NotNull public String getUserId() {
        return userId;
    }

    public void setUserId(@NotNull String userId) {
        this.userId = userId;
    }

    @NotNull public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@NotNull long timestamp) {
        this.timestamp = new Date().getTime();
    }

}
