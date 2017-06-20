package cn.share.jack.mvpmasterdemo.model.login;

import cn.share.jack.cyghttp.HttpFunction;
import cn.share.jack.mvpmasterdemo.base.BaseModel;
import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by jack on 2017/6/13
 */

public class LoginModel extends BaseModel {

    public static LoginModel getInstance() {
        return getPresent(LoginModel.class);
    }

    public void execute(String phone, String password, Observer<User> observer) {
        addParams("username", phone);
        addParams("password", password);
        Observable observable = mServletApi.getUserInfo(mParams).map(new HttpFunction());
        toSubscribe(observable, observer);
    }
}