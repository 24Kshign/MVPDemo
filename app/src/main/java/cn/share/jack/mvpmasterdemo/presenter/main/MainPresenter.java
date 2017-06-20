package cn.share.jack.mvpmasterdemo.presenter.main;

import java.util.List;

import cn.share.jack.cyghttp.callback.BaseImpl;
import cn.share.jack.cyghttp.callback.CygBaseObserver;
import cn.share.jack.mvpmasterdemo.model.main.MainInfo;
import cn.share.jack.mvpmasterdemo.model.main.MainModel;
import cn.share.jack.mvpmasterdemo.base.BasePresenter;
import cn.share.jack.mvpmasterdemo.ui.main.MainView;

/**
 * Created by jack on 2017/6/14
 */

public class MainPresenter extends BasePresenter<MainView<List<MainInfo>>> {

    public MainPresenter(MainView<List<MainInfo>> mainView) {
        attachView(mainView);
    }

    public void getArticleData(BaseImpl baseImpl) {
        MainModel.getInstance().execute(new CygBaseObserver<List<MainInfo>>(baseImpl) {
            @Override
            protected void onBaseNext(List<MainInfo> data) {
                getView().onRequestSuccessData(data);
            }

            @Override
            protected void onBaseError(Throwable t) {
                super.onBaseError(t);
                getView().getArticleDataFailure(t);
            }
        });
    }
}