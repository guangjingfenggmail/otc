package otc.open.com.otc.service;

import otc.open.com.otc.service.bean.Bean;
import retrofit2.http.GET;
import rx.Observable;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2018/6/1.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public interface ServiceApi {
    @GET("loan/product/union/home")
    Observable<Bean> call();
}
