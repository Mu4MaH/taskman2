package org.alex.entity;

import org.alex.controller.Bootstrap;

import java.util.Date;
import java.util.UUID;

public class Session {

    private final String userId;
    private final String sessionId = String.valueOf(UUID.randomUUID());
    private final long loginTime;

    public Session() {
        this.userId = "";
        this.loginTime = 0;
    }

    public Session(String userId) {
        this.userId = userId;
        this.loginTime = new Date().getTime();
    }

    public String getUserId() {
        return userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public long getLoginTime() {
        return loginTime;
    }

    @Override
    public String toString() {
        return "Session{" +
                "userId='" + userId + '\'' +
               // ", sessionId='" + sessionId + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }
}
