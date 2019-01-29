package otc.open.com.otc.presenter;



import javax.inject.Inject;

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

public class LastestPresenter {

    private LastestContract.LastestView mView;

    @Inject
    LastestModel mModel;

    @Inject
    public LastestPresenter(LastestContract.LastestView mView) {
        this.mView = mView;
    }

    public void getLastest() {
        mModel.latest(new LastestModel.LastestCallBack() {
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
