package xin.carryzheng.springtest.service;

import xin.carryzheng.spring.AutoWired;
import xin.carryzheng.spring.BeanNameAware;
import xin.carryzheng.spring.Component;
import xin.carryzheng.spring.InitializingBean;

/**
 * @author zhengxin
 * @date 2021-07-19 11:49:54
 */
@Component("orderService")
public class OrderService implements BeanNameAware, InitializingBean {

  @AutoWired private UserService userService;

  private String beanName;

  public void test() {
    System.out.println(userService);
    System.out.println(beanName);
  }

  @Override
  public void setBeanName(String beanName) {
    this.beanName = beanName;
  }

  @Override
  public void afterPropertiesSet() {
    System.out.println(beanName + "初始化完成");
  }
}
