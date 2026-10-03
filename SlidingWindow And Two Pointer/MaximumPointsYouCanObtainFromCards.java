public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        int result = maxScore(cardPoints, k);
        System.out.println("Maximum points you can obtain from cards: " + result);
    }
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftSum = 0;
        int rightSum = 0;
        int maxScore = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        maxScore = leftSum;
        int rightIndex = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[rightIndex--];
            maxScore = Math.max(maxScore, leftSum + rightSum);
        }
        return maxScore;
    }
}
