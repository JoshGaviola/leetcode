public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<>();
    result.add(0); // Start with 0

    for (int i = 0; i < n; i++) {
        int size = result.size();
        int mask = 1 << i; // Create a mask with the i-th bit set
        for (int j = size - 1; j >= 0; j--) {
            int num = result.get(j);
            num |= mask; // Toggle the i-th bit
            result.add(num);
        }
    }

    return result;
}
