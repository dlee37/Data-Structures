/*
 * Daniel Lee
 * Assignment 2
 */

import java.util.Arrays;
//Arrays.copyOf
public class unionDifference {
    
    public static void main(String[] args)
    {
        int[] a = {1,3,5,15,20};
        int[] b = {1,5,10};
        System.out.println(Arrays.toString(union(a,b)));
        System.out.println();
        System.out.println(Arrays.toString(difference(a,b)));
    }
    
    public static int[] union(int[] a, int[] b)
    {
        int[] ans = new int[a.length + b.length];
        int aIndex = 0;
        int count = 0;
        int bIndex = 0;
        int x = 0;
        
        while (x < ans.length) 
        {
            if (bIndex >= b.length && b.length > 0) 
            {
                ans[count] = a[aIndex];
                ++count;
                ++aIndex;
                ++x;
                continue;
            }
            if (aIndex >= a.length && a.length > 0) 
            {
                ans[count] = b[bIndex];
                ++bIndex;
                ++count;
                ++x;
                continue;
            }
            else if (a[aIndex] == b[bIndex]) 
            {
                bIndex++;
            }
            else if (a[aIndex] > b[bIndex]) 
            {
                ans[count] = b[bIndex];
                count++;
                bIndex++;
            }
            else if (a[aIndex] < b[bIndex]) 
            {
                ans[count] = a[aIndex];
                count++;
                ++aIndex;
            }
            /* System.out.println(Arrays.toString(ans));
             System.out.println(aIndex);
             System.out.println(bIndex);
             System.out.println(count);
             */
            ++x;
        }
        ans = Arrays.copyOf(ans,count);
        return ans;
    }
    public static int[] difference(int[] a, int[] b) 
    {
        int[] ans = new int[20];
        int index = 0;
        int count = 0;
        for (int aIndex = 0; aIndex < a.length; aIndex++) 
        {
            for (int bIndex = 0; bIndex < b.length; bIndex++) 
            {
                if (a[aIndex] == b[bIndex])
                {
                    break;
                }
                else if (bIndex + 1 == b.length) 
                { 
                    ans[index] = a[aIndex];
                    ++index;
                    ++count;
                }
            }
        }
        ans = Arrays.copyOf(ans,count);
        return ans;
    }
}