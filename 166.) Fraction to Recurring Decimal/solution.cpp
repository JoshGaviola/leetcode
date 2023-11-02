class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        string result;
        if ((numerator < 0) ^ (denominator < 0))
            result += "-";

        long long num = abs(static_cast<long long>(numerator));
        long long den = abs(static_cast<long long>(denominator));

        // Integer part
        result += to_string(num / den);
        num %= den;

        if (num == 0) return result;

        result += ".";

        unordered_map<long long, int> seen;
        while (num != 0) {
            if (seen.find(num) != seen.end()) {
                result.insert(seen[num], 1, '(');
                result += ")";
                break;
            }

            seen[num] = result.length();
            num *= 10;
            result += to_string(num / den);
            num %= den;
        }

        return result;
    }
};
