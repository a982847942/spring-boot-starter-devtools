package edu.nuaa.middleware.db.router;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/22 18:45
 */
public class DBRouterBase {
    private String tbIdx;

    public String getTbIdx() {
        return DBContextHolder.getTBKey();
    }

}
