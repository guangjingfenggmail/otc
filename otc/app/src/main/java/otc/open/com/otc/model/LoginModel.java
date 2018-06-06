package otc.open.com.otc.model;

import android.support.annotation.NonNull;

import otc.open.com.otc.base.BaseModel;
import otc.open.com.otc.base.OtcApplication;
import otc.open.com.otc.rx.RetrofitManager;
import otc.open.com.otc.rx.exception.ApiException;
import otc.open.com.otc.rx.retrofit.CommonSubscriber;
import otc.open.com.otc.rx.retrofit.CommonTransformer;
import otc.open.com.otc.service.LoginService;
import otc.open.com.otc.service.bean.LoginBean;


/**
 * Created by GaoSheng on 2016/11/26.
 * 20:53
 *
 * @VERSION V1.4
 * com.example.gs.mvpdemo.model
 * 主要做一些数据处理呀,网路请求呀
 */

public class LoginModel extends BaseModel {
    private boolean isLogin = false;

    public boolean login(@NonNull String username, @NonNull String pwd, @NonNull final InfoHint
            infoHint) {

        if (infoHint == null)
            throw new RuntimeException("InfoHint不能为空");

        RetrofitManager.getService(LoginService.class).login(username, pwd)
                .compose(new CommonTransformer<LoginBean>())
                .subscribe(new CommonSubscriber<LoginBean>(OtcApplication.getContext()) {
                    @Override
                    public void onNext(LoginBean loginBean) {
                        isLogin = true;
                        infoHint.successInfo("");
                    }

                    @Override
                    protected void onError(ApiException e) {
                        super.onError(e);
                        isLogin = false;
                        infoHint.failInfo(e.message);
                    }
                });
        return isLogin;
    }


    //通过接口产生信息回调
    public interface InfoHint {
        void successInfo(String str);

        void failInfo(String str);

    }

}
