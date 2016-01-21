/*
 * Daniel Lee
 * Assignment 4
 * This contains #5
 */

public class QueueByStack5<T> extends Queue{
       private Stack<T> a;
       private Stack<T> b;
       
       public QueueByStack5() {
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
       
       public static Queue slidingWindow(int[] a, int winLength)
       {
           Stack<Integer> x = new Stack<Integer>();
           Queue<Integer> maxStack = new QueueByStack<Integer>();
           for (int i = 0; i < a.length - winLength + 1;i++)
           {
               int[] j = Arrays.copyOfRange(a,i,i+winLength);
               for (int item:j)
               {
                   x.push(item);
               }
            maxStack.push(x.max());
           }
           return maxStack;
       }
       
       public static void main(String[] args)
       {
           QueueByStack<Integer> q = new QueueByStack<Integer>();
           q.enqueue(1);
           q.enqueue(2);
           q.enqueue(3);
           q.dequeue();
           q.dequeue();
           q.enqueue(4);
           q.enqueue(5);
           q.enqueue(6);
           q.print();

       }
}