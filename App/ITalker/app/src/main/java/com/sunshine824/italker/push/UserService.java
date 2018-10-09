package com.sunshine824.italker.push;

/**
 * @author chenxin
 * @date 2018\10\8 0008 15:35
 */
public class UserService implements IUserService{
    @Override
    public String search(int hashCode) {
        return "User:" + hashCode;
    }
}
