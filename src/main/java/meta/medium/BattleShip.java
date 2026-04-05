package meta.medium;

public class BattleShip {
        public int countBattleships(char[][] board) {
            int count = 0;
            int m = board.length;
            int n = board[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // Skip if it's not a battleship part
                    if (board[i][j] != 'X') continue;

                    // Check if it's a new battleship (top-left corner)
                    if (i > 0 && board[i - 1][j] == 'X') continue;
                    if (j > 0 && board[i][j - 1] == 'X') continue;

                    count++;
                }
            }

            return count;
        }
    }/*
            Time & Space Complexity:
            Time: O(m × n) → Scans every cell once

            Space: O(1) → No extra data structures*/