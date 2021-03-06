public class BinaryTree
{
    //private TreeNode root;
    private int length;
    
    //return the root of the entire tree
    public static TreeNode<Integer> makeTree1() //this creates trees because this is not a binary search tree
    {                                           //thus there is no easy way to create just binary tree
        TreeNode<Integer> r = new TreeNode<Integer>(5);
        TreeNode<Integer> a = new TreeNode<Integer>(7);
        TreeNode<Integer> b = new TreeNode<Integer>(12);
        TreeNode<Integer> c = new TreeNode<Integer>(4);
        TreeNode<Integer> d = new TreeNode<Integer>(2);
        TreeNode<Integer> e = new TreeNode<Integer>(6);
        TreeNode<Integer> f = new TreeNode<Integer>(20);
        TreeNode<Integer> g = new TreeNode<Integer>(15);
        TreeNode<Integer> h = new TreeNode<Integer>(6);
        TreeNode<Integer> i = new TreeNode<Integer>(7);
        TreeNode<Integer> j = new TreeNode<Integer>(52);
        TreeNode<Integer> k = new TreeNode<Integer>(45);
        TreeNode<Integer> l = new TreeNode<Integer>(8);
        TreeNode<Integer> m = new TreeNode<Integer>(46);
        TreeNode<Integer> n = new TreeNode<Integer>(30);

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
    
    //also returns the root of this particular tree
    public static TreeNode<Integer> makeTree2()
    {
        TreeNode<Integer> r = new TreeNode<Integer>(5);
        TreeNode<Integer> a = new TreeNode<Integer>(7);
        TreeNode<Integer> b = new TreeNode<Integer>(12);
        TreeNode<Integer> c = new TreeNode<Integer>(4);
        TreeNode<Integer> d = new TreeNode<Integer>(2);
        TreeNode<Integer> e = new TreeNode<Integer>(6);
        TreeNode<Integer> f = new TreeNode<Integer>(20);
        TreeNode<Integer> g = new TreeNode<Integer>(15);
        TreeNode<Integer> h = new TreeNode<Integer>(6);
        TreeNode<Integer> i = new TreeNode<Integer>(7);
        TreeNode<Integer> j = new TreeNode<Integer>(52);
        TreeNode<Integer> k = new TreeNode<Integer>(45);
        TreeNode<Integer> l = new TreeNode<Integer>(8);
        TreeNode<Integer> m = new TreeNode<Integer>(46);
        TreeNode<Integer> n = new TreeNode<Integer>(30);

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
    
    public static int maximum(TreeNode a) //always assume for this functions there are only integer values
    {
        int max = (Integer) a.val;
        if (a.left != null)
        {
            max = Math.max(max,maximum(a.left));
        }
        if (a.right != null)
        {
            max = Math.max(max, maximum(a.right));
        }
        return max;
    }
                   
    public static void flip(TreeNode a)
    {
        TreeNode temp = a.left;
        a.left = a.right;
        a.right = temp;
        
        if (a.left != null)
        {
            flip(a.left);
        }
        
        if (a.right != null)
        {
            flip(a.right);
        }
    }
    
    public static int height(TreeNode a)
    {
        if (a == null) return 0;
        else
        {
            return 1 + Math.max(height(a.left), height(a.right));
        }
    }
    
    public static boolean sameTree(TreeNode a, TreeNode b)
    {
        if (a == b)
        {
            return true;
        }
        if (a == null || b == null) return false;
        return (a.val == b.val && sameTree(a.left, b.left) && sameTree(a.right, b.right));
    }
    
    public static void preOrder(TreeNode a)
    {
        if (a == null) return;
        System.out.print(a.val + " ");
        preOrder(a.left);
        preOrder(a.right);
    }
    
    public static void inOrder(TreeNode a)
    {
        if (a == null) return;
        inOrder(a.left);
        System.out.print(a.val + " ");
        inOrder(a.right);
    }
    
    public static void main(String[] args)
    {
        TreeNode x = makeTree1();
        TreeNode y = makeTree2();
        System.out.println(maximum(x));
        System.out.println(sameTree(x,y));
        inOrder(x);
        System.out.println(""); System.out.println("");
        preOrder(x);
        System.out.println(""); System.out.println("");
        TreeNode z = x;
        flip(z);
        inOrder(z);
        System.out.println(""); System.out.println("");
        preOrder(z);
        System.out.println(); 
        System.out.println(height(x));
    }
}