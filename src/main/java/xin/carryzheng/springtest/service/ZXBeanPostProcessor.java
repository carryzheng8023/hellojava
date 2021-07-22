package xin.carryzheng.springtest.service;

import xin.carryzheng.spring.BeanPostProcessor;
import xin.carryzheng.spring.Component;

/**
 * @author zhengxin
 * @date 2021-07-19 16:12:25
 */
@Component
public class ZXBeanPostProcessor implements BeanPostProcessor {
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) {
    System.out.println(beanName + " : postProcessBeforeInitialization");
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) {
    System.out.println(beanName + " : postProcessAfterInitialization");
    return bean;
  }
}
