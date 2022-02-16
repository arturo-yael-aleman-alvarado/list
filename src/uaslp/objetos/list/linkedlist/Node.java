package uaslp.objetos.list.linkedlist;

import javax.naming.NameNotFoundException;

class Node{
        String data; //Ya son package-private
        Node next;
        Node previous;

        Node(String data){
                this.data = data;
        }
}
