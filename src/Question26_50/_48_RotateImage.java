package Question26_50;

public class _48_RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		
		for(int i = 0 ; i < n/2 ; i++) {
			for(int j = 0 ; j < n ; j++) {
				int temp = matrix[j][i];
				matrix[j][i] = matrix[j][n-i-1];
				matrix[j][n-i-1] = temp;
			}
		}
		
	
		for(int i = 0 ; i <=n-2 ; i++) {
			for(int j = 0 ; j <= n-2-i ; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][n-1-i];
				matrix[n-1-j][n-1-i] = temp;
			}
		}
	}
}
