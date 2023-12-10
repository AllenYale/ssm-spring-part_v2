package com.atguigu.ioc_05;

/**
 * ClassName: MyBean
 * PackageName: com.atguigu.ioc_01
 * Description:
 *
 * @Author: Hanyu
 * @Date: 2023/12/11 - 0:14
 * @Version: v1.0
 */
public class MyBean {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public MyBean() {
    }

    public MyBean(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
