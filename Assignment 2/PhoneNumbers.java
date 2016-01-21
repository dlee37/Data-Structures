import java.util.ArrayList;

public class PhoneNumbers
{
    public static void main(String[] args)
    {
     for (String result: convert(args[0]))
      System.out.println(result);
    }

    public static ArrayList<String> convert(String phoneNumber)
    {   
     int digit = Integer.parseInt(phoneNumber.substring(0, 1));
     String letters = new String[] {
      "0",
      "1",
      "ABC",
      "DEF",
      "GHI",
      "JKL",
      // etc...
     }[digit];

     ArrayList<String> result = new ArrayList<String>();

     for (int i = 0; i < letters.length(); ++i) {
      char letter = letters.charAt(i);
      if (phoneNumber.length() > 1) {
       for (String rest: convert(phoneNumber.substring(1)))
        result.add(letter + rest);
      } else {
       result.add("" + letter);
      }
     }

     return result;
    }
}