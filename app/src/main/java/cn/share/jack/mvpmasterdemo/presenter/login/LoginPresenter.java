package cn.share.jack.mvpmasterdemo.presenter.login;

import android.app.Activity;
import android.content.Intent;

import com.share.jack.greendao.bean.UserInfo;

import cn.share.jack.cyghttp.callback.BaseImpl;
import cn.share.jack.cyghttp.callback.CygBaseObserver;
import cn.share.jack.mvpmasterdemo.model.login.LoginModel;
import cn.share.jack.mvpmasterdemo.model.login.User;
import cn.share.jack.mvpmasterdemo.model.login.UserDao;
import cn.share.jack.mvpmasterdemo.base.BasePresenter;
import cn.share.jack.mvpmasterdemo.ui.login.LoginView;
import cn.share.jack.mvpmasterdemo.ui.main.MainActivity;

/**
 * Created by jack on 2017/6/13
 */

public class LoginPresenter extends BasePresenter<LoginView<User>> {

    public LoginPresenter(LoginView<User> loginView) {
        attachView(loginView);
    }


    public void getUserInfo(BaseImpl baseImpl) {
        LoginModel.getInstance().execute(getView().getUserName(), getView().getPassword(), new CygBaseObserver<User>(baseImpl, "正在登录") {
            @Override
            protected void onBaseNext(User data) {
                UserInfo userInfo = new UserInfo();
                userInfo.setId(data.getId());
                userInfo.setUsername(getView().getUserName());
                userInfo.setToken(data.getToken());
                UserDao.getInstance().deleteAll(UserInfo.class);
                UserDao.getInstance().insertObject(userInfo);
                getView().onRequestSuccessData(data);
            }
        });
    }

    public void toMainActivity(Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }
}
