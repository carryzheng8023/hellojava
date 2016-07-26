package com.zhengxin.database.mongodb;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.mongodb.morphia.annotations.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Reflects {
	static final Logger logger = LoggerFactory.getLogger(Reflects.class);
	private static final String GETTER_PREFIX = "get";
	private static final String SETTER_PREFIX = "set";
	private static final String SEPARATOR = ".";
	private static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[] {};
	private static final Map<String, Method> methods = Maps.newConcurrentMap();
	private static final Map<String, Field> fields = Maps.newConcurrentMap();
	private static final Map<Class<?>, String> CLASS_PK_MAP = Maps.newConcurrentMap();
	private static final Map<Class<?>, String[]> CLASS_Fields_MAP = Maps.newConcurrentMap();

	/**
	 * 调用Getter方法.
	 */
	public static Object invokeCachedGetter(Class<?> entityClass, Object obj, String propertyName) {
		String methodName = GETTER_PREFIX + StringUtils.capitalize(propertyName);
		Method method = getCachedMethod(entityClass, obj, methodName, EMPTY_CLASS_ARRAY);
		try {
			Object ret = method.invoke(obj);
			return ret;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void invokeCachedSetter(Class<?> entityClass, Object obj, String propertyName, Object value, Class<?> fieldClass) {
		String methodName = SETTER_PREFIX + StringUtils.capitalize(propertyName);
		Method method = getCachedMethod(entityClass, obj, methodName, fieldClass);
		try {
			method.invoke(obj, value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void setCachedFieldValue(Class<?> entityClass, Object obj, String fieldName, Object value) {
		try {
			Field field = getCachedField(entityClass, obj, fieldName);
			field.set(obj, value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Object getCachedFieldValue(Class<?> entityClass, Object obj, String fieldName) {
		try {
			Field field = getCachedField(entityClass, obj, fieldName);
			return field.get(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Field getCachedField(Class<?> entityClass, Object obj, String fieldName) throws Exception {
		String fieldKey = new StringBuilder(entityClass.getName()).append(SEPARATOR).append(fieldName).toString();
		Field field = fields.get(fieldKey);
		if (null == field) {
			logger.info("put field into cache, key:{}", fieldKey);
			field = getAccessibleField(obj, fieldName);
			if (null == field) {
				throw new RuntimeException("未找到指定Field:" + fieldKey);
			}
			fields.put(fieldKey, field);
		}
		return field;
	}

	public static Method getCachedMethod(Class<?> entityClass, Object obj, String methodName, Class<?>... argsClasses) {
		String methodKey = new StringBuilder(entityClass.getName()).append(SEPARATOR).append(methodName).toString();
		Method method = methods.get(methodKey);
		if (null == method) {
			logger.info("put method into cache, key:{}", methodKey);
			method = getAccessibleMethod(obj, methodName, argsClasses);
			if (null == method) {
				throw new RuntimeException("未找到指定方法:" + methodKey);
			}
			methods.put(methodKey, method);
		}
		return method;
	}

	/**
	 * <b>获取实体类的主键</b><br>
	 * 使用 org.mongodb.morphia.annotations.Id 注解获取
	 * 
	 * @param entityClass
	 *            实体类字节码
	 * @return 主键名称
	 * @see Id
	 * 
	 */
	public static String getCachedPkFieldName(Class<?> entityClass) {
		String ret = CLASS_PK_MAP.get(entityClass);
		if (null == ret) {
			Field[] fields = entityClass.getDeclaredFields();
			for (Field field : fields) {
				if (field.isAnnotationPresent(Id.class)) {
					ret = field.getName();
					CLASS_PK_MAP.put(entityClass, ret);
					break;
				}
			}
		}
		return ret;
	}

	public static String[] getCachedDeclaredFields(Class<?> entityClass) {
		String[] ret = CLASS_Fields_MAP.get(entityClass);
		if (null == ret) {
			Field[] fields = entityClass.getDeclaredFields();
			ret = new String[fields.length];
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				ret[i] = field.getName();
			}
			CLASS_Fields_MAP.put(entityClass, ret);
		}
		return ret;
	}

	/**
	 * 获取字段的泛型
	 * 
	 * @param field
	 * @return
	 */
	public static Type[] getFieldGenericType(Field field) {
		Type type = field.getGenericType();
		if (type instanceof ParameterizedType) { // 为了确保安全转换，使用instanceof
			ParameterizedType parameterizedType = (ParameterizedType) type;
			// Type basicType = parameterizedType.getRawType(); // field的类型
			Type[] types = parameterizedType.getActualTypeArguments(); // field的泛型的类型
			return types; // return ((Class) types[0]) // 可直接将type转为Class
		}
		return null;
	}

	/**
	 * 获取类的泛型
	 * 
	 * @param entityClass
	 * @return
	 */
	public static Type[] getClassGenericType(Class<?> entityClass) {
		Type type = entityClass.getGenericSuperclass();
		if (type instanceof ParameterizedType) { // 为了确保安全转换，使用instanceof
			ParameterizedType parameterizedType = (ParameterizedType) type;
			// Type basicType = parameterizedType.getRawType(); // class的类型
			Type[] types = parameterizedType.getActualTypeArguments(); // field的泛型的类型
			return types; // return ((Class) types[0]) // 可直接将type转为Class
		}
		return null;
	}

	// public <T> void chill(List<T> aListWithTypeT) {
	// System.out.println(GenericTypeReflector.getTypeParameter(aListWithTypeT.getClass(), Collection.class.getTypeParameters()[0]));
	// }
	//
	// public void chillWildcard(List<?> aListWithTypeWildcard) {
	// System.out.println(GenericTypeReflector.getTypeParameter(aListWithTypeWildcard.getClass(), Collection.class.getTypeParameters()[0]));
	// }

	public static <T> T getRandomEntity(Class<T> entityClass) throws Exception {
		try {
			T entity = entityClass.newInstance();
			Field[] fields = entityClass.getDeclaredFields();
			for (Field field : fields) {
				Object ret = getRandomVar(field, field.getType());
				if (null != ret) {
					Reflects.setCachedFieldValue(entityClass, entity, field.getName(), ret);
				} else {
					System.out.println("结果为空:" + field.getName());
				}
			}
			return entity;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object getRandomVar(Field field, Class<?> fieldType) throws Exception {
		String fieldName = null == field ? StringUtils.EMPTY : field.getName();
		fieldType = (null != fieldType ? fieldType : field.getType());
		Object ret = null;
		if (fieldType.getSuperclass() == Number.class) {
			ret = fieldType.getConstructor(String.class).newInstance(Integer.toString(RandomUtils.nextInt(0, 10)));
		} else if (fieldType == Date.class) {
			ret = new Date();
		} else if (fieldType == String.class) {
			ret = fieldName + "张三丰" + UUID.randomUUID().toString();
		} else if (fieldType == Boolean.class) {
			ret = RandomUtils.nextInt(0, 10) % 2 == 0;
		} else if (fieldType == List.class) {
			List<Object> lst = Lists.newArrayList();
			Type[] types = Reflects.getFieldGenericType(field);
			if (ArrayUtils.isNotEmpty(types)) {
				Class<?> clazz = (Class<?>) types[0];
				for (int i = 0; i < 4; i++) {
					lst.add(getRandomVar(null, clazz));
				}
			}
			ret = lst;
		} else {
			System.err.println("没有找到对应的类型:" + fieldType);
		}
		return ret;
	}

	public static Field getAccessibleField(final Object obj, final String fieldName) {
		Validate.notNull(obj, "object can't be null");
		Validate.notBlank(fieldName, "fieldName can't be blank");
		for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				Field field = superClass.getDeclaredField(fieldName);
				field.setAccessible(true);
				return field;
			} catch (NoSuchFieldException e) {// NOSONAR
				// Field不在当前类定义,继续向上转型
			}
		}
		return null;
	}

	public static Method getAccessibleMethod(final Object obj, final String methodName, final Class<?>... parameterTypes) {
		Validate.notNull(obj, "object can't be null");

		for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				Method method = superClass.getDeclaredMethod(methodName, parameterTypes);

				method.setAccessible(true);

				return method;

			} catch (NoSuchMethodException e) {// NOSONAR
				// Method不在当前类定义,继续向上转型
			}
		}
		return null;
	}

}
