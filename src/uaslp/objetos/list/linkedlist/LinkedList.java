package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.List;
import uaslp.objetos.list.exception.NotNullValuesAllowedException;
import uaslp.objetos.list.exception.NotValidIndexException;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void addAtTail(T data) throws NotNullValuesAllowedException{
        if(data == null){
            throw new NotNullValuesAllowedException();
        }

        Node<T> node=new Node<>(data);

        //node.data=data;

        if(size==0)
        {
            head=node;
        }else{
            tail.next=node;
            node.previous=tail;
        }

        tail = node;
        size++;
    }

    @Override
    public void addAtFront(T data) throws NotNullValuesAllowedException{
        if(data == null){
            throw new NotNullValuesAllowedException();
        }

        Node<T> node = new Node<>(data);

        if (size == 0) {
            tail = node;
        } else {
            head.previous = node;
        }
        node.next = head;
        head = node;

        size++;
    }

    @Override
    public void remove(int index) throws NotValidIndexException{
        Node<T> node = findNode(index);

        if(node == null){
            return;
        }

        if(size == 1){
            head = null;
            tail = null;
        } else if(node == head){
            head = node.next;
            if(head != null){
                head.previous = null;
            }
        } else if(node == tail){
            tail = node.previous;
            if(tail != null){
                tail.next = null;
            }
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        size--;
    }

    @Override
    public void removeAll(){
        head=null;
        tail=null;
        size=0;
    }

    @Override
    public T getAt(int index) throws NotValidIndexException{
        Node<T> node = findNode(index);

        return node == null ? null : node.data;
    }

    @Override
    public void setAt(int index,T data) throws NotValidIndexException, NotNullValuesAllowedException {
        if(data == null){
            throw new NotNullValuesAllowedException();
        }

        Node<T> node = findNode(index);

        if(node != null){
            node.data = data;
        }
    }

    private Node<T> findNode(int index) throws NotValidIndexException{
        if(index < 0 || index >= size){
            throw new NotValidIndexException(index); //throw recibe un parametro y recibe un objeto(por eso es new)
        }

        Node<T> node = head;
        int currentIndex = 0;

        while (currentIndex != index) {
            currentIndex++;
            node = node.next;
        }

        return node;
    }

    /*
    public void removeAllWithValue(T data){
    }*/

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public LinkedListIterator<T> getIterator(){
        //return  null;
        return new LinkedListIterator<>(head);
    }
}