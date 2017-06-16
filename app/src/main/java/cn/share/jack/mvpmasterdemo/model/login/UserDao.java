package cn.share.jack.mvpmasterdemo.model.login;

import com.share.jack.greendao.BaseGreenDao;
import com.share.jack.greendao.bean.UserInfo;

/**
 * Created by jack on 2017/6/13
 */

public class UserDao extends BaseGreenDao<UserInfo> {

    private static final String TAG = "UserDao";

    private UserDao() {

    }

    private static class Singleton {
        private static UserDao mInstance = new UserDao();
    }

    public static UserDao getInstance() {
        return Singleton.mInstance;
    }

    public boolean isHaveUser() {
        if (getUserId() != -1) {
            return true;
        }
        return false;
    }

    public UserInfo getUserInfo() {
        return queryById(0, UserInfo.class);
    }

    public long getUserId() {
        if (null != getUserInfo()) {
            return getUserInfo().getId();
        }
        return -1;
    }

    public String getToken() {
        if (null != getUserInfo()) {
            return getUserInfo().getToken();
        }
        return "";
    }
}