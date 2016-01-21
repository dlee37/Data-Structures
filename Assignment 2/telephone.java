/*
 * Daniel Lee
 * Assignment 2
 */

import java.util.Arrays;
import java.util.Scanner;

public class telephone
{
    
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) 
    {
        String a;
        System.out.print("Enter numbers without spaces here: ");
        a = input.next();
        String[][] smallArray = splitArray(a); //this determines the length of the array, inside another function
        allCombination(a.length(),0,"",smallArray);
    }
    
    public static String[][] splitArray(String a)
    {  
        // String[] keyAlt = {"abc","def","ghi","jkl""mno","pqrs","tuv","wxyz"};
        String[][] key = {{"0"},{"1"},{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},
                          {"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
        String[][] smallArray = new String[a.length()][4];
        for (int i = 0; i < a.length(); i++)
        {
            String ch = a.substring(i,i+1);
            int index = Integer.parseInt(ch);
            smallArray[i] = key[index];
        }
        return smallArray;
    }
    
    public static void allCombination(int length, int index, String ans, String[][] smallArray)
    {
        if (index == length)
        {
            System.out.println(ans);
            return;
        }
        int n = smallArray[index].length;
        for (int i = 0; i < n; i++)
        {
            allCombination(length, index+1, ans + smallArray[index][i], smallArray);
        }
    }
}