package graphs;
import java.util.*;
class alienDictionary {
    public static String findOrder(String[] words) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Set<Character> set = new HashSet<>();

        for (String str : words) {
            for (int i = 0; i < str.length(); i++) {
                set.add(str.charAt(i));
            }
        }

        for (int k = 0; k < 26; k++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            for (int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        int[] indegree = new int[26];
        for (int i = 0; i < 26; i++) {
            for (int nei : adj.get(i)) {
                indegree[nei]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (char c : set) {
            if (indegree[c - 'a'] == 0) {
                q.add(c - 'a');
            }
        }

        ArrayList<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            order.add(cur);

            for (int num : adj.get(cur)) {
                indegree[num]--;
                if (indegree[num] == 0) {
                    q.add(num);
                }
            }
        }

        if (order.size() < set.size()) {
            return "";
        }

        StringBuilder ans = new StringBuilder();
        for (int i : order) {
            if (set.contains((char)(i + 'a'))) {
                ans.append((char)(i + 'a'));
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println("Alien Dictionary Order: " +findOrder(words));
    }
}
