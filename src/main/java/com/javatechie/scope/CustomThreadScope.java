package com.javatechie.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

public class CustomThreadScope implements Scope {


    CustomThreadLocal customThreadLocal = new CustomThreadLocal();

    @Override
    public Object get(String str, ObjectFactory<?> objectFactory) {
        System.out.println("Fetched object from scope");

        @SuppressWarnings("unchecked")
        Map<String, Object> scope = (Map<String, Object>) customThreadLocal.get();
        Object object = scope.get(str);
        if (object == null) {
            object = objectFactory.getObject();
            scope.put(str, object);
        }

        return object;
    }

    @Override
    public Object remove(String name) {
        Map<String, Object> scope = (Map<String, Object>) customThreadLocal.get();
        return scope.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }

    class CustomThreadLocal extends ThreadLocal {
        protected Map<String, Object> initialValue() {
            System.out.println("Initializing ThreadLocal");
            return new HashMap<String, Object>();
        }
    }
}
