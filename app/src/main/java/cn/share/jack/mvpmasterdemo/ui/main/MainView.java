package cn.share.jack.mvpmasterdemo.ui.main;

import cn.share.jack.mvpmasterdemo.base.BaseRequestContract;

/**
 * Created by jack on 2017/6/14
 */

public interface MainView<T> extends BaseRequestContract<T>{

    void getArticleDataFailure(Throwable t);
}