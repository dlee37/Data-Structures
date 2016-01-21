import java.util.Arrays;
public class Sort {

       public static void swap(int[] a, int i, int j)
       {
           int t = a[i];
           a[i] = a[j];
           a[j] = t;
       }

       public static void selectionSort(int[] a)
       {
          for (int i = 0; i < a.length; ++i)
          {
              int minv = a[i];
              int k = i; 
              for (int j = i; j < a.length; ++j)
              {
                  if (a[j] < minv) { minv = a[j]; k = j; }
              }
              swap(a, i, k);
          }
       } 

       public static int[] length(int[] a)
       {
           int[] l = new int[a.length];
           
           for (int i = 0; i < a.length; i++)
           {
               l[i] = i;
               System.out.println(l[i]);
           }
           return l;
       }
       
       public static void insertionSort(int[] a)
       {
           int i = 1;
           // {I: a[0..i) has been sorted}
           while (i != a.length)
           {
               // Insert a[i] to a[0..i) so that a[0..i] is sorted
               int j = i;
               // {I: j is the location of the inserted element}
               // {!B: j == 0 || a[j] >= a[j-1]} 
               while ( (j != 0) && (a[j] < a[j-1]) )
               {
                  swap(a, j, j-1);
                  --j;
               }
               ++i;
           }  
       }     

       // merge sorted arrays in a[p..m] and a[m+1,q] into a[p..q]
       public static void merge(int[] a, int[] l, int p, int m, int q)
       {
           int[] b = new int[q-p+1];
           int[] c = new int[q-p+1];
           int i = p;
           int j = m+1;
           int k = 0;
           // {I: a[p,i) and b[m+1,j) has been merged into array b[0..k)}
           while ( i != (m+1) || j != (q+1) )
           {
               if (i == (m+1))
               {  
                   b[k] = a[j];
                   c[k] = l[j];
                   ++j; ++k;
                   continue;
               }

               if (j == (q+1))
               {  
                   b[k] = a[i];
                   c[k] = l[i];
                   ++i; ++k;
                   continue;
               }

               if (a[i] < a[j])
               {
                   b[k] = a[i];
                   c[k] = l[i];
                   ++i; ++k;
               } 
               else {
                   b[k] = a[j];
                   c[k] = l[j];
                   ++j; ++k;
               }
           }

           for (int n = 0; n < b.length; ++n)
           {
              a[n+p] = b[n];
              l[n+p] = c[n];
           }
           System.out.println(Arrays.toString(l));
       }
                 
                    

       public static void mergeSort(int[] a, int[] l, int first, int last)
       {
           if (first >= last) return;
           int m = (first + last) / 2;
           mergeSort(a, l, first, m);
           mergeSort(a, l, m+1, last);
           merge(a, l, first, m, last);
       } 

       public static void mergeSort(int[] a, int[] l)
       {
           //int[] l = length(a);
           mergeSort(a, l, 0, a.length-1);
       }
       
       
       public static int partition(int[] a, int first, int last)
       {
           int n = (int)(Math.random() * (last-first+1)) + first;
           swap(a, first, n); 
            
           int i = first+1;
           int j = last;
           // {I: a[first+1,i) <= a[first], a(j..last] > a[first]}
           while ( i <= j )
           {
               if (a[i] <= a[first]) 
                    ++i;
               else {
                   swap(a, i, j);
                   --j;
               }
           }
           swap(a, first, j);
           return j;
       }

                            
       public static void quickSort(int[] a, int first, int last)
       {
          if (first >= last) return;
          int k = partition(a, first, last);
          quickSort(a, first, k-1);
          quickSort(a, k+1, last);
       }

       public static void quickSort(int[] a)
       {
          quickSort(a, 0, a.length-1);
       }


       /*class Pair {
             int first;
             int second;
             public Pair(int f, int s) { first = f; second = s;}
       }*/

       public static Pair partition2(int[] a, int first, int last)
       {
           int n = (int)(Math.random() * (last-first+1)) + first;
           swap(a, first, n);

           int i = first+1;
           int k = i;
           int j = last;
           // {I: a[first+1,i) < a[first], a[i,k) == a[first], a(j..last] > a[first]}
           while ( k <= j )
           {
               if (a[k] == a[first])
                   ++k;
               else if (a[k] < a[first])
               {
                   swap(a, i, k);
                   ++i; ++k;
               } else {
                   swap(a, k, j);
                   --j;
               }
           }

           swap(a, first, i-1);
           return (new Pair(i-1, j));
       }

       public static void quickSort2(int[] a, int first, int last)
       {
          if (first >= last) return;
          Pair k = partition2(a, first, last);
          quickSort2(a, first, k.first-1);
          quickSort2(a, k.second+1, last);
       }

       public static void quickSort2(int[] a)
       {
          quickSort2(a, 0, a.length-1);
       }

       public static void show(int[] a)
       {
          for (int e: a)
            System.out.print(e + " ");
          System.out.println();
       }

       public static void main(String[] args)
       {
           int[] a = {10,3,6,4,5};
           int[] l = length(a);
           System.out.println(Arrays.toString(l));
           //System.out.println(Arrays.toString(a));
           mergeSort(a,l);
           System.out.println(Arrays.toString(l));
//           int[] a = new int[1000000];
//           for (int i = 0; i < a.length; ++i)
//               a[i] = (int)(Math.random() * 100000);
//           
//           insertionSort(a);
//           int[] a = {1,5,10,12,4,6,11}; //{ 5, 3, 2, 10, 12, 10, 13}; 
//           long t1 = System.currentTimeMillis();
//           insertionSort(a);
//           long t2 = System.currentTimeMillis();
//           show(a);
//           System.out.println("T: " + (t2-t1));
//
//           t1 = System.currentTimeMillis();
//           mergeSort(a);
//           t2 = System.currentTimeMillis();
//           show(a);
//           System.out.println("T: " + (t2-t1));
//           
//           t1 = System.currentTimeMillis();
//           quickSort(a);
//           t2 = System.currentTimeMillis();
//           show(a);
//           System.out.println("T: " + (t2-t1));
//           
//           t1 = System.currentTimeMillis();
//           quickSort2(a);
//           t2 = System.currentTimeMillis();
//           show(a);
//           System.out.println("T: " + (t2-t1));

       }
}    
class Pair {
      int first;
      int second;
      public Pair(int f, int s) { first = f; second = s;}
}
