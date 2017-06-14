package cn.share.jack.mvpmasterdemo.model.login;

/**
 * Created by jack on 2017/6/13
 */

public class User {

    private long id;
    private String token;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}