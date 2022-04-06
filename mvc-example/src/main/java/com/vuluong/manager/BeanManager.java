package com.vuluong.manager;

import java.util.HashMap;
import java.util.Map;

public class BeanManager {
    private final Map<Class<?>, Object> beanByKey = new HashMap<>();
    private static final BeanManager INSTANCE = new BeanManager();

    private BeanManager() {}

    public static BeanManager getInstance() {
        return INSTANCE;
    }

    public <T> void addBean(Class<T> key, T bean) {
        beanByKey.put(key, bean);
    }

    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> key) {
        return (T) beanByKey.get(key);
    }
}
