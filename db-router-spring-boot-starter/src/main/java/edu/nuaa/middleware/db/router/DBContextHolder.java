package edu.nuaa.middleware.db.router;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/22 18:45
 */
public class DBContextHolder {
    private static final ThreadLocal<String> dbKey = new ThreadLocal<>();
    private static final ThreadLocal<String> tbKey = new ThreadLocal<>();
    public static void setDBKey(String dbKeyIdx){
        dbKey.set(dbKeyIdx);
    }

    public static String getDBKey(){
        return dbKey.get();
    }

    public static void setTBKey(String tbKeyIdx){
        tbKey.set(tbKeyIdx);
    }

    public static String getTBKey(){
        return tbKey.get();
    }

    public static void clearDBKey(){
        dbKey.remove();
    }

    public static void clearTBKey(){
        tbKey.remove();
    }


}
