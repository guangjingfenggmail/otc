package otc.open.com.otc.base;

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
public interface BaseCallBack<T> {

    /**
     *
     * @param result
     */
    void onSuccess(T result);

    /**
     *
     * @param msg
     */
    void onFailure(String msg);
}
