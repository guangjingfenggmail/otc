package otc.open.com.otc.base;



import java.lang.ref.WeakReference;

import otc.open.com.otc.base.mvp.IPresenter;

/**
 * Created by GaoSheng on 2016/11/26.
 * 17:21
 *
 * @VERSION V1.4
 * com.example.gs.mvpdemo.base
 */

public abstract class BasePresenter<CV extends BaseContractView> implements IPresenter {
    private WeakReference actReference;
    protected CV iView;

//    public abstract HashMap<String, IModel> getiModelMap();

    @Override
    public void attachView(BaseContractView iView) {
        actReference = new WeakReference(iView);
    }

    @Override
    public void detachView() {
        if (actReference != null) {
            actReference.clear();
            actReference = null;
        }
    }

    @Override
    public CV getIView() {
        return (CV) actReference.get();
    }

//    /**
//     * @param models
//     * @return
//     * 添加多个model,如有需要
//     */
//    public abstract HashMap<String, IModel> loadModelMap(IModel... models);

}
