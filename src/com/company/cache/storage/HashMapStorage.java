package com.company.cache.storage;

import com.company.cache.exception.NotFoundException;
import com.company.cache.exception.StorageFullException;

import java.util.HashMap;

public class HashMapStorage<Key,Value> implements Storage<Key,Value>{
    HashMap<Key,Value> map;
    int capacity;
    public HashMapStorage(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
    }
    @Override
    public Value get(Key key) throws NotFoundException {
        if(!map.containsKey(key)) throw new NotFoundException();
        return map.get(key);
    }

    @Override
    public void put(Key key, Value value) throws StorageFullException {
        if(isFull()) throw new StorageFullException();
        map.put(key,value);
    }

    @Override
    public void remove(Key key)throws NotFoundException {
        if(map.containsKey(key))  map.remove(key);
        else throw new NotFoundException();
    }

    @Override
    public boolean isFull() {
        return capacity == map.size();
    }
}
