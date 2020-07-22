package com.itcast.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest {
    @Test
    public void testChineseSay(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Person.ISay chineseSay = applicationContext.getBean("chineseSay", Person.ISay.class);
        chineseSay.say();
    }
    @Test
    public void testEnglishSay(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Person.ISay  englishSay = applicationContext.getBean("englishSay", Person.ISay.class);
        englishSay.say();
    }
}
