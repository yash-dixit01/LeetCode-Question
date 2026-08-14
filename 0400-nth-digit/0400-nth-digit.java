class Solution {
    public int findNthDigit(int n) {
       long digit = 1, count = 9, start = 1;
       while(n > digit * count){
           n -= digit * count;
           digit++;
           count *= 10;
           start *= 10;
       }
         start += (n - 1) / digit;
        String s = Long.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % (int)digit)); 
    }
}