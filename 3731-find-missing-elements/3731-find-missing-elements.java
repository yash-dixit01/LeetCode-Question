class Solution {
    public List<Integer> findMissingElements(int[] nums) {
       List<Integer> missingNumbers = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return missingNumbers;
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        // Find the minimum and maximum values in the array
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        // Create a set for quick lookup of existing numbers
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        // Check for missing numbers in the range [min, max]
        for (int i = min; i <= max; i++) {
            if (!numSet.contains(i)) {
                missingNumbers.add(i);
            }
        }
        
        return missingNumbers;
    }
}