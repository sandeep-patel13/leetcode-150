import java.util.*;

public class Bst {

    static int c = 0;
    static int lastData = Integer.MIN_VALUE;
    static Node pred = null , suc = null;
    static Node lca = null;
    static ArrayList<Integer> nodes = new ArrayList<>();
    static ArrayList<Node> nodesPre = new ArrayList<>();
    static ArrayList<Integer> nodesPreData = new ArrayList<>();
    static Node prev = null;

    public static void main(String[] args) {
        
        Node root = null;
        root = createBst(root);
        levelOrderTraversal(root);
        // root = deleteNode(root , 30);
        // levelOrderTraversal(root);
        int key = 70;
        // System.out.println(k+"th smallest element is : "+kthSmallestElementWay3(root , k));
        // getPredSucc(root , key);
        // System.out.println("pred : "+pred.data +" and suc : "+suc.data);

    }

    private static Node createBalancedBst(int s , int e) {
        if(s > e)
            return null;

        int mid = (s+e) / 2;
        Node root = new Node(nodes.get(mid));
        root.left = createBalancedBst(s, mid-1);
        root.right = createBalancedBst(mid+1, s);
        return root;
    }

    private static Node normalBstToBalancedBst(Node root) {
        getInorder(root);

        int s = 0 , e = nodes.size() - 1;

        return createBalancedBst(s , e);
    }

    private static void flattenBinaryTreeWay2(Node root) {

        // base case , agar root null hai to return ho jao
        if(root == null)
            return;

        // sabse pehle right subtree ko process kar de 
        flattenBinaryTreeWay2(root.right);

        // phir left subtree ko process kar de 
        flattenBinaryTreeWay2(root.left);
    
        // node ko process kar lo 
        root.left = null;
        root.right = prev;
        prev = root;
    }

    private static void flattenBinaryTreeWay3(Node root) {

        // stack bana lo 
        Stack<Node> stack = new Stack<>();

        // initially ek element to push karna hi padega 
        stack.push(root);

        // jab tak stack empty nahi hota 
        while(!stack.isEmpty()) {

            // ele pop kar 
            Node node = stack.pop();

            // right child , agar h to push kar de 
            if(node.right != null)
                stack.push(node.right);

            // left child , agar h to push kar de 
            if(node.left != null)
                stack.push(node.left);
            
            // now connect 
            if(!stack.isEmpty())
                node.right = stack.peek();


            // left - null 
            node.left = null;

        }

    }

    private static void getPreorder(Node root) {
        if(root == null)
            return;
        nodesPre.add(root);
        getPreorder(root.left);
        getPreorder(root.right);
    }

    private static void flattenBinaryTreeIntoList_UsingNodesAddress(Node root) {

        getPreorder(root);

        // travrse kar le 
        for(int i = 0 ; i < nodesPre.size() ; i++) {

            // left - null 
            nodesPre.get(i).left = null;

            // check 
            boolean x = ( (i+1) < nodesPre.size() );

            if(x == false)
                nodesPre.get(i).right = null;

            else 
                nodesPre.get(i).right = nodesPre.get(i+1);

        }

    }

    private static void getPreorderData(Node root) {
        if(root == null)
            return;

        nodesPreData.add(root.data);
        getPreorderData(root.left);
        getPreorderData(root.right);
    }

    private static void flattenBinaryTreeIntoList_UsingNodesData(Node root) {

        getPreorderData(root);

        Node prev = null;

        // bhai traverse kar le 
        for(int i = 0 ; i < nodesPreData.size() ; i++) {

            // create node 
            Node temp  = new Node(nodesPreData.get(i));
           
            // left - null 
            temp.left = null;
            
            // ye to root node banega 
            if(i == 0){
                root = temp;
                prev = temp;
                continue;
            }


            // agar ye pehla node nahi h 
            if(i != 0) {
                prev.right = temp;
            }

            // update prev 
            prev = temp;
        }

    }

    private static void findPairEqualTarget(Node root , int target) {

        // inorder nikaal le 
        getInorder(root);

        // ab ye saare nodes sorted manner me hai ,
        // to pair equal to target ka logic laga 
        int i = 0 , j = nodes.size() - 1;

        while((i >= 0 && j < nodes.size()) && (i < j)) {
            int a = nodes.get(i);
            int b = nodes.get(j);

            int sum = (a+b);

            if(sum == target) {
                System.out.println("pair exists....");
                return;
            }
            else if(sum < target)
                i++;
            else 
                j--;
        }
        System.out.println("Pair is not exist...");
    }

    private static void LCA(Node root , int n1 , int n2) {

        while(root != null) {

            if(n1 < root.data && n2 < root.data)
                root = root.left;
            else if(n1 > root.data && n2 > root.data)
                root = root.right;
            else {
                lca = root;
                return;
            } 
        }
            
    }

    private static void getPredSucc(Node root , int key) {
        Node temp = root;

        // predecessor
        while(temp != null) {
            if(temp.data == key)
                break;
            if(key < temp.data) 
                temp = temp.left;
            else {
                pred = temp;
                temp = temp.right;
            }
        }

        if(temp != null && temp.left != null) {
            Node t1 = temp.left;
            while(t1.right != null)
                t1 = t1.right;
            pred = t1;
        }

        // successor 
        temp = root;

        while(temp != null) {
            if(temp.data == key)
                break;
            if(key < temp.data) {
                suc = temp;
                temp = temp.left;
            }
            else 
                temp = temp.right;
        }

        if(temp != null && temp.right != null) {
            Node t1 = temp.right;
            while(t1.left != null)
                t1 = t1.left;
            suc = t1;
        }
    }

    private static Node createBst(Node temp1) {

        Scanner sc = new Scanner(System.in);
        
        while(true) {

            int data = sc.nextInt();

            if(data == -1) 
                break;

            temp1 = createBstUtil(temp1 , data);
            
        }

        return temp1;
    }

    private static Node createBstUtil(Node temp2 , int data) {

        // base case 
        if(temp2 == null) {
            return new Node(data);
        }
 
        if(data < temp2.data) 
            temp2.left = createBstUtil(temp2.left , data);

        if(data > temp2.data)
            temp2.right = createBstUtil(temp2.right, data);

        return temp2;
    }
    public static void levelOrderTraversal(Node root) {
    
        Queue<Node> q = new LinkedList<>();
    
        q.offer(root);
        q.offer(null);
    
        while(!q.isEmpty()) {
    
            Node temp = q.poll();
    
            if(temp == null) {
    
                // previoues level is printed so ek nayi line print kar de 
                System.out.println();
    
                // agar temp null hai , and queue empty nahi hai. 
                // iska matlab next level already queue me dal chuka h, to as a next level ending null daal do 
                if(!q.isEmpty())
                    q.offer(null);
    
            }
    
            else {
    
                System.out.print(temp.data+" ");
    
                if(temp.left!=null)
                    q.offer(temp.left);
    
                if(temp.right!=null)
                    q.offer(temp.right);
    
            }
        }
    
    }
    public static Node minNode(Node root) {
        if(root.left != null)
            return minNode(root.left);
        return root;
    }
    public static Node deleteNode(Node root, int x) {
        
        if(root == null)
            return root;

        if(root.data == x) {
            // 0
            if(root.left == null && root.right == null){
                System.out.println("root.data : "+root.data);
                return null;
            }

            // 1
            if(root.left!=null) {
                Node temp = root.left;
                root.left = null;
                return temp;
            }

            if(root.right != null) {
                Node temp = root.left;
                root.left = null;
                return temp;
            }
            
            // 2
            Node minNode = minNode(root.right);
            root.data = minNode.data;
            return deleteNode(root.right, minNode.data);
        }
        
        System.out.println("root.data : "+root.data);
        if(x < root.data)
            root.left = deleteNode(root.left, x);
        else 
            root.right = deleteNode(root.right, x);

        return root;
    }

    public static boolean validateBst(Node root) {

        // base case 
        if(root == null)
            return true;

        // LNR 

        boolean x = validateBst(root.left);


        if(root.data <= lastData)
            return false;

        lastData = root.data;

        boolean y = validateBst(root.right);

        return x && y;

    }

    public static boolean validateBstWay2(Node root, int min , int max) {
        if(root == null)
            return true;

        if(root.data > min && root.data < max) {
            boolean x = validateBstWay2(root.left, min, root.data);
            boolean y = validateBstWay2(root.right, root.data, max);
            return x && y;
        }

        return false;
    } 

    static void getInorder(Node root) {
        if(root == null)
            return;

        getInorder(root.left);
        nodes.add(root.data);
        getInorder(root.right);
    }

    public static int kthSmallestElement(Node root, int k) {
        getInorder(root);
        return nodes.get(k-1);
    }

    public static int kthSmallestElementWay2(Node root,  int k) {
        if(root == null) 
            return -1;

        // left recurison beta , chal bata tujhe answer mila 
        int left = kthSmallestElementWay2(root.left , k);

        // are wah bete tujhe to answer mil gaya 
        if(left != -1)
            return left;

        // nahi be tujhe answer nahi mila,
        // ruk ma check karta hoon 
        c++;
        if(c == k)
            return root.data;

        // merko bhi answer nahi mila yar,
        // chal koi ni,
        // right recursion tu bata tera kya h 
        return kthSmallestElementWay2(root.right , k);
    }

    public static int kthSmallestElementWay3(Node root , int k) {
        while(root != null) {
            if(root.left == null) {
                c++;
                if(c == k)
                    return root.data;
                root = root.right;
            }

            else {
                Node pred = root.left;
                while(pred.right != null && pred.right != root)
                    pred = pred.right;
                
                // kya link already bani hoi ha 
                if(pred.right != null) {
                    pred.right = null;
                    c++;
                    if(c == k)
                        return root.data;
                    root = root.right;
                }

                // agar link nahi bani h to bana de 
                else {
                    pred.right = root;
                    root = root.left;
                }
            }
        }
        return -1;
    }
}



class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

