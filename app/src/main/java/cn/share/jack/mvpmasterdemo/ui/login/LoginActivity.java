package cn.share.jack.mvpmasterdemo.ui.login;

import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;

import butterknife.BindView;
import butterknife.OnClick;
import cn.share.jack.mvpmasterdemo.R;
import cn.share.jack.mvpmasterdemo.presenter.login.LoginPresenter;
import cn.share.jack.mvpmasterdemo.ui.BaseActivity;

/**
 * Created by jack on 2017/6/13
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @BindView(R.id.al_et_user_name)
    TextInputEditText alEtUserName;
    @BindView(R.id.al_et_password)
    TextInputEditText alEtPassword;

    @Override
    protected int layoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    public void loginSuccess() {
        mPresenter.toMainActivity(this);
    }

    @Override
    public String getUserName() {
        return alEtUserName.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return alEtPassword.getText().toString().trim();
    }

    @OnClick(R.id.al_btn_login)
    public void onViewClicked() {
        if (TextUtils.isEmpty(getUserName())) {
            alEtPassword.setError("用户名不能为空");
            return;
        }
        if (TextUtils.isEmpty(getPassword())) {
            alEtPassword.setError("密码不能为空");
            return;
        }
        mPresenter.getUserInfo(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }
}