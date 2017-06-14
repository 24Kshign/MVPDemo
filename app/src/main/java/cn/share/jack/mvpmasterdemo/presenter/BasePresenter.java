package cn.share.jack.mvpmasterdemo.presenter;

/**
 * Created by jack on 2017/6/13
 */

public class BasePresenter<VIEW> {

    public VIEW mView;

    public void attachView(VIEW view) {
        this.mView = view;
    }

    public void detachView() {
        this.mView = null;
    }

}