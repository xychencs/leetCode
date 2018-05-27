package Question26_50;

public class _37_SuduSolver {
	public void solveSudoku(char[][] board) {
		if(board == null || board.length ==0) {
			return ;
		}
		dfs(board,0);
	}

	public boolean dfs (char board[][] , int position) {
		if(position == 81) {
			return true;
		}
		
		int x = position / 9 ;
		int y = position % 9;
		
		if (board[x][y] != '.') {
            return dfs(board, position+1);
        }
        
        for (char c = '1'; c <= '9'; c++) {
            board[x][y] = c;
            if (isValid(board,position) && dfs(board,position+1)) {
                return true;
            }
            board[x][y] = '.';
        }
        return false;
	}
	
	
	public boolean isValid(char[][] board, int position) {
		int x = position / 9;
		int y = position % 9;
		if (position == 81) {
			return true;
		}

		char c = board[x][y];

		for (int i = 0; i < 9; i++) {
			if (x == i) {
				continue;
			}
			if (board[i][y] == c) {
				return false;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (y == i) {
				continue;
			}
			if (board[x][i] == c) {
				return false;
			}
		}

		int xx = x / 3 * 3;
		int yy = y / 3 * 3;
		for (int i = xx ; i < xx+3 ; i++) {
			for (int j = yy ; j < yy+3 ; j++) {
				if( i == x && y == j) {
					continue;
				}
				if (c == board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
