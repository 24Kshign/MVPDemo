package cn.share.jack.mvpmasterdemo.ui.login;

import cn.share.jack.mvpmasterdemo.base.BaseRequestContract;

/**
 * Created by jack on 2017/6/13
 */

public interface LoginView<T> extends BaseRequestContract<T>{

    String getUserName();

    String getPassword();

}