class Solution 
{
    public String convert(String s, int r) 
    {
        int l = s.length();
        char[][] a = new char[r][l]; // Create a 2D array of size [r][l]
        int k = 0;

        if (l <= r || r == 1) 
            return s;

        for (int i = 0; i < l; i++) 
        {
            if (k >= l) 
                break;
            // Vertical fill
            if (i % (r - 1) == 0) 
            {
                for (int j = 0; j < r && k < l; j++) 
                {
                    a[j][i] = s.charAt(k++);
                }
            } 
            // Diagonal fill
            else 
                a[r - (i % (r - 1)) - 1][i] = s.charAt(k++);
            
        }
        // Construct the output string
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < r; i++) 
        {
            for (int j = 0; j < l; j++) 
            {
                if (a[i][j] != '\u0000')  // Skip empty cells
                    output.append(a[i][j]);
            }
        }
        return output.toString();
    }
}

//https://leetcode.com/problems/zigzag-conversion/

//it took me 2 hours to solve this