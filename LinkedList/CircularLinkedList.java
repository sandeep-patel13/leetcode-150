import java.util.HashSet;
public class CircularLinkedList {

    Node head , tail , head1 , head2 , tail1 , tail2;

    class Node {

        int data;
        Node next;

        Node(int data) {

            this.data = data;
            next = null;

        }

    }

    public void insertAtBegning(int data) {

        Node temp = new Node(data);

        if(head == null) {
            head = tail = temp;
            temp.next = temp;
            return;
        }
        
        temp.next = head;
        tail.next = temp;
        head = temp;
        
    }
    
    public void insertAtLast(int data) {
        
        Node temp = new Node(data);

        if(head == null) {
            head = tail = temp;
            temp.next = temp;
            return;
        }

        tail.next = temp;
        temp.next = head;
        tail = temp;
        
    }

    public void print() {

        if(head == null) {
            System.out.println("no node exist");
            return;
        }

        Node temp = head;
        do{

            System.out.print(temp.data+" ");
            temp = temp.next;

        }while(temp != head);
        System.out.println();

    }

    public int size() {

        if(head == null) 
            return 0;
        
        int count = 0;
        Node temp = head;
        do{

            count++;
            temp = temp.next;

        }while(temp != head);

        return count;

    }

    public void insertAtPos(int pos, int data) {

        if(pos == 1) {
            insertAtBegning(data);
            return;
        }

        if(pos == this.size()) {
            insertAtLast(data);
            return;
        }

        Node temp = new Node(data);
        int i = 0;
        Node p1 = head, p2 = null;
        while(i < pos-2) {
            p1 = p1.next;
            i++;
        }
        p2 = p1.next;
        p1.next = temp;
        temp.next = p2;

    }

    public void deleteAtFirst() {

        if(head.next == head){
            head = tail = null;
            return;
        }

        Node temp = head;
        head = head.next;
        temp.next = null;
        tail.next = head;

    }

    public void deleteAtLast() {

        if(head.next == head){
            head = tail = null;
            return;
        }

        int i = 0;
        int size = this.size();
        Node temp = head;
        while(i < size - 2) {

            temp = temp.next;
            i++;

        }

        temp.next = tail.next;
        tail = temp;

    }

    public void deleteAtPos(int pos) {

        if(pos == 1) {
            this.deleteAtFirst();
            return;
        }

        if(pos == this.size()) {
            this.deleteAtLast();
            return;
        }

        Node prev = null;
        int i = 0;
        Node temp = head;
        while(i < pos-1) {
            prev = temp;
            temp = temp.next;
            i++;
        }
        prev.next = temp.next;
        temp.next = null;

    } 

    void checkCircularList() {

        if(head == null){
            System.out.println("circular....");
            return;
        }
        
        Node temp = head;

        while(temp.next != null && temp.next != head) {
            temp = temp.next;
        }

        if(temp.next == null){
            System.out.println("not circular....");
            return;
        }
        System.out.println("circular...");

    }

    void checkCircularListWay2() {

        if(head == null) {
            System.out.println("circular....");
            return;
        }

        Node temp = head;
        HashSet<Integer> set = new HashSet<>();
        while(temp != null) {

            if(set.contains(temp.data)){
                System.out.println("circular....");
                return;
            }

            set.add(temp.data);
            temp = temp.next;
        }

        System.out.println("not circular....");

    }

    public void detectCycle() {


        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                System.out.println("Loop exist....");
            }
            
        }
        
        System.out.println("Loop doesn't exist....");

    }

    void getFirstNodeOfCycle() {

        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {

                // assign head to slow
                slow = head;

                // jab tak slow fast ke == nahi ho jata 
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }

                // starting node data 
                System.out.println(slow.data);

            }
        }

        System.out.println("-1");
    }

    void removeLoopFromLinkedList() {

        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {

                // assign head to slow
                slow = head;

                // jab tak slow fast ke == nahi ho jata 
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }

                // starting node data 
                Node startingNode = slow;

                Node temp = startingNode.next;

                while(temp.next != startingNode) 
                    temp = temp.next;

                temp.next = null;

            }
        }

        System.out.println("-1");

    }


    void split() {

        Node slow  = null , fast = null;

        slow = head ; fast = head;

        // find middle node 
        do{

            slow = slow.next;
            fast = fast.next.next;

        }while(fast != head && fast.next != head);

        // now slow is pointing to middle node
        
        // create second list 
        head2 = slow.next;
        tail2 = tail;
        tail2.next = head2;
        
        // create first list 
        head1 = head; slow.next = head;
        tail1 = slow; 
        

    }

    public static void main(String[] args) {
        
        CircularLinkedList clist = new CircularLinkedList();
        clist.insertAtBegning(10);
        clist.insertAtBegning(20);
        // clist.insertAtBegning(30);
        // clist.insertAtBegning(40);
        // clist.insertAtBegning(50);
        // clist.insertAtBegning(60);
        // clist.insertAtBegning(60);
        // clist.insertAtLast(1000);
        clist.print();
        // System.out.println(clist.size());
        // clist.insertAtPos(5, 2000);
        // while(clist.size() != 0)
        //     clist.deleteAtFirst();
        // clist.deleteAtLast();
        // clist.deleteAtPos(clist.size());
        // clist.print();
        // clist.checkCircularList();
        // clist.checkCircularListWay2();

        // clist.split();
        // Node temp = clist.head1;
        // do {
        //     System.out.print(temp.data+" | ");
        //     temp = temp.next;
        // }while(temp != clist.head1);

        // System.out.println();

        // temp = clist.head2;
        // do {
        //     System.out.print(temp.data+" | ");
        //     temp = temp.next;
        // }while(temp != clist.head2);

    }
}
