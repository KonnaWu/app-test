package cn.wolfcode.test.proxy;

import cn.wolfcode.test.proxy.IUserService;

public class UserServiceImpl implements IUserService {
    public void save() {
        System.out.println("save successful");
    }
}
