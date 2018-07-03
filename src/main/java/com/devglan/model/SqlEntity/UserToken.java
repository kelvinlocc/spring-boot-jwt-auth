package com.devglan.model.SqlEntity;


import javax.persistence.*;



@Entity
public class UserToken {

    @Id
    private long userId;

    @Column
    private String token;

    @Column
    private String timeStamp;












    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
