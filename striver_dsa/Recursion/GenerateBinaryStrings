/*Given an integer n, return all binary strings of length n that do not contain consecutive 1s. Return the result in lexicographically increasing order.
A binary string is a string consisting only of characters '0' and '1'.
Examples:
Input: n = 3
Output: ["000", "001", "010", "100", "101"]
Explanation: All strings are of length 3 and do not contain consecutive 1s.*/

class Solution {
    public List<String> generateBinaryStrings(int n) {
        List<String> lst = new ArrayList<>();
        recursion(lst, "", n, false);
        return lst;
    }

    public static void recursion(List<String> lst, String str, int n, boolean prev) {
        if (str.length() == n) {
            lst.add(str);
            return;
        }

        // Add '0'
        recursion(lst, str + "0", n, false);

        // Add '1' only if previous was not '1'
        if (!prev) {
            recursion(lst, str + "1", n, true);
        }
    }
}
