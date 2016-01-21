/* 
 * Daniel Lee
 * Assignment 2
 */

import java.util.Arrays;
public class Intersection {
    
    public static void main(String[] args){
        int[] a = {1,3,5};
        int[] b = {1,5,10, 20, 30};
        System.out.println(Arrays.toString(intersection(a,b)));
        
    }
    public static int[] intersection(int[] a,int[] b){
        int[] ans = new int[20];
        //System.out.println(ans);
        int count = 0;
        
        if (b.length >= a.length){
            int shorter = a.length;
            int longer = b.length;
            for (int i = 0; i < shorter; i++) {
                for (int j = 0; j < longer; j++) {
                    if (a[i] == b[j]) {
                        ans[count] = a[i];
                        count++;
                        //System.out.println(ans);
                        break;
                    }
                }
            }
        }
        
        else if (a.length > b.length) {
            int shorter = b.length;
            int longer = a.length;
            for (int i = 0; i < shorter; i++) {
                for (int j = 0; j < longer; j++) {
                    if (b[i] == a[j]) {
                        ans[count] = b[i];
                        count++;
                        //System.out.println(ans);
                        break;
                    }
                }
            }
        }
        ans = Arrays.copyOf(ans,count);
        return ans;
    }
}
