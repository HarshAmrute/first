class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int n = matrix.length;
        int m = matrix[0].length;
        // matrix having m columns and n rows

        int LB = 0;
        int UB = n*m - 1;

        while(LB <= UB)
        {
            int mid = (LB + UB)/2;
            int r = mid/m; //row position of mid element
            int c = mid%m; //column position of mid element

            if(matrix[r][c] == target)
                return true;
            else if(matrix[r][c] > target)
                UB = mid - 1;
            else
                LB = mid + 1;
        }
        return false;
    }
}

//https://leetcode.com/problems/search-a-2d-matrix/description/