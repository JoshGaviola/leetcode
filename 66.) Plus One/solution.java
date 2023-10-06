class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Iterate from right to left and add one to the last digit.
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                // If the digit is less than 9, we can simply increment it.
                digits[i]++;
                return digits; // No need to carry over.
            } else {
                // If the digit is 9, set it to 0 and carry over.
                digits[i] = 0;
            }
        }
        
        // If all digits are 9, we need to add an additional digit at the beginning.
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
