class Solution {
    public int arrangeCoins(int n) {
        int low = 1;
        int high = n;
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long coinsNeeded = (long) mid * (mid + 1) / 2;

            if (coinsNeeded <= n) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}