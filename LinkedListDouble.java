package LInkedListDouble;

public class LinkedListDouble implements SimpleList{
    private  int size;
    class Node {

        Object data;
        Node prevouse;
        Node next;

        public Node(Object data){
            this.data = data;
            this.prevouse = null;
            this.next = null;


        }
    }


        private Node head;
        private  Node tial;
        LinkedListDouble(){
            this.head = null;
            this.tial = null;

        }
        public void add(Object item){
            int count = 0;

            Node newNode = new Node(item);
            if(head == null) {
                tial = head = newNode;
                head.prevouse = null;
                tial.next = null;

            }else {

                tial.next = newNode;
                newNode.prevouse = tial;
                tial = newNode;

            }

           size++;
        }

        void printNodes() {
            Node current = head;

            if(head == null){
                System.out.println("List is Empty");
                return;
            }

            System.out.print("List items::");
            while (current != null) {
                System.out.print(current.data+" ");
                current = current.next;
            }
            System.out.println();
        }

         public boolean isEmpty() {
            return head == null;
        }
         public int size() {
            return size;
         }

        public boolean contains(Object element){
            Node current = head;

            while (current != null) {
                if( current.data == element)
                    return true;
                current = current.next;

            }
            return false;
        }

   public Object get(int index){

            int count = 0;
            Node current = tial;

            if(index > (size/2)){

                index = size-index-1;

                while (count<index){

                    System.out.println(current.data);
                    current = current.prevouse;
                    count++;
                }


            }else {
                current = head;

                while (count < index) {

                current = current.next;
                count++;

                }
            }
            return current.data;
    }

  public   void remove(int index){
            int count = 0;
            Node current = head;
            Node temp;
            if(index == 0){
                head = head.next;
                return;
            }else if(size == (index+1)){
                tial = tial.prevouse;
                tial.next = null;
                return;
            }

            while (count < index)  {
                current = current.next;
                count++;
            }

            current.next.prevouse =  current.prevouse;
            current.prevouse.next = current.next;
    }

   public void insert(int index, Object element){
              Node newNode = new Node(element);
              Node current = head;
              Node temp;

              if(index == 0){
                  temp = head;
                  head = newNode;
                  newNode.prevouse = null;
                  newNode.next = temp;
                  temp.prevouse = newNode;
                  return;

              }else  if(index == (size-1)) {
                  temp = tial;
                  tial = newNode;
                  tial.next = null;
                  tial.prevouse = temp;
                  temp.next = tial;
                  return;

              }

              int count = 0;
              while (count < index)  {
                  current = current.next;
                  count++;
              }

              temp = current.next;
              current.next = newNode;
              newNode.prevouse= current;
              newNode.next = temp;
              temp.prevouse = newNode;

    }

}
 interface SimpleList {

    void add(Object element);

    void insert(int index, Object element);

    void remove(int index);

    Object get(int index);

    boolean contains(Object element);

    int size();

    boolean isEmpty();

}

class Main {
    public static void main(String[] args) {
        LinkedListDouble list = new LinkedListDouble();
        list.add(10);
        list.add(12);
        list.add(15);
        list.add(115);
        list.add(5);
        list.add(8);
        list.add(190);
        list.add(-74);

        list.printNodes();
       // System.out.println(list.get(0)+" ++++++++++");
        list.insert(7,2);
        list.printNodes();


    }

}
