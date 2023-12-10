package com.atguigu.ioc_05;

import org.springframework.beans.factory.FactoryBean;

/**
 * ClassName: MyBeanFactoryBean
 * PackageName: com.atguigu.ioc_01
 * Description:
 *
 * @Author: Hanyu
 * @Date: 2023/12/11 - 0:15
 * @Version: v1.0
 */

// 实现FactoryBean接口时需要指定泛型
// 泛型类型就是当前工厂要生产的对象的类型
public class MyBeanFactoryBean implements FactoryBean<MyBean> {
    private Integer intValue;
    private String strValue;

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    @Override
    public MyBean getObject() throws Exception {
        MyBean myBeanTest = new MyBean();
        myBeanTest.setName(strValue);
        myBeanTest.setAge(intValue);
        //getObject() 返回变量名作为bean id
        return myBeanTest;
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }
}
