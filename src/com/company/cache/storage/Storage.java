package com.company.cache.storage;

public interface Storage<Key,Value> {
    public Value get(Key key);
    public void put(Key key,Value value);
    public void remove(Key key);
    public boolean isFull();

}
