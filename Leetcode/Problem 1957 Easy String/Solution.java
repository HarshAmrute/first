class Solution 
{
    public String makeFancyString(String s) 
    {
        s = s.trim();
        int len = s.length();    
        int k = 1;

        StringBuilder s2 = new StringBuilder(); // Use StringBuilder for efficiency
        for (int i = 0; i < len; i++) 
        {
            if (i == 0) 
            {
                s2.append(s.charAt(i)); // Append the first character
                continue;
            }

            if (s.charAt(i) == s.charAt(i - 1)) 
            {
                if (k < 2) 
                {
                    s2.append(s.charAt(i)); // Append the character only if we have seen it once before
                    k++;
                }
                // If k >= 2, do not append
            } 
            else 
            {
                k = 1; // Reset count for a new character
                s2.append(s.charAt(i)); // Append the character
            }
        }
        String soln = s2.toString();
        return soln; // Convert StringBuilder to String before returning
    }
}

//https://leetcode.com/problems/delete-characters-to-make-fancy-string/?envType=daily-question&envId=2024-11-02