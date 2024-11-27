//https://leetcode.com/problems/rotate-string/?envType=daily-question&envId=2024-11-03
class Solution 
{
    public boolean rotateString(String s, String goal) 
    {
        if(s.length() != goal.length())
            return false;
        String k = s;

        for(int i = 0; i<k.length(); i++)
        {
            if(k.equals(goal))
                return true;
            
            k =  k.charAt(k.length()-1) + k.substring(0, k.length() -1);

            }
        return false;
    }
}

