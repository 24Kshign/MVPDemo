package cn.share.jack.mvpmasterdemo;

import cn.share.jack.cyghttp.app.CygApplication;
import cn.share.jack.cyghttp.app.HttpServletAddress;

/**
 * Created by jack on 2017/6/13
 */

public class App extends CygApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpServletAddress.getInstance().setOfflineAddress("http://192.168.2.200:8080/FriendCircle/");
    }
}
