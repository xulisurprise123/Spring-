package cn.itcast.pojo;


public class ChineseSay implements Person.ISay {
    @Override
    public void say() {
        System.out.println("你好");
    }
}
