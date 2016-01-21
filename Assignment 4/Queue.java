public class Queue<T> {

    class Node {
        T val;
        Node next;
        Node(T val) { this.val = val; next = null; }
    }

    private Node front;
    private Node back;

    public void enqueue(T v)
    {
        if (back == null) 
        {
           back = new Node(v);
           front = back;
           return;
        }

       Node t = new Node(v);
       back.next = t;
       back = t;
    } 

    public T front()
    {
       if (front == null) return null;
       return front.val;
    }

    public void dequeue()
    {
       if (front == null) return;
       Node f = front;
       front = front.next;
       if (isEmpty())
          back = null;
       f.next = null;
    }

    public boolean isEmpty()
    {
       return (front == null);
    }

    public void show()
    {
       Node t = front;
       while (t != null)
       {
          System.out.print(t.val + " ");  
          t = t.next;
       }
       System.out.println();
    }

    public static void main(String[] args)
    {
       Queue<Integer> q = new Queue<Integer>();
       q.enqueue(1);
       q.enqueue(2);
       q.enqueue(3);
       q.show();
       System.out.println(q.front());
       q.dequeue();
       q.dequeue();
       q.show();
       q.dequeue();
       q.show();
    }
}