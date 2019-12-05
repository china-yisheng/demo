package com.base.utils.log;

import java.lang.annotation.*;

/**
 * @author Yr
 * @description 对controller操作存日志
 */
@Retention(RetentionPolicy.RUNTIME) //1、RetentionPolicy.SOURCE 注解只保留在源文件中，在编译成class文件的时候被遗弃
                                    //2、RetentionPolicy.CLASS 注解被保留在class中，但是在jvm加载的时候北欧抛弃，这个是默认的声明周期
                                    //3、RetentionPolicy.RUNTIME 注解在jvm加载的时候仍被保留
@Target(ElementType.METHOD) //定义注解声明在哪些元素前面
@Documented
public @interface AopLog {
    //定哟注解成员
    String actionType() default  ""; //这里添加操作类型 1、添加   2、修改   3、删除    4、查询
}
