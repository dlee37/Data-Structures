

public class dialSuggestHelper
{
    static int COUNT = 0;
    public static void main(String[] args)
    {
        char Letters[][4] = {
        {'0'},
        {'1'},
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };
        
    }
    void ConvertPhoneNumberToString(char phone[], int nArraySize, int nStart)
    {
        if(nStart < nArraySize - 1)
        {
            char chDigit = phone[nStart];
            if(chDigit != '-')
            {
                int nDigit = chDigit - '0';
                for(int iLetterCount=0; iLetterCount < 4; ++iLetterCount)
                {
                    char chLetter = Letters[nDigit][iLetterCount];
                    if(chLetter != 0)
                    {
                        phone[nStart] = chLetter;
                        ConvertPhoneNumberToString(phone, nArraySize, nStart + 1);
                        phone[nStart] = chDigit;
                    }
                }
            }
            else
            {
                ConvertPhoneNumberToString(phone, nArraySize, nStart + 1);
            }
        }
        else
        {
            COUNT++;
            printf("[%d]=> %s\n", COUNT, phone);
            
        }
    }
    
    int _tmain(int argc, _TCHAR* argv[])
    {
        char phone[] = {'5','0','2','-', '8','7','6','-','2','3','4','5', '\0'};
        
        ConvertPhoneNumberToString(phone, sizeof(phone)/sizeof(char), 8);
        char ch;
        scanf("%c", &ch);
        return 0;
    }
}