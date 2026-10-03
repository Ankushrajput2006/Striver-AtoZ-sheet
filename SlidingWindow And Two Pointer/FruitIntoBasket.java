public class FruitIntoBasket {
    public static void main(String[] args) {
        int[] fruits = {1, 2, 1, 2, 3};
        int result = totalFruit(fruits);
        System.out.println("Maximum number of fruits in two baskets: " + result);
    }

    public static int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        java.util.HashMap<Integer, Integer> fruitCountMap = new java.util.HashMap<>();

        while (right < fruits.length) {
            fruitCountMap.put(fruits[right], fruitCountMap.getOrDefault(fruits[right], 0) + 1);

            if (fruitCountMap.size() > 2) {
                fruitCountMap.put(fruits[left], fruitCountMap.get(fruits[left]) - 1);
                if (fruitCountMap.get(fruits[left]) == 0) {
                    fruitCountMap.remove(fruits[left]);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
