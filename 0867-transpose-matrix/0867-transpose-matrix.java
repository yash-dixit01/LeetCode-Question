class Solution {
    public int[][] transpose(int[][] arr) {
        int row =arr.length,col=arr[0].length;
        int[][] b= new int [col][row];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j <b[0].length; j++) {
                b[i][j]=arr[j][i];
            }
        }
        return b;
    }
}