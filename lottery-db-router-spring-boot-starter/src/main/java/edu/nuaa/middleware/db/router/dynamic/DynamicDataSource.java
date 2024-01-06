package edu.nuaa.middleware.db.router.dynamic;

import edu.nuaa.middleware.db.router.DBContextHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author brain
 * @version 1.0
 * @date 2023/12/31 12:17
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Value("${mini-db-router.jdbc.datasource.default}")
    private String defaultDataSource;

    @Override
    protected Object determineCurrentLookupKey() {
        if (null == DBContextHolder.getDBKey()) {
            return defaultDataSource;
        } else {
            return "db" + DBContextHolder.getDBKey();
        }
    }
}

