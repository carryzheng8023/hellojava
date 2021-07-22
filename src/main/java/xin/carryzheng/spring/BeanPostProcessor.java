package xin.carryzheng.spring;

/**
 * @author zhengxin
 * @date 2021-07-19 16:07:43
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName);

    Object postProcessAfterInitialization(Object bean, String beanName);
}
