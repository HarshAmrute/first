class Solution {
    public int reverse(int x) {
        long reversed = 0;

        while (x != 0) {
            int r = x % 10;
            reversed = reversed * 10 + r;
            x /= 10;
        }

        // Check if reversed is within int range
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        
        return (int) reversed;
    }
}
