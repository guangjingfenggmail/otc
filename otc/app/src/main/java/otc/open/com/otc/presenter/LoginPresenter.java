package otc.open.com.otc.presenter;


import java.util.HashMap;

import otc.open.com.otc.base.BasePresenter;
import otc.open.com.otc.base.mvp.IModel;
import otc.open.com.otc.contract.LoginContract;
import otc.open.com.otc.model.LoginModel;
import otc.open.com.otc.ui.activity.LoginActivity;

/**
 * Created by GaoSheng on 2016/11/26.
 * 20:51
 *
 * @VERSION V1.4
 * com.example.gs.mvpdemo.presenter
 */

public class LoginPresenter extends BasePresenter<LoginActivity> implements
        LoginContract.LoginPresenter {

    @Override
    public void login(String name, String pwd) {
        if (!getIView().checkNull()) {
            ((LoginModel) getiModelMap().get("login")).login(name, pwd, new LoginModel
                    .InfoHint() {
                @Override
                public void successInfo(String str) {
                    getIView().loginSuccess(str);  //成功
                }

                @Override
                public void failInfo(String str) {
//                    LogUtils.e("LoginPresenter.failInfo", str);

                    getIView().loginFail(str);  //失败
                }
            });
        }
    }


    @Override
    public HashMap<String, IModel> getiModelMap() {
        return loadModelMap(new LoginModel());
    }

    @Override
    public HashMap<String, IModel> loadModelMap(IModel... models) {
        HashMap<String, IModel> map = new HashMap<>();
        map.put("login", models[0]);
        return map;
    }
}
