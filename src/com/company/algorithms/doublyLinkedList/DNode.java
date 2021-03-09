package com.company.algorithms.doublyLinkedList;

public class DNode<E> {
    E data;
    DNode<E> forward,backward;
    public DNode(E data){
        this.data=data;
        forward=null;
        backward= null;
    }
    public E getData(){
        return data;
    }
}
