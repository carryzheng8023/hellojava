package xin.carryzheng.springtest.service;

import xin.carryzheng.spring.Component;
import xin.carryzheng.spring.Scope;

/**
 * @author zhengxin
 * @date 2021-07-14 15:17:23
 */
@Scope("prototype")
@Component("userService")
public class UserServiceImpl implements UserService{
}
