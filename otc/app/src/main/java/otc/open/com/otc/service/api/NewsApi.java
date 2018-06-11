package otc.open.com.otc.service.api;

import android.text.GetChars;

import otc.open.com.otc.service.bean.LatestBean;
import otc.open.com.otc.service.bean.NewsInfoBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

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
public interface NewsApi {
    /**
     * 最新列表
     *
     * @return
     */
    @GET("news/latest")
    Call<LatestBean> latest();

    /**
     * 获取详细信息
     *
     * @param id
     * @return
     */
    @GET("news/{id}")
    Call<NewsInfoBean> getNewsInfo(@Path("id") String id);
}
