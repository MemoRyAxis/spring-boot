package com.memory.base.util;

import java.lang.reflect.Field;

public class NiceUtil {

  private static long autoIncrease = 1;

  public static long getIncreaseLong() {
    return autoIncrease++;
  }

  public static void dissect(Object obj) {
    if (obj == null) {
      System.out.println("obj : null");
      return;
    }
    @SuppressWarnings("rawtypes")
    Class clazz = obj.getClass();
    Field[] fields = clazz.getDeclaredFields();
    try {
      for (Field field : fields) {
        field.setAccessible(true);
        System.out.println(field.getName() + " : " + field.get(obj));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
