public int singleNumber(int[] nums) {
    int result = 0;
    
    for (int i = 0; i < 32; i++) { // Assuming 32-bit integers
        int count = 0;
        int mask = 1 << i;
        
        for (int num : nums) {
            if ((num & mask) != 0) {
                count++;
            }
        }
        
        if (count % 3 != 0) {
            result |= mask;
        }
    }
    
    return result;
}
