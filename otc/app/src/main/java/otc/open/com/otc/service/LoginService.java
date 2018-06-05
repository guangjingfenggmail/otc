package otc.open.com.otc.service;

import otc.open.com.otc.rx.BaseHttpResult;
import otc.open.com.otc.service.bean.LoginBean;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2018/6/5.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public interface LoginService {
    //登录接口
    @FormUrlEncoded
    @POST("demo/login")
    Observable<BaseHttpResult<LoginBean>> login(@Field("userName") String username, @Field
            ("passWord") String pwd);
}
