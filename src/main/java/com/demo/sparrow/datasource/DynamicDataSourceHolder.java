package com.demo.sparrow.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.text.MessageFormat;

@Slf4j
public class DynamicDataSourceHolder extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> dataSourceType = new ThreadLocal<>();

    @Override
    protected Object determineCurrentLookupKey() {
        logger.debug(MessageFormat.format("threadId: {0}, switch datasource: {1}",
                Thread.currentThread().getId(), dataSourceType.get()));
        return dataSourceType.get();
    }

    public static void setDataSourceType(String typeName){
        dataSourceType.set(typeName);
    }
}
