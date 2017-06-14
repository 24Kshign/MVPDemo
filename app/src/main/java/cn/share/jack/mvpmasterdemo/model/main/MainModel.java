package cn.share.jack.mvpmasterdemo.model.main;

import java.util.List;

import cn.share.jack.cyghttp.HttpFunction;
import cn.share.jack.mvpmasterdemo.model.BaseModel;
import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by jack on 2017/6/14
 */

public class MainModel extends BaseModel {

    public static MainModel getInstance() {
        return getPresent(MainModel.class);
    }

    public void execute(Observer<List<MainInfo>> observer) {
        Observable observable = mServletApi.getArticle(mParams).map(new HttpFunction());
        toSubscribe(observable, observer);
    }
}
