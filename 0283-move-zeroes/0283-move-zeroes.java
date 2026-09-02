class Solution {
    public void moveZeroes(int[] num) {
      int n =num.length;
      int j=0;
      for(int i=0;i<n;i++){
        if(num[i]!=0){
            num[j]=num[i];
            j++;
        }
      }  
      for(int i=j;i<n;i++){
        num[i]=0;
      }
      
    }
}