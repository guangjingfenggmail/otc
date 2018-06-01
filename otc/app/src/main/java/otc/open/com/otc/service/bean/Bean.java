package otc.open.com.otc.service.bean;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2018/6/1.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class Bean {
    public int errorCode;
    public String msg;

    private String title;
    private String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
