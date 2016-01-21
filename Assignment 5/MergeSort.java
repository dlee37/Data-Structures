public class QuickSort {
    public static void swap(int[] a, int i, int j)
    {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
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
}