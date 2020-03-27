package com.demo.sparrow.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicDataSource {
    /**
     * 默认操作master
     * @return 返回数据库类型
     */
    DynamicDataSourceType value() default DynamicDataSourceType.master;
}
