package com.robertob.p2ipc1.utils.list;

public class DoubleLinkedList<T> {

    private Node<T> first = null;
    private Node<T> last = null;
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
            if (first != null) {
                first.setPrevious(null);
            }
        } else if (index == size - 1){
            removeLast();
        } else {
            Node<T> actual = searchIndex(index);
            Node<T> previous = actual.getPrevious();
            Node<T> next = actual.getNext();

            next.setPrevious(previous);
            next.setNext(next);
        }
        size--;
    
    }

    public void removeLast() throws DoubleLinkedListException {
        if (isEmpty()) {
            throw new DoubleLinkedListException("The list is empty");
        } else if (size == 1){
            first = null;
            last = null;
        } else {
            Node<T> previous = last.getPrevious();
            previous.setNext(null);
            last = previous;
        }
        size--;
    }
    
    public void removeAll(){
        Node<T> aux = new Node<>(null);
        while (first != null) {            
            aux = first;
            first = first.getNext();
            aux = null;
        }
        size = 0;
    }
    
    public T get(int index) throws DoubleLinkedListException{
        return getNode(index);
    }
        
    public Node<T> searchIndex(int index) throws DoubleLinkedListException{
        if (index >= size || index < 0) {
            throw new DoubleLinkedListException("Index out of bounds");
        }
        
        int half = size/2;
        if (index <= half) {
            return searchFirstToLast(index);
        } else {
            return searchLastToFirst(index);
        }
    }
    
    public Node<T> searchFirstToLast(int index) throws DoubleLinkedListException{
        if (index >= size || index < 0) {
            throw new DoubleLinkedListException("Index out of bounds");
        }
        
        Node<T> actual = first;
        for (int i = 0; i < index; i++) {
            Node<T> next = actual.getNext();
            actual = next;   
        }
        return actual;
    }
    
    public Node<T> searchLastToFirst(int index) throws DoubleLinkedListException{
        if (index >= size || index < 0) {
            throw new DoubleLinkedListException("Index out of bounds");
        }
        
        Node<T> actual = last;
        for (int i = 0; i < index; i++) {
            Node<T> previous = actual.getPrevious();
            actual = previous;   
        }
        return actual;
    }

    public T getFirst() {
        return first.getItem();
    }
    
    public Node<T> getFirstNode(){
        return first;
    }
    
    public void printList(){
        if (!isEmpty()) {
            Node<T> aux = first;
            
            while (aux != null) {                
                System.out.print(".[ " + aux.getItem() + " ]");
                aux = aux.getNext();
            }
        }
    }
    
    public T getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return first.getItem();
        }
        Node<T> before = first;
        for (int j = 0; j < index - 1; j++) {
            before = before.getNext();
        }
        return before.getNext().getItem();
    }
}
