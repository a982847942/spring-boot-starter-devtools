package edu.nuaa.middleware.rpc.config;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 15:52
 */
public class ConsumerConfig {
    protected String nozzle;//接口
    protected String alias;//别名

    public String getNozzle() {
        return nozzle;
    }

    public void setNozzle(String nozzle) {
        this.nozzle = nozzle;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
