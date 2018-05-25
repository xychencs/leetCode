package Question26_50;

import java.util.HashSet;

public class _36_ValidSudu {
	// ��һ�ַ�������    ����ÿ���������ݣ����Ҹ��и��к͸ÿ� �Ƿ���һ��������
	public boolean isValidSudoku(char[][] board) {
		HashSet<Integer> hash = new HashSet<>();
		
		for(int i = 0 ; i <= 8 ; i++) {
			for(int j = 0 ; j <= 8 ; j++) {
				if(board[i][j] =='.') {
				}else {
					if(hash.contains(board[i][j]-'0')) {
						return false;
					}else{
						hash.add(board[i][j]-'0');
					}
				}
			}
			hash.clear();
		}
		
		for(int j = 0 ; j <= 8 ; j++) {
			for(int i = 0 ; i <= 8 ; i++) {
				if(board[i][j] =='.') {
				}else {
					if(hash.contains(board[i][j]-'0')) {
						return false;
					}else{
						hash.add(board[i][j]-'0');
					}
				}
			}
			hash.clear();
		}
		
		for(int ii = 0 ; ii <= 8 ; ii++) {
			for(int jj = 0 ; jj <= 8 ; jj++) {
				int i = jj/3 +3*(ii/3)  ;
				int j = jj%3  +3*(ii%3);
				if(board[i][j] =='.') {
				}else {
					if(hash.contains(board[i][j]-'0')) {
						return false;
					}else{
						hash.add(board[i][j]-'0');
					}
				}
			}
			hash.clear();
		}
		
		
		
		
		
		return true;
	}
}
