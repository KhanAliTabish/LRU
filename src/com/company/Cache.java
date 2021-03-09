package com.company;

import com.company.cache.exception.NotFoundException;
import com.company.cache.exception.StorageFullException;
import com.company.cache.policies.EvictionPolicy;
import com.company.cache.storage.Storage;

public class Cache<Key,Value> {
    private  final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key,Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key k, Value v){
        try{
            this.storage.put(k,v);
            this.evictionPolicy.keyAccessed(k);
        }catch(StorageFullException e){
            System.out.println("Got storage full. Will try to evict.");
            Key keyToRemove = evictionPolicy.evictKey();
            if (keyToRemove == null) {
                throw new RuntimeException("Unexpected State. Storage full and no key to evict.");
            }
            this.storage.remove(keyToRemove);
            System.out.println("Creating space by evicting item..." + keyToRemove);
            put(k, v);
        }
    }
    public Value get(Key k){
        try{
            Value v = this.storage.get(k);
            this.evictionPolicy.keyAccessed(k);
            return v;
        }catch(NotFoundException e){
            System.out.println("Tried to access non-existing key.");
            return null;
        }
    }
}
