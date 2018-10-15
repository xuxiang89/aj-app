package com.anjian.app.common;


public class Constant {

	public static final int SUPER_ADMIN = 1;

	public static final String SQL_FILTER = "sql_filter";

    public enum MenuType {

    	CATALOG(0),

        MENU(1),

        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    
    public enum ScheduleStatus {

    	NORMAL(0),

    	PAUSE(1);

        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
    }

    public enum CloudService {

        QINIU(1),

        ALIYUN(2),

        QCLOUD(3);

        private int value;
        CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum MsgType {

        TJSH("提交审核"),
        SHTG("审核通过"),
        SPTG("审批通过"),
        SHTH("审核退回"),
        JTTZ("消息通知");

        private String value;
        MsgType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum AccessoryType {
        ACCESSORY("accessory"), //一般附件
        CASEFILE("caseFile"), //电子卷宗文件
        PICWALL("picwall"),//照片墙文件
        WRIT("writ"),//文书
        WRITACCESSORY("writaccessory");//文书附件


        private String value;
        AccessoryType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
