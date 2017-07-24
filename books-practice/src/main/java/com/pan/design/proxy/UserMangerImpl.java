package com.pan.design.proxy;

/**
 * Created by Pan on 2017/7/24.
 */
public class UserMangerImpl implements UserManger {
    @Override
    public User getUser(Long userId) {
        return new User(userId);
    }
}
