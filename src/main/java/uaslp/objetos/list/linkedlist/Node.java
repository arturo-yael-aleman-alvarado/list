package uaslp.objetos.list.linkedlist;

class Node <T> {
    T data; //Ya son package-private
    Node<T> next;
    Node<T> previous;

    Node(T data){
        this.data = data;
    }
}

