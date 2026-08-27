class Solution {
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private int mergeSort(int[] nums, int left, int right) {
        if(left >= right) return 0;
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        count += merge(nums, left, mid, right);
        return count;
    }
    
    private int merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int count = 0;
        
        while(i <= mid && j <= right) {
            if((long)nums[i] > 2 * (long)nums[j]) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        
        i = left;
        j = mid + 1;
        while(i <= mid && j <= right) {
            if(nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        
        while(i <= mid) {
            temp[k++] = nums[i++];
        }
        
        while(j <= right) {
            temp[k++] = nums[j++];
        }
        
        System.arraycopy(temp, 0, nums, left, temp.length);
        return count;
  
    }
}