package Test.enums;

public enum Days {
    MONDAY(1,"星期一"),
    TUESDAY(2,"星期二"),
    WEDNESDAY(3,"星期三"),
    THURSDAY(4,"星期四"),
    FRIDAY(5,"星期五"),
    SATURDAY(6,"星期六"),
    SUNDAY(7,"星期日");

    private int value;
    private String desc;

    Days(int value,String desc){
        this.value=value;
        this.desc=desc;
    }

    public String getDesc(){
        return desc;
    }
    public int getValue(){
        return value;
    }

}
