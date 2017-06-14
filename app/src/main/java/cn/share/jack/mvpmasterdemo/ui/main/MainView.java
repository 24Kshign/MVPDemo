package cn.share.jack.mvpmasterdemo.ui.main;

import java.util.List;

import cn.share.jack.mvpmasterdemo.model.main.MainInfo;

/**
 * Created by jack on 2017/6/14
 */

public interface MainView {

    void getArticleDataSuccess(List<MainInfo> data);

    void getArticleDataFailure(Throwable t);
}