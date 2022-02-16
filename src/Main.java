import uaslp.objetos.list.linkedlist.LinkedList;
import uaslp.objetos.list.linkedlist.LinkedListIterator;

public class Main {
    public static void main(String[] args) { //Escritura rapida psvm
        LinkedList team1 = new LinkedList();
        LinkedList team2 = new LinkedList();
        LinkedList team3 = new LinkedList();

        team1.addAtTail("Jesús");
        team1.addAtTail("Salomón");
        team1.addAtTail("Arturo");

        team2.addAtTail("Cristían");
        team2.addAtTail("Daniel");
        team2.addAtTail("Diego");

        team3.addAtTail("Imelda");

        LinkedListIterator iterator;
        iterator = team1.getIterator();

        while (iterator.hasNext()){
            String name = iterator.next();
            System.out.println(name);
        }

    }
}
