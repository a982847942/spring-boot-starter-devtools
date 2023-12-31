package edu.nuaa.middleware.test.infrastructure.dao;

import edu.nuaa.middleware.db.router.annotation.DBRouter;
import edu.nuaa.middleware.test.infrastructure.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author brain
 * @version 1.0
 * @date 2023/12/30 16:20
 */
@Mapper
public interface IUserDao {

    @DBRouter(key = "userId")
    User queryUserInfoByUserId(User req);

    @DBRouter(key = "userId")
    void insertUser(User req);

}
