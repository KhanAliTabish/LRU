package com.company.cache.factories;

import com.company.Cache;
import com.company.cache.policies.LruEviction;
import com.company.cache.storage.HashMapStorage;

public class CacheFactory<Key,Value> {
    public Cache<Key, Value> defaultCache(final int cap){
        return  new Cache<>(new LruEviction<Key>(), new HashMapStorage<Key,Value>(cap));
    }
}
