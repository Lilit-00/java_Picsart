package LinkedListSiple;

public class Node {
    Object value;
    //  Node previous;
    Node next;
    Node(Object value){
        this.next = null;
        this.value = value;

    }
}

class LinkedList {

    public Node head;
    private int size = 0;
    LinkedList(){
        this.head = null;
    }

    public void add(int value) {

        Node newNode = new Node(value);

        if(head == null){
            head = newNode;
            size = 1;
            return;
        }

        Node current = head;//skzbic stugelov gn um e

        while (current.next != null){
            current = current.next;
        }

        current.next = newNode;
        size++;

    }
    int size(){
        return this.size;
    }

    Object get(int index){
        if(index >= size || size == 0) {
            throw  new IndexOutOfBoundsException();
        }

        Node current = head;
        int count = 0;

        while (count != index){
            current=current.next;
            count++;
        }

        return current.value;

    }


    public void display(){

        if(isEmpty()) System.out.println("Is Empty");

        Node current = head;
        System.out.print("[");
        while (current != null){
            System.out.print(current.value +" -> ");
            current= current.next;


        }
        System.out.println("null ]");
    }
    boolean isEmpty(){
        return head == null;
    }
    void insert(int index, Object element){

        Node newNode = new Node(element);
        Node current = head;
        int count = 0;
        while (count != (index-1)){
            current=current.next;
            count++;
        }
        Node temp = current.next;
        current.next = newNode;
        newNode.next = temp;

    }
    void remove(int index){

        Node current = head;
        int count = 0;

        while (count != (index-1)){
            current=current.next;
            count++;
        }
        Node temp = current.next.next;
        current.next = temp;


    }


}

class Main{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(-10);
        list.add(8);
        list.add(2);
        list.add(21);
        list.add(67);
        list.add(3);
        list.add(4);
        list.display();
        list.remove(2);
        list.display();

    }
}
