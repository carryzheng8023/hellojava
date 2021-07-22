package xin.carryzheng.spring;

/**
 * @author zhengxin
 * @date 2021-07-16 09:00:17
 */
public class BeanDefinition {

    private Class clazz;
    private String scope;


    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
