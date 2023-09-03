import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LinkedListDS {

    Node head;
    Node tail;

    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }

    }

    public int size() {

        int count = 0;
        Node temp = head;
        while(temp != null) {

            count++;
            temp = temp.next;

        }

        return count;

    }

    public void insertAtHead(int data) {

        // LOGIC 
        // 1. create a node 
        // 2. point new node's next to node which is pointed by head 
        // 3. make head point to new node 


        Node temp = new Node(data);

        // ek chota sa check laga lo,
        // ek baar check kahi ye pehla node to nahi h,
        if(head == null) {
            tail = temp;
            head = temp;
            return;
        }

        temp.next = head;
        head = temp;


    }

    public void print() {

        // LOGIC 
        // 1. store head into temp 
        // 2. traverse and print each node untill temp becomes null 

        if(head == null) {
            System.out.print("no node exist");
            return;
        }

        Node temp = head;

        while(temp != null) {

            System.out.print(temp.data+" ");
            temp = temp.next;

        }
        System.out.println();

    }


    public void insertAtLast(int data) {

        // LOGIC 
        // 1. create node 
        // 2. point tail's next to new node 
        // 3. point tail to new node
        
        Node temp = new Node(data);

        // ek chota sa check laga lo,
        // ek baar check kahi ye pehla node to nahi h,
        // agar h to head ko bhi usi node se point karwa dena 
        if(head == null) {
            head = temp;
            tail = temp;
            return;
        }

        tail.next = temp;
        tail = temp;

    }


    public void insertAtPos(int data, int pos) {

        Node temp = new Node(data);

        if(pos == 1) {
            insertAtHead(data);
            return;
        }
        
        if(pos == this.size()) {
            insertAtLast(data);
            return;
        }

        Node prev = null , cur = head;
        for(int i = 0 ; i < pos-1 ; i++) {
            prev = cur;
            cur = cur.next;
        }

        prev.next = temp;
        temp.next = cur;
        return;

    }


    public void deleteAtPos(int pos) {

        if(pos == 1) {
            deleteAtFirst();
            return;
        }

        if(pos == this.size()) {
            deleteAtLast();
            return;
        }

        Node prev = null, cur = head;
        int i = 0;
        while(i < pos-1) {

            prev = cur;
            cur = cur.next;
            i++;

        }

        prev.next = cur.next;
        cur.next = null;
        return;

    }

    public void deleteAtFirst() {

        if(this.size() == 1) {

            head = tail = null;
            return;

        }

        Node headKaNext = head.next;
        head.next = null;
        head = headKaNext;

    }

    public void deleteAtLast() {

        if(this.size() == 1) {
            head = tail = null;
            return;
        }

        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }

        tail = temp;
        tail.next = null;

    }

    void findMiddleWay1() {

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

        }

        System.out.println(slow.data);

    } 

    void findMiddleWay2() {

        int size = this.size();
        int mid = size / 2;
        Node temp = head;
        for(int i = 0 ; i < mid ; i++) {
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    void findMiddleWay3(Node slow , Node fast) {

        if(fast == null || fast.next == null){
            System.out.println(slow.data);
            return;
        }

        findMiddleWay3(slow.next , fast.next.next);

    }

    void reverseLinkedList(Node cur , Node prev) {

        if(cur == null) {
            tail = head;
            head = prev;
            return;
        }
        
        // System.out.print(cur.data+" ");
        reverseLinkedList(cur.next , cur);
        cur.next = prev;

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

        if(head == null){
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

    void removeDuplicatesFromSortedLL() {

        if(head == null)
            return;
        
    	Node cur = head;
        while(cur.next != null) {
            
            
            if(cur.data == cur.next.data){
                
                Node further = cur.next.next;
                cur.next.next = null;
                cur.next = further;

            }
            
            else {
                
                cur = cur.next;
                
            }
            
        }

    }


    void removeDuplicatesFromUnSortedLL() {

        Node cur = null , temp = null , prev = null;

        cur = head;
        while(cur != null && cur.next != null) {
            // System.out.println(cur.data);
            
            temp = cur.next;
            prev = cur;
            while(temp != null) {

                if(temp.data == cur.data) {

                    prev.next = temp.next;
                    temp.next = null;
                    temp = prev.next;

                }
                else {

                    prev = temp;
                    temp = temp.next;

                }

            }

            cur = cur.next;


        }

    }

    void removeDuplicatesFromUnSortedLLWay2() {

        // sort 
        quickSortOnLL(head, tail);

        removeDuplicatesFromSortedLL();

    }


    void quickSortOnLL(Node start , Node end) {
        
        if(start == null  || end == null || start == end) {
            return;
        }

        Node pivot = partition(start , end);
        quickSortOnLL(start, pivot);
        quickSortOnLL(pivot.next, end);

    }

    Node partition(Node start , Node end) {

        // System.out.println(start.data+" "+end.data);
        Node pivot = start , prev = start , cur = start.next;
        
        while(cur != end.next) {

            if(pivot.data > cur.data) {

                // swap 
                int data = prev.next.data;
                prev.next.data = cur.data;
                cur.data = data;

                prev = prev.next;

            }

            cur = cur.next;

        }

        // prev is pointing to right node for pivot ele  
        // swap  
        int data = pivot.data;
        pivot.data = prev.data;
        prev.data = data;

        return prev;

    }


    void sort012() {

        Node temp = head;
        int[] counting = new int[3];

        // get count 
        while(temp != null){
            counting[temp.data]++;
            temp = temp.next;
        }

        System.out.println(Arrays.toString(counting));
        temp = head;
        int i = 0;
        while(i < counting.length) {

            int x = counting[i];

            int j = 0;
            while(j < x) {

                if(i == 0)
                    temp.data = 0;
                else if(i == 1)
                    temp.data = 1;
                else if(i == 2)
                    temp.data = 2;

                j++;
                temp = temp.next;

            }

            i++;

        }

    }


    void sort012Way2() {

        Node zeroHead = new Node(-1);
        Node zeroTail = zeroHead;

        Node oneHead = new Node(-1);
        Node oneTail = oneHead;

        Node twoHead = new Node(-1);
        Node twoTail = twoHead;


        Node cur = head;

        // SEPERATE 0s , 1s , 2s 
        while(cur != null) {

            if(cur.data == 0) {

                zeroTail.next = cur;
                zeroTail = cur;

            }
            else if(cur.data == 1) {

                oneTail.next = cur;
                oneTail = cur;

            }
            else if(cur.data == 2) {


                twoTail.next = cur;
                twoTail = cur;

            }

            cur = cur.next;

        }


        // merge 
        if(oneHead.next != null)
            zeroTail.next = oneHead.next;
        else 
            zeroTail.next = twoHead.next;
            
        oneTail.next = twoHead.next;
        twoTail.next = null;

        // shift head 
        head = zeroHead.next;

    }


    void merge2SortedLL(LinkedListDS first , LinkedListDS second , LinkedListDS answer) {

        Node temp1 = first.head;
        Node temp2 = second.head;

        while(temp1 != null && temp2 != null) {

            if(temp1.data < temp2.data) {
                answer.insertAtLast(temp1.data);
                temp1 = temp1.next;
            }
            else if(temp2.data < temp1.data) {
                answer.insertAtLast(temp2.data);
                temp2 = temp2.next;
            }
        
        }

        while(temp1 != null) {

            answer.insertAtLast(temp1.data);
            temp1 = temp1.next;

        }

        while(temp2 != null) {

            answer.insertAtLast(temp2.data);
            temp2 = temp2.next;

        }

        answer.insertAtLast(-1);

        return;

    }

    Node merge2SortedLLWay2Util(Node first , Node second) {

        
        Node c1 , n1 , c2 , n2;        
        c1 = first;
        n1 = first.next;
        c2 = second;
        n2 = second.next;
        
        // edge case , if first list has exactly one ele 
        if(n1 == null) {

            // just connect second list with first node of first list 
            c1.next = second;
            return first;

        }

        // jab tak n1 and c2 Range me hai , tab tak loop chalao
        while(c2 != null && n1 != null) {

            if(c2.data >= c1.data && c2.data <= n1.data) {

                c1.next = c2;
                n2 = c2.next;
                c2.next = n1;

                // update pointers 
                c1 = c1.next;
                c2 = n2;

            }

            else {

                // update window (c1 , n1)
                c1 = c1.next;
                n1 = n1.next;

                // n1 == null , first list is end 
                if(n1 == null) {

                    // connect remaining nodes of second list 
                    c1.next = c2;
                    return first;

                }

            }

        }

        return first;

    }

    Node merge2SortedLLWay2(Node first , Node second) {

        // return second list, if first list is null 
        if(first == null)
            return second;
        
        // return first list , if second list is null 
        if(second == null) 
            return first;

        // whose first node data is smaller , that list should be first list
        if(first.data < second.data) {

            return merge2SortedLLWay2Util(first , second);
            
        }   
        else {
            
            return merge2SortedLLWay2Util(second , first);

        }

    }


    void checkPalindrom() {

        // create array 
        ArrayList<Integer> arr = new ArrayList<>();

        // copy list data into arr 
        Node temp = head;

        // process all nodes 
        while(temp != null) {

            arr.add(temp.data);
            temp = temp.next;

        }

        System.out.println(arr);

        // logic of checking palindrom in arr 
        int start = 0 , end = arr.size() - 1;
        while(start < end) {

            if(arr.get(start) != arr.get(end)) {
                System.out.println("List is Not Palindrom");
                return;
            }
            start++;
            end--;
        }
        System.out.println("List is Palindrom");
        return;
    }

    void checkPalindromWay2() {


        // find middle 
        // note - i am taking slow from head but fast from head.next 
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse list from middle.next
        Node middle = slow;
        Node cur = middle.next;
        Node prev = null;
        Node forward = null;
        while(cur != null) {
            forward = cur.next;
            cur.next = prev;
            prev = cur;
            cur = forward;
        }

        // assign reverse list head node address into next of middle 
        middle.next = prev;

        // compare both the parts 
        Node first = head;
        Node second = middle.next;

        // both should be in range  
        while(first != middle.next && second != null){

            if(first.data == second.data) {
                first = first.next;
                second = second.next;
            }

            else {

                System.out.println("Not a Palindrome List");
                return;

            }

        }

        System.out.println("Palindrome List");
    }


    void addTwoNumbersReperesentedByLL(LinkedListDS first , LinkedListDS second) {

        Node temp = first.head;
        int number1 = 0, number2 = 0;
        int digit = 0;

        // create first number 
        while(temp != null) {
            digit = temp.data;
            number1 = number1 * 10 + digit;
            temp = temp.next;
        }

        // create second number
        temp = second.head;
        digit = 0;
        while(temp != null){
            digit = temp.data;
            number2 = number2 * 10 + digit;
            temp = temp.next;
        }


        // add them  
        int result = number1 + number2;

        // store result's digits into answer list 
        LinkedListDS answer = new LinkedListDS();
        while(result != 0) {

            int rem = result % 10;
            answer.insertAtHead(rem);
            result = result / 10;

        }
        
        // print final list 
        answer.print();

    }


    void addTwoNumbersReperesentedByLLWay2(LinkedListDS first , LinkedListDS second , LinkedListDS answer) {

        // 1. Reverse both lists 
        first.print();
        first.reverseLinkedList(first.head, null);
        first.print();
        second.print();
        second.reverseLinkedList(second.head, null);
        second.print();


        Node temp1 = first.head;
        Node temp2 = second.head;

        int carry = 0;

        // 2. traverse both list while being in range  
        while(temp1 != null && temp2 != null) {

            int val1 = temp1.data;
            int val2 = temp2.data;
            
            int sum = val1 + val2 + carry;

            int digit = sum % 10;

            carry = sum / 10;

            answer.insertAtHead(digit);
            temp1 = temp1.next;
            temp2 = temp2.next;

        }

        // 3. check for remaining node in first list 
        while(temp1 != null) {

            int val = temp1.data;
            int sum = val + carry;
            int digit = sum % 10;
            carry = sum / 10;
            answer.insertAtHead(digit);
            temp1 = temp1.next;
            System.out.println(val+" , "+carry);
            
        }

         // 3. check for remaining node in first list 
        while(temp2 != null) {

            int val = temp2.data;
            System.out.println(val+" , "+carry);
            int sum = val + carry;
            int digit = sum % 10;
            carry = sum / 10;
            answer.insertAtHead(digit);
            temp2 = temp2.next;
            
        }

        // 4. agar carry 0 nahi hoi hai 
        if(carry != 0) {

            answer.insertAtHead(carry);

        }
        
        System.out.println("//////////");
        answer.print();
    }
    
    Node mergeSortOnLL(Node head) {

        // base case 
        if(head == null || head.next == null) 
            return head;

        // find middle 
        Node slow = head , fast = head.next;
        while(fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

        }
        Node middle = slow;

        // pass left and right part to recursion , resursion will sort left and right part 
        Node left = head;
        Node right = middle.next;
        middle.next = null;

        left = mergeSortOnLL(left);
        right = mergeSortOnLL(right);
        head = merge2SortedLLWay2(left, right);
        return  head;

    }

    Node flatten(Node root)
    {
        
	   if(root == null || root.next == null)
	    return root;
	    
	   Node forward = root.next;
	   forward = flatten(forward);
	   root.next = null;
	   root = merge2SortedLLWay2(root , forward);
	   return root;
	   
    }    

    public static void main(String[] args) {
        
        // LinkedListDS list = new LinkedListDS();
        LinkedListDS first = new LinkedListDS();
        first.insertAtLast(0);
        first.insertAtLast(0);
        first.insertAtLast(2);
        first.insertAtLast(0);
        first.insertAtLast(10);
        first.insertAtLast(90);
        first.insertAtLast(34);
        first.insertAtLast(90);
        first.insertAtLast(90);
        first.insertAtLast(22);
        first.insertAtLast(90);
        // LinkedListDS second = new LinkedListDS();
        // second.insertAtLast(1);
        // second.insertAtLast(2);
        // second.insertAtLast(10);
        // second.insertAtLast(15);
        // first.head = first.merge2SortedLLWay2(first.head , second.head);
        // first.print();
        first.head = first.mergeSortOnLL(first.head);
        first.print();


    }
}
