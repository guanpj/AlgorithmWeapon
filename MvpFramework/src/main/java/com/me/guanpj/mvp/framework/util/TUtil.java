package com.me.guanpj.mvp.framework.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TUtil {
    public static <T> T getT(Object o, int i) {
        try {
            Type genericSuperClass = o.getClass().getGenericSuperclass();

            ParameterizedType parametrizedType = null;
            while (parametrizedType == null) {
                if ((genericSuperClass instanceof ParameterizedType)) {
                    parametrizedType = (ParameterizedType) genericSuperClass;
                } else {
                    genericSuperClass = ((Class<?>) genericSuperClass).getGenericSuperclass();
                }
            }

            Type type = parametrizedType.getActualTypeArguments()[i];

            return ((Class<T>) type).newInstance();

            /*return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
