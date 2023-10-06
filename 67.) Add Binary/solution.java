class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        // Perform binary addition from right to left
        while (i >= 0 || j >= 0 || carry == 1) {
            int bitA = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j--) - '0' : 0;

            // Calculate the sum of bits and carry
            int sum = bitA + bitB + carry;
            carry = sum / 2;
            result.insert(0, sum % 2); // Insert the least significant bit to the beginning
        }

        return result.toString();
    }
}
