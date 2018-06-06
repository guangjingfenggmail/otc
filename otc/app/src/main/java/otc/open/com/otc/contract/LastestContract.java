package otc.open.com.otc.contract;

import otc.open.com.otc.service.bean.LatestBean;

/**
 * Created by GaoSheng on 2016/11/26.
 * 18:28
 *
 * @VERSION V1.4
 * com.example.gs.mvpdemo.contract
 * 契约类,定义登录用到的一些接口方法
 */

public class LastestContract {

    public interface LastestView {
        /**
         *
         * @param callback
         */
        void onSuccess(LatestBean callback);

        /**
         *
         * @param str
         */
        void onFailure(String str);
    }


    public interface LastestPresenter {
        void getLastest();
    }
}
