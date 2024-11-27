class Solution 
{
    public int possibleStringCount(String word) 
    {
        int k=0;
        int count=1;
        for(int i=0; i<word.length() ;i++)
        {
            char b=word.charAt(i);
            if(i==0 && count>-1)
                continue;
            if(b == word.charAt(i-1))
            {
                count++;
                k = k+1;
            }
            else
                count=1;
        }
        return ++k;
    }
}

//https://leetcode.com/problems/find-the-original-typed-string-i/