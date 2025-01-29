//Solved this without knowledge of *Backtracking*
//https://leetcode.com/problems/letter-case-permutation/

import java.util.ArrayList;
import java.util.List;

class Solution 
{
    public List<String> letterCasePermutation(String s) 
    {
        List<String> k = new ArrayList<>();
        if(s == "")
        {
            k.add("");
            return k;
        }
        int l = s.length();
        k.add(s);
        int ll = k.size();
        
        int i=0, p=0;
        while(p != ll)
        {
            System.out.println(p);
            String s1 = k.get(p);
            for(i=0 ; i<s1.length() ; i++)
            {
                char b = s.charAt(i);
                if(!(Character.isLetter(b)))
                {
                    continue;
                    // i++;
                }
                if(Character.isLowerCase(b))
                {
                    String s2 = s1.substring(0,i) + Character.toUpperCase(b) + s1.substring(i+1);
                    if(!(k.contains(s2)))
                    {
                        k.add(s2);
                        System.out.println(s2 + " added");
                        // i++;
                    }
                    continue;
                }
                else
                {
                    String s2 = s1.substring(0,i) + Character.toLowerCase(b) + s1.substring(i+1);
                    if(!(k.contains(s2)))
                    {
                        k.add(s2);
                        System.out.println(s2 + " added");
                        // i++;
                    }
                    continue;
                }
            }
            p++;
            ll = k.size();
            
        }
        return k;
    }
}
