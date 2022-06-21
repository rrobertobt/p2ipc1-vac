package com.robertob.p2ipc1.utils.list;

public class Node<T> {
    
    private T item;
    private Node<T> next;
    private Node<T> previous;

    public Node(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
    
    

}
