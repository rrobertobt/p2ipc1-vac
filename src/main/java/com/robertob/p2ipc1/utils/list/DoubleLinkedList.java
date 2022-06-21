package com.robertob.p2ipc1.utils.list;

import java.util.LinkedList;

public class DoubleLinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;
    
    public void add(T item){
        if (isEmpty()) {
            Node<T> newNode = new Node<>(item);
            first = newNode;
            last = newNode;
        } else {
            Node<T> newNode = new Node<>(item);
            last.setNext(newNode);
            newNode.setPrevious(last);
            last = newNode;
        }
        size++;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public int length(){
        return size;
    }
    
    public void removeAtIndex(int index) throws DoubleLinkedListException{
        if (index >= size || index < 0) {
            throw new DoubleLinkedListException("Index out of bounds");
        }
        
        if(index == 0){
            first = first.getNext();
            
        }
    
    }
    
}
