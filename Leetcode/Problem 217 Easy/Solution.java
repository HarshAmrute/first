import java.util.HashSet;
import java.util.Set;

class Solution 
{
    public boolean containsDuplicate(int[] nums) 
    {
        int l = nums.length;
        Set<Integer> x = new HashSet<> ();

        for(int i = 0 ; i<l ; i++)
        {
            if(x.contains(nums[i]))
                return true;
            else
                x.add(nums[i]);
        }
        return false;
    }
}

//https://leetcode.com/problems/contains-duplicate/