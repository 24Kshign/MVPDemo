package cn.share.jack.mvpmasterdemo.base;

/**
 * Created by jack on 2017/6/13
 */

public class BasePresenter<VIEW>{

    protected VIEW mView;

    public void attachView(VIEW view) {
        this.mView = view;
    }

    public void detachView() {
        this.mView = null;
    }
}