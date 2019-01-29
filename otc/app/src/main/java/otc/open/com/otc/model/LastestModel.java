package otc.open.com.otc.model;

import android.support.annotation.NonNull;

import otc.open.com.otc.base.BaseCallBack;
import otc.open.com.otc.service.NewsService;
import otc.open.com.otc.service.bean.LatestBean;


/**
 * Created by GaoSheng on 2016/11/26.
 * 20:53
 *
 * @VERSION V1.4
 * com.example.gs.mvpdemo.model
 * 主要做一些数据处理呀,网路请求呀
 */

public class LastestModel {

    /**
     *
     * @param callBack
     */
    public void latest(@NonNull final LastestCallBack
                               callBack) {

        NewsService.latest(callBack);

    }


    public interface LastestCallBack  extends BaseCallBack<LatestBean> {

    }

}
