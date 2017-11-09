package cn.share.jack.mvpmasterdemo.model;

import java.util.List;
import java.util.Map;

import cn.share.jack.cyghttp.BaseResponse;
import cn.share.jack.mvpmasterdemo.model.login.User;
import cn.share.jack.mvpmasterdemo.model.main.MainInfo;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by jack on 2017/6/13
 *
 * @author jack
 */

public interface CygApi {

    @FormUrlEncoded
    @POST("LoginServlet")
    Observable<BaseResponse<User>> getUserInfo(@FieldMap Map<String, String> params);


    @FormUrlEncoded
    @POST("MainServlet")
    Observable<BaseResponse<List<MainInfo>>> getArticle(@FieldMap Map<String, String> params);
}