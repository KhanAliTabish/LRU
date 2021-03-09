package com.company.algorithms.doublyLinkedList;

import com.company.algorithms.exceptions.InvalidElementException;
import com.company.algorithms.exceptions.InvalidNodeException;

public class DoublyLinkedList<E> {
    DNode<E> dHead,dTail;
    public DoublyLinkedList(){
        dHead = new DNode<>(null);
        dTail = new DNode<>(null);

        dHead.forward = dTail;
        dTail.backward = dHead;

    }
    public void addNodeAtEnd(DNode<E> node){
        DNode prev = dTail.backward;
        prev.forward = node;
        node.forward = dTail;
        dTail.backward = node;
        node.backward = prev;
    }

    public DNode addElementAtEnd(E ele){
        if(ele == null) throw  new InvalidElementException();
        DNode<E> node = new DNode(ele);
        addNodeAtEnd(node);
        return node;
    }
    public boolean isEmpty(){
        return dHead.forward == dTail;
    }
    public DNode getFirstNode() throws InvalidNodeException{
        if(isEmpty()) return null;
        return dHead.forward;
    }
    public DNode getLastNode() throws InvalidNodeException{
        if(isEmpty()) return null;
        return dTail.backward;
    }
    public void detachNode(DNode<E> node){
        if(node !=null){
            node.backward.forward = node.forward;
            node.forward.backward = node.backward;
        }
    }
}
