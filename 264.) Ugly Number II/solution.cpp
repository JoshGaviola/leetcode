#include <vector>
#include <algorithm>

class Solution {
public:
    int nthUglyNumber(int n) {
        if (n == 1) {
            return 1; // The first ugly number is 1
        }

        std::vector<int> uglyNumbers(n);
        uglyNumbers[0] = 1; // Initialize with the first ugly number
        int p2 = 0, p3 = 0, p5 = 0; // Pointers for multiples of 2, 3, and 5

        for (int i = 1; i < n; ++i) {
            // Find the minimum of the next multiples of 2, 3, and 5
            int nextUgly = std::min({uglyNumbers[p2] * 2, uglyNumbers[p3] * 3, uglyNumbers[p5] * 5});

            // Update the array with the next ugly number
            uglyNumbers[i] = nextUgly;

            // Move the corresponding pointer(s) to the next multiple(s)
            if (nextUgly == uglyNumbers[p2] * 2) {
                ++p2;
            }
            if (nextUgly == uglyNumbers[p3] * 3) {
                ++p3;
            }
            if (nextUgly == uglyNumbers[p5] * 5) {
                ++p5;
            }
        }

        return uglyNumbers[n - 1];
    }
};
