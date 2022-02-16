package com.vuluong.designpattern;

import java.util.HashMap;
import java.util.Map;

public class SingletonExample {
    
    public static void main(String[] args) {
        Context context = Context.getInstance();
        context.addSingleton(new FooRepo());
        context.addSingleton(new BarRepo());
        context.addSingleton(new FooBarService());
        
        FooBarService fooBarService = context.getSingleton(FooBarService.class);
        System.out.println(fooBarService.fooBar());
    }
    
    private static class Context {
        private final Map<Class<?>, Object> singletons;
        private final static Context CONTEXT = new Context();
        
        private Context() {
            this.singletons = new HashMap<>();
        }
        
        public static Context getInstance() {
            return CONTEXT;
        }
        
        public void addSingleton(Object singleton) {
            this.singletons.put(singleton.getClass(), singleton);
        }
        
        @SuppressWarnings("unchecked")
        public <T> T getSingleton(Class<T> type) {
            return (T) singletons.get(type);
        }
    }
    
    private static class FooBarService {
        private final FooRepo fooRepo = Context.getInstance().getSingleton(FooRepo.class);
        private final BarRepo barRepo = Context.getInstance().getSingleton(BarRepo.class);
        
        public String fooBar() {
            return fooRepo.foo() + " " + barRepo.bar();
        }
    }
    
    private static class FooRepo {
        public String foo() {
            return "foo";
        }
    }
    
    private static class BarRepo {
        public String bar() {
            return "bar";
        }
    }
}
