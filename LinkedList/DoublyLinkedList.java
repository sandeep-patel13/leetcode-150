
public class DoublyLinkedList {

    Node head;
    Node tail;

    class Node {

        Node prev;
        int data;
        Node next;

        Node(int data) {

            this.data = data;
            prev = null;
            next = null;

        }

    }

    public void insertAtBegning(int data) {

        Node temp = new Node(data);

        if(head == null) {
            head = tail =  temp;
            return;
        }

        temp.next = head;
        head.prev = temp;
        head = temp;

    }


    public void insertAtLast(int data) {

        Node temp = new Node(data);

        if(head  == null) {

            head = tail = temp;
            return;

        }

        tail.next = temp;
        temp.prev = tail;
        tail = temp;

    }


    public int size() {

        Node temp = head;
        int count = 0;

        while(temp != null) {

            count++;
            temp = temp.next;

        }

        return count;

    }

    public void insertAtPos(int data, int pos) {

        Node temp = new Node(data);

        if(pos == this.size()) {

            insertAtLast(data);
            return;

        } 
        
        if(pos == 1) {

            insertAtBegning(data);
            return;

        } 


        Node cur = head;
        Node cur1 = null;

        int i = 0;

        while(i < pos - 1) {
            cur = cur.next;
            i++;
        }

        cur1 = cur.next;

        cur.next = temp;
        temp.prev = cur;
        temp.next = cur1;
        cur1.prev = temp;
    }

    public void deleteAtPos(int pos) {


        if(pos == 1) {
            deleteAtBegning();
            return;
        }

        if(pos == this.size()){
            deleteAtLast();
            return;
        }


        Node cur = head , curKaPrev = null , curKaNext = null;

        int i = 0;

        while(i < pos-1) {
            cur = cur.next;
            i++;
        }

        curKaPrev = cur.prev;
        curKaNext = cur.next;

        curKaPrev.next = curKaNext;
        cur.prev = null;
        cur.next = null;
        curKaNext.prev = curKaPrev;
        return;
            
    }

    public void deleteAtBegning() {

        if(head.next == null) {
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev.next = null;
        head.prev = null;

    }

    public void deleteAtLast() {

        Node temp = head;

        if(head.next == null) {
            head = tail = null;
            return;
        }

        while(temp.next.next != null) {

            temp = temp.next;

        }

        tail.prev = null;
        tail = temp;
        tail.next = null;

    }

    public void print() {

        if(head == null) {
            System.out.println("no node exist");
            return;
        }

        Node temp = head;
        while(temp != null) {

            System.out.print(temp.data+" ");
            temp = temp.next;
                
        }
        System.out.println();
    }


    void reverseDLL(Node cur , Node prev , Node curKaNext) {

        if(cur == null) 
        {
            head = prev;
            return;
        }
        
        if(cur.next == null) 
            reverseDLL(cur.next , cur , null);
        else 
            reverseDLL(cur.next , cur , cur.next.next);


        cur.next = prev;
        cur.prev = curKaNext;
        if(cur.next == null) {
            tail = cur;
        }
        return;

    }    

    void removeDuplicatesFromSortedDLL() {

        if(head == null) {
            // System.out.println("empty list");
            return;
        }

        Node temp = null , temp1 = null , further = null;
        int data = 0;
        
        temp = head;
        while(temp.next != null) {

            if(temp.next.data != temp.data) {

                temp = temp.next;
                
            }

            else if(temp.next.data == temp.data) {

                data = temp.data;
                temp1 = temp.next;
                
                while(temp1.next != null && temp1.next.data == data) {

                    further = temp1.next;
                    temp1.next = null;
                    temp1.prev = null;
                    temp1 = further;
                    
                }

                temp.next = temp1.next;
                temp1.next = null;
                temp1.prev = temp;
                
            }
            
        }

    }

    public static void main(String[] args) {

        DoublyLinkedList dlist = new DoublyLinkedList();
        // dlist.insertAtBegning(1);
        // dlist.insertAtBegning(2);
        // dlist.insertAtBegning(2);
        // dlist.insertAtBegning(2);
        // dlist.insertAtBegning(3);
        // dlist.insertAtBegning(50);
        // dlist.insertAtBegning(50);
        dlist.insertAtLast(1);
        dlist.insertAtLast(2);
        dlist.insertAtLast(2);
        dlist.insertAtLast(2);
        dlist.insertAtLast(3);
        // dlist.insertAtLast(50);

        dlist.print();
        dlist.removeDuplicatesFromSortedDLL();
        dlist.print();
        // dlist.reverseDLL(dlist.head, null, dlist.head.next);
        // dlist.print();
        // System.out.println(dlist.head.data+" "+dlist.tail.data);

        // // dlist.insertAtPos(60, 1);

        // dlist.deleteAtPos(2);
        // dlist.print();

        // dlist.deleteAtBegning();
        // dlist.print();
        
        // dlist.deleteAtLast();
        // dlist.print();
    } 
}
