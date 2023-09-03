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


    static Stack<Integer> sortAStack(Stack<Integer> stack) {

        // base case 
        if(stack.isEmpty() == true)
            return stack;
        
        // ab top ele nikaal lo 
        int x = stack.pop();


        // remaining ele ke saath stack ko recursion ko pass kar dena recursion stack ko sort kar dega 
        stack = sortAStack(stack);


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

    public static void main(String[] args) {
        
        // basic();
        // reverseAString("abcdefgh");
        Stack<Integer> s = new Stack<>();
        s.push(6);
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(10);
        s.push(1);
        // System.out.println(s.peek());
        // boolean ans = pairWiseConsecutive1(s);
        // System.out.println(ans);
        middleNodeInStack(s);

        // redundantBracket("(a * b + (a / b)(c))");

        // validParentheses("[[][]][][]");

        
    }
}
