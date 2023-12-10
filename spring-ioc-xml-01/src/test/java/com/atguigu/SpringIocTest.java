package com.atguigu;

import com.atguigu.ioc_01.HappyComponent;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: SpringIocTest
 * PackageName: com.atguigu
 * Description:
 *
 * @Author: Hanyu
 * @Date: 2023/12/10 - 22:39
 * @Version: v1.0
 */
public class SpringIocTest {
    @Test
    public void test(){
        //IOC 容器创建，方式一
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        //IOC 容器创建，方式二
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        classPathXmlApplicationContext.setConfigLocations("spring-01.xml");
        classPathXmlApplicationContext.refresh();//ioc di动作

//        Object happyComponent = classPathXmlApplicationContext.getBean("happyComponent");
        HappyComponent bean = classPathXmlApplicationContext.getBean(HappyComponent.class);
        bean.doWork();
    }
}
