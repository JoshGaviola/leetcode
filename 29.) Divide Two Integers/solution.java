class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long absDivident = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        long qoutient = 0;
        while (absDivident >= absDivisor) {
            long temp = absDivisor;
            long multiple = 1;
            while (absDivident >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            absDivident -= temp;
            qoutient += multiple;
        }
        
        return (int) (sign * qoutient);
    }
}