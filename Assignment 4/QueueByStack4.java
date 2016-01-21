/*
 * Daniel Lee
 * Assignment 4
 * This contains problem #4
 */

import java.util.Arrays;
public class QueueByStack4<T> extends Stack
{
    
    private Stack<T> a;
    private Stack<T> b;
    
    public QueueByStack4() {
        a = new Stack<T>();
        b = new Stack<T>();
    }
    
    private void move()
    {
        while(!a.isEmpty())
        {
            T v = a.peek();
            b.push(v);
            a.pop();
        }
    }
    
    public void enqueue(T v)
    {
        a.push(v);
    }
    
    public T front() {
        if ( b.isEmpty() )
            move();
        return b.peek();
    }
    
    public void dequeue()
    {
        //System.out.println(a.peek());
        //assert ((Integer) a.peek() == (Integer) m.peek());
        if ( b.isEmpty() )
            move();
        b.pop();
    }
    
    public boolean isEmpty()
    {
        return a.isEmpty() && b.isEmpty();
    }
    
    public void print()
    {
        while( !isEmpty() )
        {
            System.out.print(front() + " ");
            dequeue();
        }
    }
    
    public int max()
    {
        return (Integer) a.max();
    }
    
    public static Stack slidingWindow(int[] a, int winLength)
    {
        Stack<Integer> ans = new Stack<Integer>();
        for (int i = 0; i < a.length - winLength + 1;i++)
        {
            int z = 0;
            int[] j = Arrays.copyOfRange(a,i,i+winLength);
            System.out.println(Arrays.toString(j));
            for (int k = 0; k < winLength; k++)
            {
                if (j[k] > z)
                {
                    z = j[k];
                }
                if (k + 1 >= winLength)
                {
                    System.out.println(z);
                    ans.push(z);
                }
            }
        }
        return ans;
    }
    
    public static void main(String[] args)
    {
        QueueByStack<Integer> q = new QueueByStack<Integer>();
        q.enqueue(7);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(1);
        //System.out.println(q.max());
        //q.print();
        //q.dequeue();
        //System.out.println(q.max());
        int[] x = {2,7,3,4,1};
        Stack y = slidingWindow(x,3);
        y.show(); //the stack will show in reverse sorry about this. 
//           q.dequeue();
//           q.dequeue();
//           q.enqueue(4);
//           q.enqueue(5);
//           q.enqueue(6);
//           q.print();

       }
}