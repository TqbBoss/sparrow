package com.demo.sparrow.datasource;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DynamicDataSourceAspect {
    @Pointcut("@annotation(com.demo.sparrow.datasource.DynamicDataSource)")
    public void cutDataSource(){}

    @Around("cutDataSource() && @annotation(dynamicDataSource)")
    public Object switchDataSource(ProceedingJoinPoint joinPoint, DynamicDataSource dynamicDataSource) throws Throwable {
        String dataSourceType = dynamicDataSource.value().getValue();
        DynamicDataSourceHolder.setDataSourceType(dataSourceType);
        try {
            return joinPoint.proceed();
        }
        catch (Exception e){
            throw e;
        }
        finally {
            DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceType.master.getValue());
        }
    }
}
