package otc.open.com.otc.rx;

import java.io.Serializable;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2018/7/2.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class TraceEvent implements Serializable {
    public String page;
    public String eventName;
    public String evevtCount;

    public TraceEvent(String page, String eventName, String evevtCount) {
        this.page = page;
        this.eventName = eventName;
        this.evevtCount = evevtCount;
    }
}
