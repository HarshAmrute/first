class Solution 
{
    public int[] decrypt(int[] code, int k) 
    {
        int len = code.length;
        int[] out = new int[len];
        for(int i=0 ; i<len ; i++)
        {
            int sum = 0;
            if(k == 0)
                out[i] = 0;
            else if (k < 0) 
            {
                for (int j = i - 1; j >= i + k; j--) 
                {
                    sum += code[(j + len) % len]; // Adjust for negative indices
                }
            } 
            else 
            {
                for (int j = i + 1; j <= i + k ; j++) 
                {
                    sum += code[j % len];
                }
            }
            out[i] = sum;
        }
        return out;
    }
}

//https://leetcode.com/problems/defuse-the-bomb/description/