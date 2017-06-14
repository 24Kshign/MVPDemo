package cn.share.jack.mvpmasterdemo.model.login;

import com.share.jack.greendao.BaseGreenDao;
import com.share.jack.greendao.bean.UserInfo;

import java.util.List;

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

    public long getUserId() {
        List<UserInfo> list = queryAll(UserInfo.class);
        if (null != list && list.size() > 0) {
            return list.get(0).getId();
        }
        return -1;
    }
}