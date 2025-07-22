package epicor;
/*In this problem, the number of unique players who receive the ball is exactly equal to k**
Because:
The ball is passed k times.
Each pass goes to 1 different person.
Players are in a circle, so there is no boundary issue.
The starting person is not included in the count. */
import java.util.*;

public class PassingTheBall {
    public static int countUniqueReceivers(int n, int start, int k) {
        Set<Integer> unique = new HashSet<>();
        int current = start;

        for (int i = 0; i < k; i++) {
            current = (current + 1) % n;  // Passing to next player in circle
            unique.add(current);
        }

        return unique.size();
    }

    public static void main(String[] args) {
        int n = 5;      // Total players
        int start = 1;  // Starting player (0-indexed)
        int k = 3;      // Number of passes

        System.out.println("Unique receivers: " + countUniqueReceivers(n, start, k));
    }
}
