package otc.open.com.otc.contract;

import otc.open.com.otc.base.BaseContractView;
import otc.open.com.otc.service.bean.NewsInfoBean;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :fengguangjing
 * @createTime: 2018/6/9
 * @version:
 * @modifyTime:
 * @modifyAuthor:
 * @description: ****************************************************************************************************************************************************************************
 */
public class NewsInfoContract {
    public interface NewsInfoView  extends BaseContractView<NewsInfoBean>{

    }

    public interface NewsInfoPresenter{
        /**
         *
         * @param id
         */
        void getNewsInfo(String id);
    }
}
