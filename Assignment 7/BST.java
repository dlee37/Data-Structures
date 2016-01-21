import java.util.Arrays;
public class BST<T extends Comparable<T>> {
    
    private Node root;
    
    public void insert(T v) {
        root = insert(root, v);
    }
    
    public static Node<Integer> makeTree1() //this creates trees because this is not a binary search tree
    {                                           
        Node<Integer> r = new Node<Integer>(5);
        Node<Integer> a = new Node<Integer>(7);
        Node<Integer> b = new Node<Integer>(12);
        Node<Integer> c = new Node<Integer>(4);
        Node<Integer> d = new Node<Integer>(2);
        Node<Integer> e = new Node<Integer>(6);
        Node<Integer> f = new Node<Integer>(20);
        Node<Integer> g = new Node<Integer>(15);
        Node<Integer> h = new Node<Integer>(6);
        Node<Integer> i = new Node<Integer>(7);
        Node<Integer> j = new Node<Integer>(52);
        Node<Integer> k = new Node<Integer>(45);
        Node<Integer> l = new Node<Integer>(8);
        Node<Integer> m = new Node<Integer>(46);
        Node<Integer> n = new Node<Integer>(30);

        r.left = a; 
        r.right = b; 

        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;

        c.left = g;
        c.right = h;
        d.left = i;
        d.right = j;
        e.left = k;
        e.right = l;
        f.left = m;
        f.right = n;

        return r;
    }
    
        public static Node<Integer> makeTree2() //this creates trees because this is not a binary search tree
    {                                           
        Node<Integer> r = new Node<Integer>(11);
        Node<Integer> a = new Node<Integer>(6);
        Node<Integer> b = new Node<Integer>(20);
        Node<Integer> c = new Node<Integer>(4);
        Node<Integer> d = new Node<Integer>(8);
        Node<Integer> e = new Node<Integer>(14);
        Node<Integer> f = new Node<Integer>(23);
        Node<Integer> g = new Node<Integer>(2);
        Node<Integer> h = new Node<Integer>(5);
        Node<Integer> i = new Node<Integer>(7);
        Node<Integer> j = new Node<Integer>(9);
        Node<Integer> k = new Node<Integer>(12);
        Node<Integer> l = new Node<Integer>(19);
        Node<Integer> m = new Node<Integer>(21);
        Node<Integer> n = new Node<Integer>(25);

        r.left = a; 
        r.right = b; 

        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;

        c.left = g;
        c.right = h;
        d.left = i;
        d.right = j;
        e.left = k;
        e.right = l;
        f.left = m;
        f.right = n;

        return r;
    }
    
    //for convenience, I used an indexing where only one value was used
    //instead of a key and a value inside of the key
    private Node insert(Node<T> x,T v) {
        if (x == null) return new Node(v);
        int cmp = v.compareTo(x.val);
        if (cmp < 0) x.left = insert(x.left, v);
        if (cmp > 0) x.right = insert(x.right, v);
        if (cmp == 0) return x;
        return x;
    }
    
    public static int[] inOrderArray(int[] a) {
        int[] x = a.clone();
        Arrays.sort(x);
        return x;
    }
    
    public static Node CreateTree(int[] a) {
        int prelength = a.length;
        int[] inorder = inOrderArray(a);
        //System.out.println(Arrays.toString(inorder));
        int inlength = inorder.length;
        return CreateTree(a,0,prelength-1,inorder,0,inlength-1);
    }
    
    public static Node CreateTree(int[] a, int preS, int preE, int[] inorder, int inS, int inE) {
        //if the preorder is not a valid preorder array, it will return an error
        if (inS > inE) return null;
        int rootValue = a[preS];
        int rootIndex = 0;
        for (int i = inS; i <= inE; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        int len = rootIndex - inS;
        Node r = new Node(rootValue);
        r.left = CreateTree(a, preS+1, preS+len, inorder, inS, rootIndex-1);
        r.right = CreateTree(a, preS+len+1, preE, inorder, rootIndex+1, inE);
        return r;
    }
    
    public static boolean isBST(Node a) {
        return isBST(a, -999999, 999999); //have some very low values of min and max for this to work
    }
    
    private static boolean isBST(Node a, int min, int max) {
        if (a == null) return true;
        if ((Integer) a.val > min && (Integer) a.val < max && isBST(a.left, min, (Integer) a.val)
                && isBST(a.right, (Integer) a.val, max)) {
            return true;
        }
        else return false;
    }
    
    public static boolean isBalanced(Node a) {
        int lSide = height(a.left);
        int rSide = height(a.right);
        if (Math.abs(lSide-rSide) == 1) return true;
        if (Math.abs(lSide-rSide) == 0) return true;
        return false;
    }
    
    public static void preOrder(Node a) {
        if (a == null) return;
        System.out.print(a.val + " ");
        preOrder(a.left);
        preOrder(a.right);
    }
    
    public static void inOrder(Node a) {
        if (a == null) return;
        inOrder(a.left);
        System.out.print(a.val + " ");
        inOrder(a.right);
    }
    
    public static int height(Node a) {
        if (a == null) return 0;
        else {
            return 1 + Math.max(height(a.left), height(a.right));
        }
    }
    
    public Node root() {
        return root;
    }
    
    public static void main(String[] args) {
        BST a = new BST<Integer>();
        Node x = a.root();
        a.insert(5);
        a.insert(10);
        x = a.root();
        a.insert(20);
        x = a.root();
        a.insert(4);
        a.insert(6);
        x = a.root();
        a.insert(2);
        a.insert(32);
        a.insert(32);
        a.insert(35);
        x = a.root();
        preOrder(x);
        System.out.println();
        inOrder(x);
        System.out.println();
        System.out.println(isBalanced(x));
        int[] y = {5,2,1,4,7,6,20};
        Node b = CreateTree(y);
        Node c = makeTree1();
        int[] z = {11,6,4,2,5,8,7,9,20,14,12,19,23,21,25};
        int[] w = {1,2,3,4,5,6,7};
        Node f = CreateTree(w);
        Node e = CreateTree(z);
        System.out.println(isBST(f));
        System.out.println(isBST(x));
        System.out.println(isBST(b));
        System.out.println(isBST(c));
        System.out.println(isBalanced(f));
        preOrder(b);
        System.out.println();
        inOrder(b);
        System.out.println();
        preOrder(e);
        System.out.println();
        inOrder(e);
        System.out.println();
        Node d = makeTree2();
        System.out.println(isBST(d));
    }
}

class Node<T> {
    
    Node left;
    Node right;
    T val;
    Node(T val)
    {
        this.val = val;
        left = null;
        right = null;
    }
    public String toString()
    {
        return val+"";
    }
}