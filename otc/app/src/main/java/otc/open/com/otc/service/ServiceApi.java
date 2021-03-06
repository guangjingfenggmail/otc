package otc.open.com.otc.service;

import otc.open.com.otc.service.bean.TickerJson;
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
    @GET("data/v1/ticker?market=btc_usdt")
    Observable<TickerJson> call();
}
