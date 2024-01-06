package edu.nuaa.middleware.db.router;

/**
 * @author brain
 * @version 1.0
 * @date 2023/12/31 12:16
 */
public class DBRouterBase {

    private String tbIdx;

    public String getTbIdx() {
        return DBContextHolder.getTBKey();
    }

}