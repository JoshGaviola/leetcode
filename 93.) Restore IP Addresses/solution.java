import java.util.ArrayList;
import java.util.List;

public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<>();
    backtrack(s, 0, new ArrayList<>(), result);
    return result;
}

private void backtrack(String s, int index, List<String> current, List<String> result) {
    // If we have reached a valid IP address and used all digits in the string
    if (current.size() == 4 && index == s.length()) {
        result.add(String.join(".", current));
        return;
    }

    // If we have used all digits but haven't formed a valid IP address
    if (current.size() == 4 || index == s.length()) {
        return;
    }

    // Try different combinations of segments
    for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
        String segment = s.substring(index, index + i);
        // Check for valid segment (not starting with '0' and within [0, 255])
        if ((segment.length() == 1 || (segment.length() > 1 && segment.charAt(0) != '0')) &&
            Integer.parseInt(segment) <= 255) {
            current.add(segment);
            backtrack(s, index + i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
