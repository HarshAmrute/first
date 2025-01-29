//https://leetcode.com/problems/longest-palindromic-substring/description/

// import java.util.*;

class Main
{
    public static void main(String[] args)
    {
        System.out.println("Try programiz.pro");

        String s = "ABA";
        if (isPal(s))
            System.out.println("ABA is Palindrome");

        System.out.println(longestPalindrome("ad"));
    }

    public static String longestPalindrome(String s)
    {
        int len = s.length();
        String max = "";

        for (int L = 0; L < len; L++)
        {
            for (int R = L + 1; R <= len; R++)
            {
                String sub = s.substring(L, R);
                if (isPal(sub))
                {
                    if (sub.length() > max.length())
                        max = sub;
                }
            }
        }

        return max;
    }

    public static boolean isPal(String sa)
    {
        int L = 0;
        int R = sa.length() - 1;
        while (L <= R)
        {
            if (sa.charAt(L) != sa.charAt(R))
                return false;
            L++;
            R--;
        }
        return true;
    }
}
