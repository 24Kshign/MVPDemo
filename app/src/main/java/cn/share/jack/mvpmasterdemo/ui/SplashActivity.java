package cn.share.jack.mvpmasterdemo.ui;

import android.content.Intent;

import cn.share.jack.mvpmasterdemo.R;
import cn.share.jack.mvpmasterdemo.base.BaseActivity;
import cn.share.jack.mvpmasterdemo.model.login.UserDao;
import cn.share.jack.mvpmasterdemo.ui.login.LoginActivity;
import cn.share.jack.mvpmasterdemo.ui.main.MainActivity;

/**
 * Created by jack on 2017/6/14
 * @author jack
 */

public class SplashActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        if (UserDao.getInstance().isHaveUser()) {
            startActivity(new Intent(this, MainActivity.class));
        } else {
            startActivity(new Intent(this, LoginActivity.class));
        }
        finish();
    }
}