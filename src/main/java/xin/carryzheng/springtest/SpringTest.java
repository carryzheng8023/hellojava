package xin.carryzheng.springtest;

import xin.carryzheng.spring.ZXApplicationContext;
import xin.carryzheng.springtest.service.OrderService;

/**
 * @author zhengxin
 * @date 2021-07-14 15:09:06
 */
public class SpringTest {

  public static void main(String[] args) {

    ZXApplicationContext applicationContext = new ZXApplicationContext(AppConfig.class);

    OrderService orderService = (OrderService)applicationContext.getBean("orderService");
    orderService.test();

  }
}
