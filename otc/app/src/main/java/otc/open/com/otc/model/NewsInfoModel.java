package otc.open.com.otc.model;

import android.support.annotation.NonNull;

import otc.open.com.otc.base.BaseCallBack;
import otc.open.com.otc.service.NewsService;
import otc.open.com.otc.service.bean.NewsInfoBean;

/**
 * ****************************************************************************************************************************************************************************
 * 詳細信息
 *
 * @author :fengguangjing
 * @createTime: 2018/6/9
 * @version:
 * @modifyTime:
 * @modifyAuthor:
 * @description: ****************************************************************************************************************************************************************************
 */
public class NewsInfoModel  {


    /**詳細信息
     *
     * @param id
     * @param callBack
     */

    public void getNewsInfo(String  id,@NonNull final NewsInfoCallBack callBack) {
        NewsService.getNewsInfo(id,callBack);
    }


    public interface NewsInfoCallBack extends BaseCallBack<NewsInfoBean> {

    }
}
