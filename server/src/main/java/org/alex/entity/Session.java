package org.alex.entity;

import java.util.Date;
import java.util.UUID;

public class Session {

    private final String sessionId = String.valueOf(UUID.randomUUID());
    private String userId;
    private long timestamp;

    public Session() {
        this.timestamp = new Date().getTime();
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = new Date().getTime();
    }

}
