package com.atguigu;

import com.atguigu.ioc_01.HappyComponent;
import com.atguigu.ioc_05.MyBean;
import com.atguigu.ioc_05.MyBeanFactoryBean;
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

    /**
     * 测试FactoryBeanFactoryBean和BeanFactory区别
     *
     * \*\*FactoryBean \*\*是 Spring 中一种特殊的 bean，可以在 getObject() 工厂方法自定义的逻辑创建Bean！是一种能够生产其他 Bean 的 Bean
     * 。FactoryBean 在容器启动时被创建，而在实际使用时则是通过调用 getObject() 方法来得到其所生产的 Bean。因此，FactoryBean 可以自定义任何所需的初始化逻辑，
     * 生产出一些定制化的 bean。
     *
     * 一般情况下，整合第三方框架，都是通过定义FactoryBean实现！！！
     *
     */
    @Test
    public void testFactoryBean(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-05.xml");
        /*    <!--getObject() 返回变量名作为bean id, 其实xml配置bean标签对象是FactoryBean对象，属性是为FactoryBean赋值的；
        但是根据id拿到的是getObj中对象；想要拿到FactoryBean需要id前+&符号才行-->
         */
        MyBean myBeanTest = applicationContext.getBean("myBeanTest", MyBean.class);
        System.out.println("myBeanTest = " + myBeanTest);

        Object bean = applicationContext.getBean("&myBeanTest");
        System.out.println("bean = " + bean);
        System.out.println(bean.getClass());

    }
}
