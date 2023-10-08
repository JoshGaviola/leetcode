class Solution {
    public void sortColors(int[] nums) {
        int red = 0; // Pointer for the red section
        int white = 0; // Pointer for the white section
        int blue = nums.length - 1; // Pointer for the blue section
        
        while (white <= blue) {
            if (nums[white] == 0) {
                swap(nums, red, white);
                red++;
                white++;
            } else if (nums[white] == 1) {
                white++;
            } else {
                swap(nums, white, blue);
                blue--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
