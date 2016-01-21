/*
 * Daniel Lee
 * Assignment 2
 */

import java.util.Scanner;
public class matchExpressions {
  
  static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.print("Enter a string here: ");
    a = input.next();
    System.out.print("Enter another string here: ");
    expression = input.next();
    System.out.println(match(a,expression));
  }
  
  public static boolean match(String a, String expression) {
    
    if (a.equals("")) {
      return true;
    }
    
    if (expression.substring(0,1).equals(".")) {
      return match(a.substring(1),expression.substring(1));
    }
    else if (expression.substring(0,1).equals(".")) {
      
    }
}