package xin.carryzheng.spring;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhengxin
 * @date 2021-07-14 15:07:50
 */
public class ZXApplicationContext {

  private Class configClass;

  private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
  private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
  private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

  public ZXApplicationContext(Class configClass) {
    this.configClass = configClass;

    // 解析配置类
    // ComponentScan注解 -> 扫描路径 -> 扫描
    scan(configClass);

    for (String beanName : beanDefinitionMap.keySet()) {
      BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
      if (beanDefinition.getScope().equals("singleton")) {
        // 单例bean
        Object bean = createBean(beanName, beanDefinition);
        singletonObjects.put(beanName, bean);
      }
    }
  }

  private Object createBean(String beanName, BeanDefinition beanDefinition) {

    Class clazz = beanDefinition.getClazz();
    Object instance = null;
    try {
      instance = clazz.newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

    // 依赖注入 DI
    for (Field declaredField : clazz.getDeclaredFields()) {
      if(declaredField.isAnnotationPresent(AutoWired.class)){
        Object bean = getBean(declaredField.getName());
//        if(null == bean) {
//
//        }
        declaredField.setAccessible(true);
        try {
          declaredField.set(instance, bean);
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }

    // Aware回调
    if(instance instanceof BeanNameAware){
      ((BeanNameAware)instance).setBeanName(beanName);
    }


    // BeanPostProcessor
    for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
      instance = beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
    }

    // 初始化
    if(instance instanceof InitializingBean){
      ((InitializingBean)instance).afterPropertiesSet();
    }

    for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
      instance = beanPostProcessor.postProcessAfterInitialization(instance, beanName);
    }


    return instance;
  }

  private void scan(Class configClass) {
    ComponentScan componentScanAnnotation =
        (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
    String path = componentScanAnnotation.value();

    // 扫描
    // Bootstrap -> jre/lib
    // Ext -> jre/ext/lib
    // App -> classpath
    ClassLoader classLoader = ZXApplicationContext.class.getClassLoader();
    URL resource = classLoader.getResource(path.replace('.', '/'));
    File file = new File(resource.getFile());

    if (file.isDirectory()) {
      File[] files = file.listFiles();
      for (File f : files) {

        String fileName = f.getName();
        if (fileName.endsWith(".class")) {

          String className = path + "." + fileName.substring(0, f.getName().indexOf('.'));

          Class<?> clazz = null;
          try {
            clazz = classLoader.loadClass(className);
          } catch (ClassNotFoundException e) {
            e.printStackTrace();
          }
          if (clazz.isAnnotationPresent(Component.class)) {

            // 表示这个类是一个Bean
            // 解析类， 当前bean是单例bean， 还是prototype的bean -> BeanDefinition

            if (BeanPostProcessor.class.isAssignableFrom(clazz)){
              try {
                BeanPostProcessor instance = (BeanPostProcessor)clazz.getDeclaredConstructor().newInstance();
//                instance = getBean(beanName);
                beanPostProcessorList.add(instance);
              } catch (Exception e) {
                e.printStackTrace();
              }
            }

            Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
            String beanName = componentAnnotation.value();

            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setClazz(clazz);

            if (clazz.isAnnotationPresent(Component.class)) {
              Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
              if(null != scopeAnnotation){
                beanDefinition.setScope(scopeAnnotation.value());
              }else {
                beanDefinition.setScope("singleton");
              }
            }

            beanDefinitionMap.put(beanName, beanDefinition);
          }
        }
      }
    }
  }

  public Object getBean(String beanName) {

    if (beanDefinitionMap.containsKey(beanName)) {
      BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
      if (beanDefinition.getScope().equals("singleton")) {
        Object o = singletonObjects.get(beanName);
        return o;
      } else {
        // 创建bean对象
        return createBean(beanName, beanDefinition);
      }
    } else {
      // 不存在对应的bean
      throw new NullPointerException();
    }
  }
}
