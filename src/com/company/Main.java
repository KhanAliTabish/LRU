package com.company;

import com.company.cache.factories.CacheFactory;

public class Main {

    public static void main(String[] args) {
        CacheFactory<Integer,String> cacheFactory = new CacheFactory<>();
        Cache<Integer,String> cache = cacheFactory.defaultCache(5);
        cache.put(1,"tabish");
        cache.put(2,"tabish");
        cache.put(3,"tabish");
        cache.put(4,"tabish");
        cache.put(5,"tabish");
        cache.put(6,"tabish");
        String a = cache.get(1);
        String b = cache.get(4);
        System.out.println("A and B ="+a+"==="+b);


    }
}
