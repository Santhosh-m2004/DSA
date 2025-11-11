package leetcode;
public class lt1423 {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;

        // Step 1: Take first k cards from the left
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        int max = sum;
        int n = cardPoints.length;

        // Step 2: Gradually replace left-side cards with right-side cards
        for (int i = 0; i < k; i++) {
            // remove one from the left side
            sum -= cardPoints[k - i - 1];
            // add one from the right side
            sum += cardPoints[n - i - 1];

            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
        lt1423 sol = new lt1423();
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println(sol.maxScore(cardPoints, k)); // output: 12
    }
}
