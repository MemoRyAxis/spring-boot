package com.memory.base.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;

/**
 * generic type dao util
 *
 * @date 2015年8月16日上午12:03:16
 * @author memoryaxis
 *
 */
public class ActualTypeDetectors implements ActualTypeDao {
  
  private final Class<?> actualType;

  private final ConcurrentHashMap<String, String> statements;

  private ActualTypeDetectors(Class<?> clazz, Class<?> superClazz, boolean isDetect,
      boolean isStatements) {
    if (isDetect) {
      actualType = detectActualType(clazz, superClazz);
    } else {
      actualType = clazz;
    }

    if (isStatements) {
      statements = new ConcurrentHashMap<String, String>();
    } else {
      statements = null;
    }
  }

  public static <T extends ActualTypeDao> ActualTypeDao getByActualTypeDao(
      Class<? extends ActualTypeDao> clazz, Class<T> superClazz) {
    return new ActualTypeDetectors(clazz, superClazz, true, true);
  }

  public static ActualTypeDao getByActualType(Class<?> clazz) {
    return new ActualTypeDetectors(clazz, null, false, true);
  }

  @Override
  public String getActualName() {
    return actualType.getCanonicalName();
  }

  @Override
  public String getActualStatement(String mapperId) {
    String statement = (String) statements.get(mapperId);
    if (statement == null) {
      statement = actualType.getCanonicalName() + "." + mapperId;
      String result = statements.putIfAbsent(mapperId, statement);
      return result != null ? statement : result;
    }
    return statement;
  }

  private final Class<?> detectActualType(Class<?> clazz, Class<?> superClazz) {
    Class<?> c = clazz;
    while (c.getSuperclass() != superClazz) {
      c = c.getSuperclass();
    }
    Type type = c.getGenericSuperclass();
    return (Class<?>) ((ParameterizedType) type).getActualTypeArguments()[0];
  }
}
