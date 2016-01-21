/*
 * Daniel Lee
 * Assignment 2
 */

import java.util.Scanner;
public class matchExpressions {
    
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) 
    {
        String a,expression;
        System.out.print("Enter a string here: ");
        a = input.next();
        System.out.print("Enter another string to determine a match here: ");
        expression = input.next();
        System.out.println(match(a,expression,true));
    }
    
    public static boolean match(String a, String expression, boolean noStar) 
    {
        if (expression.length() == 1)
        {
            if (a.equals(expression))
            {
                return true;
            }
            if (!a.equals(expression))
            {
                if (a.length() != 1 && expression.substring(0,1) == "*")
                {
                    return match(a.substring(1),expression,false);
                }
                else if (a.length() == 1)
                {    
                    if (expression.equals("*") || expression.equals("."))
                    {
                        return true;
                    }
                }
                else if (a.length() != 1 && expression.equals("."))
                {
                    return false;
                }
                else 
                {
                    return false;
                }
                
            }
            return match(a.substring(1),expression,true);
        }
        if (a.length() == 1)
        {
            if (expression.length() == 1)
            {
                if (expression.equals(a) || expression.equals("*") || expression.equals("."))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else if (expression.substring(0,1).equals("*"))
            {
                return match(a,expression.substring(1),true);
            }
            else if (!expression.substring(0,1).equals("*"))
            {
                match(a,expression.substring(1),false);
            }
        }
        else if (a.substring(0,1).equals(expression.substring(1,2)) && noStar == false)
        {
            return match(a.substring(0),expression.substring(1),true);
        }
        else if (noStar == false)
        {
            return match(a.substring(1),expression.substring(0),false);
        }
        else if (expression.substring(0,1).equals("."))
        {
            return match(a.substring(1),expression.substring(1),true);
        }
        else if (expression.substring(0,1).equals("*"))
        {
            return match(a.substring(1),expression.substring(0),false);
        }
        else if (noStar == true && a.substring(0,1).equals(expression.substring(0,1)))
        {
            return match(a.substring(1),expression.substring(1),true);
        }
        return false;
    }
}