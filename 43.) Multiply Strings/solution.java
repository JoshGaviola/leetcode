class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];
        
        // Multiply each digit and add to the result
        for (int i = m - 1; i >= 0; i--) {
            int carry = 0;
            int digit1 = num1.charAt(i) - '0';
            
            for (int j = n - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                int product = digit1 * digit2 + result[i + j + 1] + carry;
                carry = product / 10;
                result[i + j + 1] = product % 10;
            }
            
            result[i] += carry; // Add any remaining carry to the current position
        }
        
        // Convert the result array to a string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
