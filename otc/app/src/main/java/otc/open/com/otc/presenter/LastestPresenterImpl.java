package otc.open.com.otc.presenter;



import otc.open.com.otc.contract.LastestContract;
import otc.open.com.otc.model.LastestModel;
import otc.open.com.otc.service.bean.LatestBean;

/**
 * Created by GaoSheng on 2016/11/26.
 * 20:51
 *
 * @VERSION V1.4
 * com.example.gs.mvpdemo.presenter
 */

public class LastestPresenterImpl  {

    private LastestContract.LastestView mView;

    public LastestPresenterImpl(LastestContract.LastestView mView) {
        this.mView = mView;
    }

    public void getLastest() {
        new LastestModel().latest(new LastestModel.LastestCallBack() {
            @Override
            public void onSuccess(LatestBean result) {
                mView.onGetLastest(result);
            }

            @Override
            public void onFailure(String str) {
            }
        });

    }


}
