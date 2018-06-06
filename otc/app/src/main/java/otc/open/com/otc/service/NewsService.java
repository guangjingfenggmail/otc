package otc.open.com.otc.service;

import otc.open.com.otc.rx.BaseHttpResult;
import otc.open.com.otc.service.bean.LatestBean;
import retrofit2.http.GET;
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
public interface NewsService {

    /**
     *
     * @return
     */
    @GET("news/latest")
    Observable<LatestBean> latest();
}
