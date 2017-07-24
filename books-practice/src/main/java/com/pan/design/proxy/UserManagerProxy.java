package com.pan.design.proxy;

/**
 * Created by Pan on 2017/7/24.
 */
public class UserManagerProxy implements UserManger {

    private UserManger userManger;
    private Cache<User> cache;

    @Override
    public User getUser(Long userId) {
        User user = cache.getValue(userId.toString());
        if (user == null){
            // 从数据库获取
            user = userManger.getUser(userId);
            cache.putCache(user.getUserId().toString(), user);
        }
        return user;
    }
}
