public class predictText
{
    public static void main(String[] args)
    {
        String[] allLetters =  {"0",
            "1",
            "ABC",
            "DEF",
            "GHI",
            "JKL",
            "MNO","PQRS","TUV","WXYZ"};
        System.out.println(convertSubstring("234",convert("234")));
    }
    
    public static void convert(String phoneNumber)
    {
        convertSubstring(phoneNumber,"");
    }
    
    private static void convertSubstring(String phoneNumber, String convertedLetters)
    {                   
        int digit = Integer.parseInt(phoneNumber.substring(0, 1));
        string letters=allLetters[digit];
        string remainingString=phoneNumber.substring(1);
        
        for (int i = 0; i < letters.length(); ++i) 
        {
            char letter = letters.charAt(i);
            String result=convertedLetters+letter;
            if (remainingString.length()==0)
                System.out.println(result);
            else
                convertSubstring(remainingString, result);
        }
    }
}