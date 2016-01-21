/*
 * Daniel Lee
 * Assignment 5
 */

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length = 0;
    
    public void pushBack(T v)
    {
        if (head == null)
        {
            head = new Node<T>(v);
            tail = head;
            length++;
            return;
        }
        
        Node<T> x = new Node<T>(v);
        tail.next = x;
        tail = x;
        length++;
    }
    
    public void pushFront(T v)
    {
        if (head == null)
        {
            head = new Node<T>(v);
            tail = head;
            return;
        }
        
        Node<T> x = new Node<T>(v);
        x.next = head;
        head = x;
        length++;
    }
    
    public void insert(int n, T v)
        //inserts a node at that particular index
    {
        if (head == null)
        {
            head = new Node<T>(v);
            tail = head;
            length++;
            return;
        }
        
        Node<T> t = head;
        int i = 0;
        while (t != null && i != n-1)
        {
            t = t.next;
            i++;
        }
        
        Node<T> x = new Node<T>(v);
        if (t == null)
        {
            x.next = head;
            head = x;
            //tail.next = x;
            //tail = x;
        }
        else {
            Node<T> y = t.next;
            t.next = x;
            x.next = y;
        }
        length++;
    }
    
    public void insertAfter(int n, T v)
    {
        if (head == null)
        {
            head = new Node<T>(v);
            tail = head;
            length++;
            return;
        }
        
        Node<T> t = head;
        int i = 0;
        // {I: t is ith node}
        while (t != null && i != n)
        {
            t = t.next;
            i = i + 1;
        }
        
        Node<T> x = new Node<T>(v);
        if (t == null) { 
            tail.next = x;
            tail = x;
        }
        else {
            Node<T> y = t.next;
            t.next = x;
            x.next = y;
        }
        length++;
    }   
    
    
    public void remove(int n)
    {
        if (head == null)
        {
            return;
        }
        
        if (n == 0) {
            head = head.next;
            if (head == null) tail = null;
            length--;
            return;
        }
        
        Node<T> a = head;
        Node<T> b = head.next;
        int i = 1;
        // {I: b is ith node, a is the (i-1)th node}
        while (b != null && i != n)
        {
            a = a.next;
            b = b.next;
            i = i + 1;
        }
        
        if (b != null) { a.next = b.next; }
        if (b == tail) a = tail; 
        length--;
    }
    
    public T get(int n)
    {
        Node<T> t = head;
        int i = 0;
        // {I: t is ith node}
        while (t != null && i != n)
        {
            t = t.next;
            i = i + 1;
        }
        
        return t.v;  
    }
    
    public Node getNode(int n)
    {
        Node<T> t = head;
        int i = 0;
        while (t != null && i != n)
        {
            t = t.next;
            i++;
        }
        return t;
    }
    
    public void print()
    {
        Node<T> t = head;
        // {I: nodes before t have heen printed}
        while (t != null)
        {
            System.out.print(t + "->");
            t = t.next;
        }
        System.out.println("null");
    }
    

    public Node<T> first()
    {
        return head;
    }
    
    public Node<T> last()
    {
        return tail;
    }
    
    public int length()
    {
        return length;
    }
    
    public static void reverse(Node a) {
        if (a == null) return;
        if (a.next == null) {
            Node head = a; 
            return;
        }
        reverse(a.next);
        a.next.next = a;
        a.next = null;
    }
    
    public static void swap(LinkedList a, int i, int j)
       {
           Integer x = (Integer) a.get(i);
           Integer y = (Integer) a.get(j);
           a.insert(i,y);
           a.remove(i+1);
           //a.print();
           a.insert(j,x);
           //a.print();
           a.remove(j+1);
           //a.print();
       }
    
    
    public static int partition(LinkedList a, int first, int last)
    {
        int n = (int)(Math.random() * (last-first+1)) + first;
        swap(a, first, n); 
            
        int i = first+1;
        int j = last;
        // {I: a[first+1,i) <= a[first], a(j..last] > a[first]}
        while ( i <= j )
        {
            if ((Integer) a.get(i) <= (Integer) a.get(first)) 
                ++i;
            else 
            {
                swap(a, i, j);
                //a.print();
                --j;
            }
        }
        swap(a, first, j);
        return j;
    }
    
    
    public static void quickSort(LinkedList a, int first, int last)
    {
        if (first >= last) return;
        int k = partition(a, first, last);
        quickSort(a, first, k-1);
        quickSort(a, k+1, last);
    }
    
    public static void quickSort(LinkedList a)
    {
        quickSort(a, 0, a.length()-1);
    }
    
    public static void main(String[] args)
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        //list.print();
        LinkedList<Integer> a = new LinkedList<Integer>();
        a.pushBack(1);
        a.pushBack(3);
        a.pushBack(4);
        a.pushBack(6);
        a.pushBack(2);
        a.pushFront(10);
        //a.remove(1);
        //a.print();
        //a.print();
        //a.print();
        quickSort(a);
        a.print();
        reverse(a.first());
        a.print();
    }
}

class Node<T> 
{
    T v;
    Node<T> next;
    //Node<T> previous;
    public Node(T v) { this.v = v; next = null;}
    public String toString() { return v+""; }
}