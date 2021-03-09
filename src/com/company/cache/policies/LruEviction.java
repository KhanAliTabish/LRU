package com.company.cache.policies;

import com.company.algorithms.doublyLinkedList.DNode;
import com.company.algorithms.doublyLinkedList.DoublyLinkedList;

import java.util.HashMap;

public class LruEviction<Key> implements EvictionPolicy<Key> {
    private DoublyLinkedList<Key> dll;
    private HashMap<Key, DNode<Key>> map;

    public LruEviction(){
        this.dll = new DoublyLinkedList<>();
        this.map = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if(map.containsKey(key)){
            dll.detachNode(map.get(key));
            dll.addNodeAtEnd(map.get(key));
        }else{
            DNode<Key> node = new DNode<Key>(key);
            dll.addNodeAtEnd(node);
            map.put(key,node);
        }
    }

    @Override
    public Key evictKey() {
        DNode<Key> node = dll.getFirstNode();
        if(node == null) return null;
        dll.detachNode(node);
        return node.getData();
    }
}
