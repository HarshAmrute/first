class Solution {
    public boolean isPalindrome(int x) 
    {
        if (x<0)
            return false;
        
        int x1 = x, x2 = 0;

        while(x1!=0)
        {
            int r = x1%10;
            x2 = x2*10 + r;
            x1 = x1/10;
        }
        if(x==x2)
            return(true);
        return(false);
    }
}