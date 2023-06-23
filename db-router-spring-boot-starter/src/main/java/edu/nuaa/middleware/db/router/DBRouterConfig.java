package edu.nuaa.middleware.db.router;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/22 18:46
 */
public class DBRouterConfig {
    private int dbCount;  //分库数
    private int tbCount;  //分表数

    public DBRouterConfig() {
    }

    public DBRouterConfig(int dbCount, int tbCount) {
        this.dbCount = dbCount;
        this.tbCount = tbCount;
    }

    public int getDbCount() {
        return dbCount;
    }

    public void setDbCount(int dbCount) {
        this.dbCount = dbCount;
    }

    public int getTbCount() {
        return tbCount;
    }

    public void setTbCount(int tbCount) {
        this.tbCount = tbCount;
    }

}
