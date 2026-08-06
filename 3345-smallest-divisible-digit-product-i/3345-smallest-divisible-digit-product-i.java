class Solution {
    public int smallestNumber(int n, int t) {
       for (int i = n; ; i++) {
            if (isProductDivisible(i, t)) {
                return i;
            }
        }
    }

    private boolean isProductDivisible(int num, int t) {
        int product = 1;
        while (num > 0) {
            int digit = num % 10;
            product *= digit;
            num /= 10;
        }
        return product % t == 0;
    }
}