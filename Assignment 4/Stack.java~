/*
 * Daniel Lee
 * Assignment 4
 * This contains the third problem
 */

public class Stack<T> {
    
    class Node {
        T val;
        Node next;
        Node(T val) { this.val = val; next = null; }
        public String toString() { return val+"";}
    }
    
    private Node top;
    private Node maxTop;
    public boolean isEmpty()
    {
       return top == null;
    }

    public void push(T v) 
    {
        if (top == null) 
        {
           top = new Node(v);
           maxTop = new Node(v);
           //System.out.println(maxTop);
           //System.out.println(maxTop.next);
           return;
        }
        else
        {
            Node t = new Node(v);
            t.next = top;
            top = t;
            if ((Integer) maxTop.val < (Integer) t.val)
            {
                Node x = t;
                x.next = maxTop;
                maxTop = t;
            }
            return;
        }
    }
    public T peek()
    {
       if (top == null) return null;
       return top.val;
    }

    public void pop()
    {
       if (top == null) return;
       Node t = top;
       if ((Integer) t.val == (Integer) maxTop.val)
       {
           Node x = maxTop;
           maxTop = maxTop.next;
           x.next = null;
       }
       //System.out.println(top.next);
       top = top.next;
       t.next = null;
       //System.out.println(t);
       //System.out.println(top);
    }

    public void show()
    {
       Node t = top;
       while (t != null)
       {
          System.out.print(t.val + " ");  
          t = t.next;
       }
       System.out.println();
    }
    
    public int max()
    {
        return (Integer) maxTop.val;
    }

    public static void main(String[] args)
    {
       Stack<Integer> s = new Stack<Integer>();
       s.push(1);
       s.push(2);
       s.push(4);
       s.push(3);
       s.show();
       System.out.println(s.max());
       s.pop();
       s.pop();
       System.out.println(s.max());
       //s.pop();
       //s.show();
       //s.pop();
       //s.show();
    }
}