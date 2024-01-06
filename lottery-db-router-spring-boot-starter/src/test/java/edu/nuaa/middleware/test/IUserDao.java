package edu.nuaa.middleware.test;


import edu.nuaa.middleware.db.router.annotation.DBRouter;

public interface IUserDao {

    @DBRouter(key = "userId")
    void insertUser(String req);

}
