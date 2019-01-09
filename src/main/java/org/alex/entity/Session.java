package org.alex.entity;

import java.util.Date;
import java.util.UUID;

public class Session {

    private final String userId;
    private final String userLogin;
    private final String sessionId = String.valueOf(UUID.randomUUID());
    private final long loginTime;

    public Session() {
        this.userLogin = "";
        this.userId = "";
        this.loginTime = 0;
    }

    public Session(String userId, String userLogin) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.loginTime = new Date().getTime();
    }

    public String getUserId() {
        return userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getSessionId() {
        return sessionId;
    }

    public long getLoginTime() {
        return loginTime;
    }

}
