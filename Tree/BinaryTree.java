import java.lang.reflect.Array;
import java.util.*;


class Node{

    int data;
    Node left;
    Node right;

    public Node(int d) {

        data = d;
        left = null;
        right = null;

    }

}

class Pair{

    int include;
    int exclude;

    public Pair(int x, int y) {
        include = x;
        exclude = y;
    }

}

class BinaryTree{

    static int preIndex = 0;
    static int postIndex = 0;
    static boolean ans = false;
    static TreeMap<Integer , ArrayList<Integer>> tm = new TreeMap<>(Collections.reverseOrder());
    static int count = 0;
    
    static void solveHasPathSum(Node root , int sum , int localSum) {
        // base case
        if(root == null){
            return;
        }
        
       if(root.left==null && root.right== null) {
           if(localSum == sum) {
               ans = true;
               return;
           }
       }

        if(root.left!=null)
            solveHasPathSum(root.left , sum , localSum+root.left.data);
        if(root.right!=null)
            solveHasPathSum(root.right , sum , localSum+root.right.data);
    }

    static boolean hasPathSum(Node root, int S) {

        solveHasPathSum(root , S , root.data);
        return ans;
        
    }

    static int search(int[] arr, int start , int end, int value) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }


    static Node builtTreeUsingInorderAndPostOrder(int[] inorder, int[] postorder , int start , int end, int n) {
        if(postIndex < 0 || start > end)
            return null;

        int data = postorder[postIndex--];
        Node root = new Node(data);
        int position = search(inorder, start, end, data);
        root.right = builtTreeUsingInorderAndPostOrder(inorder, postorder, position+1, end, n);
        root.left = builtTreeUsingInorderAndPostOrder(inorder, postorder, start, position-1, n);
        return root;

    } 
    
    static Node solve(int[] inorder, int[] preorder, int inStart, int inEnd, int n) {
        if(preIndex >= n || (inStart > inEnd))
            return null;

        Node node = new Node(preorder[preIndex++]);

        int inIndex = search(inorder, inStart, inEnd, node.data);

        node.left = solve(inorder, preorder, inStart, inIndex - 1, n);
        node.right = solve(inorder, preorder, inIndex + 1, inEnd, n);

        return node;
    }

    public static Node buildTree(Node tempRoot) {

        System.out.println("Enter data...");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        if(data == -1)
            return null;

        tempRoot = new Node(data);

        System.out.println("Enter data for left of "+data);
        tempRoot.left = buildTree(tempRoot.left);

        System.out.println("Enter data for right of "+data);
        tempRoot.right = buildTree(tempRoot.right);

        return tempRoot;

    }

    public static void preorderFor_RLOT(Node root , int level) {

        if(root == null)
            return;

        if(tm.containsKey(level) == true) {
            tm.get(level).add(root.data);
        }
        else {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(root.data);
            tm.put(level , al);
        }

        // LEFT 
        preorderFor_RLOT(root.left , level+1);

        // RIGHT 
        preorderFor_RLOT(root.right , level+1);

    }

    public static void reverseLevelOrderTraversal(Node root) {

        preorderFor_RLOT(root , 0);

        for(Map.Entry<Integer , ArrayList<Integer>> e : tm.entrySet()) {
            ArrayList<Integer> a = e.getValue();
            System.out.println(a);
        }

    }

    public static void levelOrderTraversal(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while(queue.isEmpty() == false) {

            Node temp = queue.poll();

            if(temp == null) {

                System.out.println();

                if(queue.isEmpty() == false) {

                    queue.offer(null);

                }

            }

            else {

                System.out.print(temp.data+" ");

                if(temp.left != null)
                    queue.offer(temp.left);

                if(temp.right != null)
                    queue.offer(temp.right);

            }

        }

    }


    public static void inorder(Node root) {

        if(root == null) 
            return;


        // LNR 
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);

    }

    public static void postorder(Node root) {

        if(root == null) 
            return;


        // LRN
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");

    }
    
    public static void preorder(Node root) {

        if(root == null) 
            return;


        // NLR
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);

    }

    public static void preorderIterative(Node root) {

        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        // jab tak stack khaali na , ho tab tak loop chalao
        while(!stack.isEmpty()) {

            // ek element ko nikaal lo 
            Node temp = stack.pop();

            tab tak loop chalao 
            while(temp != null) {
// jab tak temp null nahi hota 
                // print kar do  
                System.out.print(temp.data+" ");

                // temp ke right node ko stack me daal do 
                stack.push(temp.right);

                // come to left of temp 
                temp = temp.left;

            }

        }

    }

    public static void preorderIterativeWay2(Node root) {

        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();

        while(true) {


            while(root != null) {

                System.out.print(root.data+" ");
                stack.push(root.right);
                root = root.left;

            }

            if(stack.isEmpty()) return;

            else 
                root = stack.pop();

        }

    }

    public static void inorderIterative(Node root) {

        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();

        while(true) {

            while(root != null) {

                stack.push(root);
                root = root.left;

            }

            if(stack.isEmpty())
                return;

            else {

                root = stack.pop();
                System.out.print(root.data+" ");
                root = root.right;

            }

        }

    }

    public static Node buildTreeUsingLevelOrderTrav(Node root) {

        Queue<Node> queue = new LinkedList<>();
        System.out.println("Enter data for root node...");
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();

        root = new Node(d);

        queue.offer(root);


        while(queue.isEmpty() == false) {

            Node temp = queue.poll();

            System.out.println("Enter data for left of :"+temp.data);
            d = sc.nextInt();

            if(d != -1) {

                temp.left = new Node(d);
                queue.offer(temp.left);

            }

            System.out.println("Enter data for right of :"+temp.data);
            d = sc.nextInt();

            if(d != -1) {

                temp.right = new Node(d);
                queue.offer(temp.right);

            }

        }

        return root;

    }

    public void countLeafNodes(Node root) {

        if(root == null)
            return;

        if(root.left == null && root.right == null)
            count++;

        countLeafNodes(root.left);
        countLeafNodes(root.right);

    }
    
    public int countLeafNodesWay2(Node root) {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        return countLeafNodesWay2(root.left) + countLeafNodesWay2(root.right);
    }
 
    static int getMaxFromLeftSubTree(Node root) {
        
        if(root == null) 
            return Integer.MIN_VALUE;
            
        int x = getMaxFromLeftSubTree(root.left);
        int y = getMaxFromLeftSubTree(root.right);
        int z = Math.max(x , y);
        int ans = Math.max(z , root.data);
        return ans;
            
    }
    
    static int getMinFromRightSubTree(Node root) {
        
        if(root == null) 
            return Integer.MAX_VALUE;
            
        int x = getMinFromRightSubTree(root.left);
        int y = getMinFromRightSubTree(root.right);
        int z = Math.min(x , y);
        int ans = Math.min(z , root.data);
        return ans;
        
    }

    public static boolean isBST(Node root) {

        if(root == null)
            return true;

        int max = getMaxFromLeftSubTree(root.left);
        int min = getMinFromRightSubTree(root.right);
        
        boolean x = (root.data > max) && (root.data < min);

        if(x == false)
            return false;

        return (x) && (isBST(root.left)) && (isBST(root.right)); 

    }

    static void leftViewUtil(Node root , int level , ArrayList<Integer> ans) {

        // BASE CASE 
        if(root == null)
            return;

        // FOR THE VERY FIRST NODE IN EACH LEVEL 
        if(ans.size() == level) 
            ans.add(root.data);
            
        // LEFT RECURSION 
        leftViewUtil(root.left, level+1, ans);

        // RIGHT RECURSION
        leftViewUtil(root.right, level+1, ans);

        
    }

    static void leftViewMeth2(Node root) {

        ArrayList<Integer> al = new ArrayList<>();
        leftViewUtil(root , 0 , al);
        System.out.println(al);

    }

    static ArrayList<Integer> leftView(Node root)
    {

        ArrayList<Integer> al = new ArrayList<>();
        
        if(root == null)
            return al;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        
        while(!q.isEmpty()) {
            
            Node temp = q.poll();
            
            if(temp == null) {

                al.add(-1);
                
                if(!q.isEmpty())
                    q.offer(null);
                
            }
            
            else {
                
                al.add(temp.data);
                
                if(temp.left != null)
                    q.offer(temp.left);
                    
                if(temp.right != null)
                    q.offer(temp.right);
                
            }
            
        }

        // pick index 0 ele and all ele after -1
        ArrayList<Integer> ans = new ArrayList<>();
        
        // ek loop chalo aur check karo kya ye -1 hai...
        // agar hai to phir uske just next waala ele ko apne ans me include kar lo...
        for(int i = 0 ; i < al.size()-1 ; i++) {
            
            Integer data = al.get(i);
            
            if(data == -1) {
                
                ans.add(al.get(i+1));
                
            }
            
        }


        ans.add(0 , al.get(0));
        
        return ans;
    }

    static ArrayList<Integer> findSpiral(Node root) 
    {

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        s1.push(root);
        
        while( (!s1.isEmpty()) || (!s2.isEmpty()) ) {
            
            Node temp = null;
            
            while( (!s1.isEmpty()) ) {
                
                
                temp = s1.pop();
                
                ans.add(temp.data);
                
                if(temp.right != null)
                    s2.push(temp.right);
                    
                if(temp.left != null)
                    s2.push(temp.left);
                
            }
            
            while( (!s2.isEmpty()) ) {
                
                temp = s2.pop();
                
                ans.add(temp.data);
                
                if(temp.left != null)
                    s1.push(temp.left);
                    
                if(temp.right != null)
                    s1.push(temp.right);                
                
            }
            
        }

        return ans;

    }

    static Node LCA(Node root , int n1 , int n2) {

        if(root == null)
            return null;

        if(root.data == n1 || root.data == n2)
            return root;

        Node x = LCA(root.left , n1, n2);
        Node y = LCA(root.right, n1, n2);

        if(x != null && y != null)
            return root;
        else if(x != null && y == null)
            return x;
        else if(x == null && y != null)
            return y;
        else 
            return null;

    }

    static Pair maxSumFromNonAdjacent(Node root) {

        // basecase
        if(root == null)
            return new Pair(0, 0);

        // LEFT RECURSION 
        Pair leftPair = maxSumFromNonAdjacent(root.left);

        // RIGHT RECURSION 
        Pair rightPair = maxSumFromNonAdjacent(root.right);

        Pair ansPair = new Pair(0, 0);
        
        // INCLUDING CURRENT NODE DATA 
        ansPair.include = root.data + leftPair.exclude + rightPair.exclude;

        // EXCLUDING CURRENT NODE DATA 
        ansPair.exclude = Math.max(leftPair.include, leftPair.exclude) + Math.max(rightPair.include , rightPair.exclude);

        return ansPair;
    } 

    static ArrayList<Integer> inOrderUsingMorrisTraversal(Node root)
    {

        ArrayList<Integer> al = new ArrayList<>();

        while(root != null) {

            if(root.left == null) {
                al.add(root.data);
                root = root.right;
            }

            else {

                Node pred = root.left;

                while(pred.right != null && pred.right != root) 
                    pred = pred.right;

                if(pred.right == null) {
                    pred.right = root;
                    root = root.left;
                }

                else {
                    pred.right = null;
                    al.add(root.data);
                    root = root.right;
                }

            }

        }
        return al;
    }

    static ArrayList<Integer> preOrderUsingMorrisTraversal(Node root) {

        ArrayList<Integer> al = new ArrayList<>();

        while(root != null) {

            if(root.left == null) {
                al.add(root.data);
                root = root.right;
            }

            else {

                Node pred = root.left;

                while(pred.right != null && pred.right != root)
                    pred = pred.right;

                if(pred.right == null) {
                    al.add(root.data);
                    pred.right = root;
                    root = root.left;
                }

                else {
                    root.right = null;
                    root = root.right;
                }

            }

        }
        return al;
    }

    static void flattenBinaryTreeUsingMorrisTraversal(Node root) {

        Node cur = root;

        while(cur != null) {

            if(cur.left != null) {

                Node pred = cur.left;
                while(pred.right != null)
                    pred = pred.right;

                pred.right = cur.right;
                cur.right = cur.left;
                cur.left = null;

            }

            cur = cur.right;
        }
            
    }

    static boolean solveSymattricTree(Node root1 , Node root2) {
        if(root1 == null && root2 == null)
            return true;

       if(root1 != null && root2 != null && (root1.data == root2.data ))
        return solveSymattricTree(root1.left , root2.right) && solveSymattricTree(root1.right , root2.left);

      return false;

    }

    static public boolean symattricTree(Node root) {

        return solveSymattricTree(root , root);

    }

    static boolean symattricTreeWay2(Node root) {

        if(root == null)
            return true;

        Stack<Node> stack = new Stack<>();

        stack.push(root.left);
        stack.push(root.right);

        while(!stack.isEmpty()) {
            Node node1 = stack.pop();
            Node node2 = stack.pop();

            if(node1 == null && node2 == null)  
                continue;

            if(node1 == null || node2 == null)
                return false;

            if(node1.data != node2.data)
                return false;

            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);

        }
        return true;
    }

    public static void main(String[] args) {

        Node root = null;

        root = buildTree(root);

        reverseLevelOrderTraversal(root);

        // System.out.println(hasPathSum(root, 10));

        // root = buildTreeUsingLevelOrderTrav(root);

        // levelOrderTraversal(root);

        // inorder(root);
        // preorder(root);

        // System.out.println("___________________");
        // // postorder(root);
        // preorderIterative(root);
        // preorderIterativeWay2(root);
        // inorderIterative(root);

        // Pair p = maxSumFromNonAdjacent(root);
        // System.out.println(Math.max(p.exclude, p.include));

        // int[] inorder = {4 ,8 ,2 ,5 ,1 ,6 ,3 ,7};
        // int[] postorder = {8 ,4 ,5 ,2 ,6 ,7 ,3 ,1};
        // int n = 8;
        // postIndex = n-1;
        // // Node node = solve(inorder, preorder, 0, n-1, n);
        // Node node = builtTreeUsingInorderAndPostOrder(inorder, postorder, 0, n-1, n);
        // preorder(node);

        // ArrayList<Integer> al = inOrderUsingMorrisTraversal(root);
        // System.out.println(al);
    }

}