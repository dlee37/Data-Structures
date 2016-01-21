/*
 * Daniel Lee
 * Assignment 4
 * Contains the first two problems
 */

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    public void pushBack(T v)
    {
        if (head == null)
        {
            head = new Node<T>(v);
            tail = head;
            return;
        }
        
        Node<T> x = new Node<T>(v);
        tail.next = x;
        tail = x;
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
    }
    
    public void insertAfter(int n, T v)
    {
        if (head == null)
        {
            head = new Node<T>(v);
            tail = head;
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
            tail = x;x
          }
        else {
            Node<T> y = t.next;
            t.next = x;
            x.next = y;
        }
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
    
    public static LinkedList<Integer> NodeMerge(Node a, Node b)
    {
        //this is assumed that a and b start at the beginning of the linked list
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        System.out.println(a.next);
        while (a != null || b != null)
        {
            //System.out.println(a);
            //System.out.println(b);
            int x = (Integer) a.v;
            int y = (Integer) b.v;
            if (x > y)
            {
                list.pushBack(y);
                //list.print();
                b = b.next;
                if (b == null) break;
            }
            else if (y > x)
            {
                list.pushBack(x);
                //list.print();
                a = a.next;
                if (a == null) break;
            }
            else if (x == y)
            {
                list.pushBack(x);
                list.pushBack(y);
                //list.print();
                a = a.next;
                b = b.next;
                if (a == null || b == null) break;
            }
            //System.out.println(a == null);
            //System.out.println(b == null);
        }
        
        if (b != null)
        {
            while (b != null)
            {
                int x = (Integer) b.v;
                list.pushBack(x);
                //list.print();
                b = b.next;
            }
        }
        else if (a != null)
        {
            while (a != null)
            {
                int x = (Integer) a.v;
                list.pushBack(x);
                //list.print();
                a = a.next;
            }
        }
        return list;
    }
    
    public static Node reverse(Node a)
    {
        //assumed that a is the head of the linked list
        
        if (a == null || a.next == null) return a;
        Node second = a.next;
        Node third = second.next;
        second.next = a;
        a.next = null;
        if (third == null) 
        {
            return a;
        }
        Node current = third;
        Node previous = second;
        while (current != null)
        {
            Node x = current.next;
            current.next = previous;
            previous = current;
            current = x;
        }
        a = previous;
        return a;
    }
    
    public static boolean Palindrome(Node a)
    {
        //assumed that a is the head of the linked list
        
        Node Reverse = reverse(a);
        Node b = a;
        while (b != null)
        {
            if (Reverse.v == b.v)
            {
                Reverse = Reverse.next;
                b = b.next;
            }
            else if (Reverse.v != b.v)
            {
                return false;
            }
        }
        return true;
    }
    
    public Node<T> first()
    {
        return head;
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
        a.pushBack(5);
        a.pushBack(6);
        a.pushBack(7);
        a.print();
        //a.print();
        Node<Integer> l = list.first();
        //System.out.println(l);
        Node<Integer> b = a.first();
        //System.out.println(b);
        LinkedList<Integer> x = NodeMerge(l,b);
        x.print();
        System.out.println(Palindrome(b));
    }
}

class Node<T> 
{
    T v;
    Node<T> next;
    public Node(T v) { this.v = v; next = null;}
    public String toString() { return v+""; }
}