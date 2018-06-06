package otc.open.com.otc.service.bean;

import java.io.Serializable;
import java.util.List;

import otc.open.com.otc.rx.BaseHttpResult;

public class LatestBean implements Serializable {
    public String date;//20180606,
    public List<StorieBean> stories;//Array[10],
    public List<TopStoriesBean> top_stories;//Array[5]


    public class StorieBean implements Serializable{
        public List<String> images;//[https://pic3.zhimg.com/v2-b50fa9094465b23eb28d41a51ed9963e.jpg],
        public String type;//0,
        public String id;//9685404,
        public String ga_prefix;//060614,
        public String title;//「防弹咖啡」减肥到底管不管用？
    }

    public class TopStoriesBean implements Serializable{
        public String image;//https://pic2.zhimg.com/v2-a98b9873ee3198ef3891b4904f00d3b1.jpg,
        public String type;//0,
        public String id;//9685567,
        public String ga_prefix;//060612,
        public String title;//哪一瞬间，你觉得自己已经不再是小孩子了？
    }
}
