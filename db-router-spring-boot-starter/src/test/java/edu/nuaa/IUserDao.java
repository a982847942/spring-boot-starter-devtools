package edu.nuaa;

import edu.nuaa.middleware.db.router.annotation.DBRouter;

/**
 * @author brain
 * @version 1.0
 * @date 2023/12/30 16:28
 */
public interface IUserDao {

    @DBRouter(key = "userId")
    void insertUser(String req);

}

