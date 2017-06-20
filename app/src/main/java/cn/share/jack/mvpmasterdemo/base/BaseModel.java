package cn.share.jack.mvpmasterdemo.base;

import android.text.TextUtils;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import cn.share.jack.cyghttp.BaseRetrofit;
import cn.share.jack.mvpmasterdemo.model.CygApi;
import cn.share.jack.mvpmasterdemo.model.login.UserDao;

/**
 * Created by jack on 2017/6/13
 */

public class BaseModel extends BaseRetrofit {

    private static final String TAG = "BaseModel";

    protected CygApi mServletApi;

    protected Map<String, String> mParams = new HashMap<>();

    public BaseModel() {
        super();
        mServletApi = mRetrofit.create(CygApi.class);
    }

    @Override
    protected Map<String, String> getCommonMap() {
        Map<String, String> commonMap = new HashMap<>();
        commonMap.put("user_id", String.valueOf(UserDao.getInstance().getUserId()));
        commonMap.put("token", String.valueOf(UserDao.getInstance().getToken()));
        return commonMap;
    }

    protected void addParams(String key, String value) {
        if (TextUtils.isEmpty(key)) {
            Log.e(TAG, "the key is null");
            return;
        }
        mParams.put(key, value);
    }

    protected void addParams(Map<String, String> params) {
        if (null == params) {
            Log.e(TAG, "the map is null");
            return;
        }
        mParams.putAll(params);
    }
}
