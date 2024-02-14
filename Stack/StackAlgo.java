import java.util.*;

public class StackAlgo {

    static boolean ans = true;

    static void basic() {
        Stack<Integer> s1 = new Stack<>();
        s1.push(10);
        s1.push(20);
        s1.push(30);
        System.out.println(s1.size());
        while(!s1.isEmpty()) {

            System.out.println(s1.pop());

        }

        System.out.println(s1.isEmpty());
        System.out.println(s1.size());
    }

    static void reverseAString(String string) {

        Stack<Character> s = new Stack<>();

        // traverse String 
        for(int i = 0 ; i < string.length() ; i++) {
            s.push(string.charAt(i));
        }

        string = "";

        // traverse stack 
        while(!s.isEmpty()) {

            string = string + s.pop();

        }

        System.out.println(string);

    }

    static void validParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++) {

            Character ch = s.charAt(i);

            // agar ch ek openeing bracket h to, use stack me daalo 
            if(ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);

            // agar vo ek closing h 
            else {

                // check karo ki kahi stack to empty nahi h 
                if(stack.isEmpty() == true){
                    System.out.println("NOT VALID....");
                    return;
                }
                
                // agar nahi , to kya ch ke liye opening h 
                if( (ch == ')' && stack.peek() == '(') || 
                    (ch == ']' && stack.peek() == '[') || 
                    (ch == '}' && stack.peek() == '{')
                ) {
                    stack.pop();
                }

                // agar corresponding openeing nahi mili to 
                else {
                    System.out.println("NOT VALID...");
                    return;
                }

            }

        }

        if(stack.isEmpty() == true) {
            System.out.println("VALID....");
        }
        else {
            System.out.println("NOT VALID...");
        }

    }

    static Stack<Integer> insertInSortedManner(Stack<Integer> stack , int x) {

        // agar stack empty hai 
        // to x ko stack me push kar dena aur phir is stack ko return kar dena 
        if(stack.isEmpty()) {
            stack.push(x);
            return stack;
        }

        // agar stack me top ele x se small hai tab bhi same steps perform karna h 
        if(x > stack.peek()) {
            stack.push(x);
            return stack;
        }

        // otherwise 
        // pop the ele 
        int y = stack.pop();
        stack = insertInSortedManner(stack , x);
        stack.push(y);
        return stack;

    }


    static Stack<Integer> sortAStack(Stack<Integer> s) {

        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        // traverse s 
        while(!s.isEmpty()) {

            // cur ele 
            int poped = s.pop();

            if(s2.empty())
                s2.push(poped);

            else if(poped >= s2.peek())
                s2.push(poped);

           else {

                while( (s2.isEmpty() == false) && (poped < s2.peek()) ) {

                    s3.push(s2.pop());

                }

               s2.push(poped);
               while(!s3.isEmpty())
                    s2.push(s3.pop());

           }

        }
        
        return s2;

    }

    static Stack<Integer> sortAStackWay2(Stack<Integer> stack) {

        // base case 
        if(stack.isEmpty() == true)
            return stack;
        
        // ab top ele nikaal lo 
        int x = stack.pop();


        // remaining ele ke saath stack ko recursion ko pass kar dena recursion stack ko sort kar dega 
        stack = sortAStackWay2(stack);


        // ab x ko bhi sorted way me insert kar dena 
        stack = insertInSortedManner(stack , x);

        return stack;

    }

    static void redundantBracket(String s) {

        Stack<Character> stack = new Stack<>();

        // traverse String 
        for(int i = 0 ; i < s.length() ; i++) {

            // ger character 
            char ch = s.charAt(i);

            // check if it openeing bracket or any operator 
            if(ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                stack.push(ch);

            }

            // aur agar ch ek closing bracket hai to 
            // check karo ki () , is pair me minimum ek operator h ya nahi 
            else if(ch == ')') {

                // () , is pair of bracket me minimum ek character to hona chahiye tabhi ye useless pair nahi hoga
                char ch1 = stack.pop();

                if(ch1 == '+' || ch1 == '-' || ch1 == '*' || ch1 == '/') {

                    // so till now all is well , so pop all ele till opening bracket (
                    while( '(' != stack.peek() ) {
                        stack.pop();
                    }

                    // pop (
                    stack.pop();

                }

                else {

                    System.out.println("CONTAINS REDUNDANT PAIR....");
                    return ;
                    
                }
                
            }
            
        }
        
        
        System.out.println("DOSEN'T CONTAINS REDUNDANT PAIR....");


    }

    static void immediateSmallerWay1(int[] arr) {

        // traverse arr 
        for( int i = 0 ; i < arr.length ; i++) {

            // check 
            if((i+1) != arr.length && arr[i] > arr[i+1]) {
                arr[i] = arr[i+1];
            }
            else{
                arr[i] = -1;
            }

        }

        System.out.println(Arrays.toString(arr));

    }

    static int[] immediateSmallerWay2(int[] arr , int index) {

        // base case  
        if(index == arr.length-1) {
            arr[index] = -1;
            return arr;
        }

        if(arr[index] > arr[index+1]) {
            arr[index] = arr[index+1];
            index = index + 1;
        }
        else {
            arr[index] = -1;
            index = index + 1;
        }
        return immediateSmallerWay2(arr , index);
        
    }


    static void immediateSmallerWay3(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int index = 0;

        // arr to stack 
        for(int i = arr.length-1 ; i >= 0 ; i--) {
            stack.push(arr[i]);
        }

        // jab tak stack empty nahi hota 
        while(stack.isEmpty() == false) {

            int poped = stack.pop();

            // if, now stack size is 0 
            if(stack.size() == 0) {
                arr[index] = -1;
                index++;
                break;
            }

            int peeked = stack.peek();

            if(poped > peeked) {
                arr[index] = peeked;
                index++;
            }
            else {
                arr[index] = -1;
                index++;
            }

        }

        System.out.println(Arrays.toString(arr));

    }


    static int[] immediateSmallerWay4(int []arr , int index , Stack<Integer> stack) {

        // base case 
        if(stack.size() == 1) {

            arr[index] = -1;
            return arr;

        }

        int poped = stack.pop();
        int peeked = stack.peek();
        if(poped > peeked)
            arr[index] = peeked;
        else 
            arr[index] = -1;

        return immediateSmallerWay4(arr , index + 1 , stack);

    }


    static boolean pairWiseConsecutive(Stack<Integer> stack) {

        // for saving original content make temp stack 
        Stack<Integer> temp = new Stack<>();

        boolean ans = true;

        int size = stack.size();

        // odd 
        if(size % 2 != 0) {
            temp.push(stack.pop());
        }


        while(stack.isEmpty() == false) {

            // pop top two ele 
            Integer i = stack.pop();
            Integer j = stack.pop();

            temp.push(i);
            temp.push(j);

            if(Math.abs(i - j) != 1) {
                ans = false;
                break;
            }

        }


        while(temp.isEmpty() == false) {
            stack.push(temp.pop());
        }

        System.out.println(stack);
        return ans;
    }

    static Stack<Integer> solve(Stack<Integer> stack) {

        // base case 
        if(stack.isEmpty()) {
            return stack;
        }

        // pop top two ele 
        int i = stack.pop();
        int j = stack.pop();

        if(Math.abs(i - j) != 1) {
            ans = false;
        }

        // wapas se sahi bhi kar do array ko 
        stack.push(j);  
        stack.push(i);
        return stack;

    }

    static boolean pairWiseConsecutive1(Stack<Integer>st) {

        int size = st.size();
        
        if(size == 1){
            return true;
        }
        
        // check 
        if(size % 2 == 0) {
            st = solve(st);
        }
        else {
            int x = st.pop();
            st = solve(st);
            st.push(x);
        }
        
        while(st.isEmpty() == false) {
            System.out.print(st.pop()+" ");
        }
        return ans;

    }

    static void middleNodeInStack(Stack<Integer> stack) {

        // ek temp stack banao 
        Stack<Integer> temp = new Stack<>();

        int size = stack.size();

        int x = (size) / 2;

        // stack to temp 
        for(int i = 0 ; i < x ; i++) {
            
            temp.push(stack.pop());
            
        }
        
        // delete now 
        stack.pop();
        
        // temp to stack 
        while(temp.isEmpty() == false) {
            stack.push(temp.pop());
        }

        while(stack.isEmpty() == false) {

            System.out.print(stack.pop()+" ");

        }

        return;

    }

    static void nextSmallerElementWay2(ArrayList<Integer> arr) {

        // create stack 
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        // create ans 
        ArrayList<Integer> ans = new ArrayList<>();

        // process ele from right to left 
        for(int i = arr.size() - 1 ; i >= 0 ; i--) {

            // current ele 
            int cur = arr.get(i);

            if(stack.peek() < cur) {
                ans.add(stack.peek());
                stack.push(cur);
            }
            else {


                // pop ele till you don't get stack.peek < cur  
                while(stack.peek() >= cur) {

                    stack.pop();

                }

                // once smaller ele get then 
                ans.add(stack.peek());
                stack.push(cur);

            }

        }

        Collections.reverse(arr);
        System.out.println(ans);

    }


    static void prevSmallerElementWay2(ArrayList<Integer> heights) {

        // stack 
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        // ans 
        ArrayList<Integer> ans = new ArrayList<>();

        // loop on heights from left to right 
        for(int i = 0 ; i < heights.size() ; i++) {

            // cur value 
            int cur = heights.get(i);

            while( stack.peek() >= cur )
                stack.pop();

            // store stack.peek() in ans 
            ans.add(stack.peek());
            stack.push(cur);

        }
        System.out.println(ans);
        return;
    }

    static void celebrityProblemWay1(int M[][], int n)
    {
        
    // 	create knows and known array 
        int[] knows = new int[n];
        int[] known = new int[n];
        
        Arrays.fill(knows , 0);
        Arrays.fill(known , 0);
        
        // traverse matrix 
        for(int i = 0 ; i < n ; i++) {
            
            for(int j = 0 ; j < M[i].length ; j++) {
                
                // check for value 1 
                if(M[i][j] == 1) {
                    
                    // it means that ith person knows to jth person,
                    // and jth person is known by someone
                    knows[i]++;
                    known[j]++;
                    
                }
            
            }
            
        }
    	
    // 	find , who knows to all person and known by noone
        for(int i = 0 ; i < n ; i++) {
            
            int x = knows[i];
            int y = known[i];
            if(x == 0 && y == n-1){
                System.out.println(i + "th person is celebrity....");
            }
            
        }
        System.out.println("no one is celebrity....");
    }


    static void celebrityProblemWay2(int M[][], int n) {

        // loop on M
        for(int i = 0 ; i < M.length ; i++) {

            boolean rowFlag = true;
            boolean colFlag = true;

            // traverse ith row and ith col
            for(int j = 0 ; j < M[i].length ; j++) {

                // ignore daigonal 
                if(i == j)
                    continue;

                if(rowFlag == true && M[i][j] == 1) {

                    rowFlag = false;

                }
                if(colFlag == true && M[j][i] == 0) {

                    colFlag = false;

                }

            }


            if(rowFlag == true && colFlag == true)
                System.out.println(i+" th person is celebrity....");

        }

        System.out.println("no one is celebrity....");

    }

    static boolean knows(int[][] M , int a , int b) {
        if(M[a][b] == 1) {
            return true;
        }
        else 
            return false;
    }

    static void celebrityProblemWay3(int M[][], int n) {

        Stack<Integer> stack = new Stack<>();

        // put all ele in stack 
        for( int i = 0 ; i < M.length ; i++ ) {

            stack.push(i);

        }

        // jab tak stack size > 1 
        while(stack.size() > 1) {

            // pop two ele 
            int a = stack.peek();
            stack.pop();

            int b = stack.peek();
            stack.pop();

            // kya a b ko jaanta hai 
            if(knows(M , a , b))
                stack.push(b);
            
            // kya b a ko jaanta h 
            if(knows(M , b , a)) 
                stack.push(a);

        }

        // potentiall celebrity 
        int celebrity = stack.peek();

        int zeroCount = 0;
        int oneCount = 0;

        // celebritie's whole row should contain 0
        for(int i = 0 ; i < M[celebrity].length ; i++) {

            if(M[celebrity][i] == 0)    
                zeroCount++;

        }

        // celebritie's whole column should contain 1
        for(int i = 0 ; i < M.length ; i++) {

            if(M[celebrity][i] == 1)    
                oneCount++;

        }

        // zeroCount should be n and oneCount should be n-1
        if(zeroCount == n && oneCount == n-1)
            System.out.println(celebrity+" is celebrity....");
        else 
            System.out.println("no one is celebrity....");

    }

    // #Incompelte 
    // static void maxRactangle(int[][] M) {


    


    // } 

    // #Incompelte 
    // static void LargestRectangleArea(int[][] M) {


    


    // } 
    
    static void deleteElement(int[] arr , int k) {

        // answer arraylist 
        ArrayList<Integer> al = new ArrayList<>();

        // stack 
        Stack<Integer> s = new Stack<>();

        s.push(arr[0]);

        int count = 0;

        // traverse all elemets 
        for(int i = 1 ; i < arr.length ; i++) {

            while(!s.isEmpty() && arr[i] > s.peek() && count < k) {
                s.pop();
                count++;
            }

            s.push(arr[i]);

        }

        // now store answer elements into al 
        while(!s.isEmpty())
            al.add(0, s.pop());

        System.out.println(al);
    }

    static void getMaximumElementFromstackWay1(Stack<Integer> s) {

        Stack<Integer> temp = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();

        // s to temp 
        while(!s.isEmpty()) {

            al.add(s.peek());
            temp.push(s.peek());
            s.pop();
            
        }

        // sort 
        Collections.sort(al);

        // temp to s 
        while(!temp.isEmpty()) 
            s.push(temp.pop());

        System.out.println("max : "+al.get(al.size() - 1));
    }

    static int getMaximumElementFromstackWay2(Stack<Integer> s) {

        // base case 
        if(s.empty())
            return -1;
        if(s.size() == 1)
            return s.peek();

        // get top 
        int poped = s.pop();

        // pass remaing elements stack to recursion that will return a min ele 
        int max = getMaximumElementFromstackWay2(s);

        // compare 
        int ans = Math.max(poped , max);

        // backtrack
        s.push(poped);

        return ans;

    }


    public static void validSubString(String str) {

        // stack 
        Stack<Integer> stack = new Stack<>();

        // store all invalid paranthisis in stack 
        for(int i = 0 ; i < str.length() ; i++) {

            // get char 
            char ch = str.charAt(i);

            // openeing 
            if(ch == '(')
                stack.push(i);

            // closing 
            else if(ch == ')') {

                // valid paranthisis
                if( (!stack.isEmpty()) && (str.charAt(stack.peek()) == ')' )) {

                    stack.pop();

                } 

                // invalid paranthisis
                else {

                    // store invalid paranthisis
                    stack.push(i);

                }


            }

        } 


        // now process all invalid paranthisis
        // get difference 
        int max = 0 ; 
        int x = str.length();

        while(!stack.isEmpty()) {

            // get top invalid paranthisis index 
            int top = stack.pop();

            // get maximum 
            max = Math.max(max , x - top - 1);

            // update x for next top invalid paranthisis
            x = top;

        }

        System.out.println(Math.max(max , x));

    }

    public static void insertAtBottom(Stack<Integer> s , int top) {

        // base case 
        if(s.isEmpty() == true) {
            s.push(top);
            return;
        }

        int x = s.pop();
        insertAtBottom(s , top);
        s.push(x);

    }


    public static void reverseAStack(Stack<Integer> s) {

        // base case
        if(s.isEmpty() || s.size() == 1)
            return;

        // top ele nikaal lo 
        int ele = s.pop();

        // baaki ke stack ko recursion reverse kar dega 
        reverseAStack(s);

        // and after recursion hume bhi ele ko reverse karna hai 
        insertAtBottom(s , ele);

    }

    public static void main(String[] args) {
        
        // basic();
        // // reverseAString("abcdefgh");
        Stack<Integer> s = new Stack<>();
        s.push(60);
        s.push(5);
        s.push(-10);
        // s.push(5);
        // s.push(4);
        s.push(10);
        s.push(1);
        s.push(100);
        System.out.println(s);
        reverseAStack(s);
        System.out.println(s);
        
        // s.push(2);
        // s.push(3);
        // System.out.println(getMaximumElementFromstackWay2(s));
        // System.out.println(s);
        // s = sortAStack(s);
        // System.out.println(s);
        // System.out.println(s.peek());
        // boolean ans = pairWiseConsecutive1(s);
        // System.out.println(ans);
        // middleNodeInStack(s);

        // ArrayList<Integer> al = new ArrayList<>();
        // al.add(2);
        // al.add(1);
        // al.add(4);
        // al.add(3);
        // prevSmallerElementWay2(al);

        
        // redundantBracket("(a * b + (a / b)(c))");

        // validParentheses("[[][]][][]");

        
    }
}
