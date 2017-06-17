package cn.share.jack.mvpmasterdemo.presenter.login;

import com.share.jack.greendao.bean.UserInfo;

import cn.share.jack.cyghttp.callback.BaseImpl;
import cn.share.jack.cyghttp.callback.CygBaseObserver;
import cn.share.jack.mvpmasterdemo.model.login.LoginModel;
import cn.share.jack.mvpmasterdemo.model.login.User;
import cn.share.jack.mvpmasterdemo.model.login.UserDao;
import cn.share.jack.mvpmasterdemo.presenter.BasePresenter;
import cn.share.jack.mvpmasterdemo.ui.login.LoginView;

/**
 * Created by jack on 2017/6/13
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView loginView) {
        attachView(loginView);
    }

    public void getUserInfo(BaseImpl baseImpl) {
        LoginModel.getInstance().execute(mView.getUserName(), mView.getPassword(), new CygBaseObserver<User>(baseImpl, "正在登录") {
            @Override
            protected void onBaseNext(User data) {
                UserInfo userInfo = new UserInfo();
                userInfo.setId(data.getId());
                userInfo.setUsername(mView.getUserName());
                userInfo.setToken(data.getToken());
                UserDao.getInstance().deleteAll(UserInfo.class);
                UserDao.getInstance().insertObject(userInfo);
                mView.loginSuccess();
            }
        });
    }
}
