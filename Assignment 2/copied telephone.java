    public static void allCombination(String[][] smallArray, int n, String part)
    {
        if (n == smallArray.length)
        {
            System.out.println(part);
            return;
        }
        for (int i = 0; i < smallArray[n].length; i++)
        {
            allCombination(smallArray, n+1, combination + smallArray[n][i]);
        }
    }
}