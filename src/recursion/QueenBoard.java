package recursion;

import java.util.Arrays;

public class QueenBoard {
    private int[][] board;

    public QueenBoard(int size) {
        board = new int[size][size];
    }

    private boolean addQueen(int r, int c) {
        if (board[r][c] == 0) {
            // set invalid areas
            for (int i = r, j = c; i < board.length && j < board.length; i++, j++) {
                board[i][j]++;
            }
            for (int i = r, j = c; i > -1 && j < board.length; i--, j++) {
                board[i][j]++;
            }
            for (int j = c; j < board.length; j++) {
                board[r][j]++;
            }

            board[r][c] = Integer.MIN_VALUE;
            return true;
        } else {
            return false;
        }
    }

    private boolean removeQueen(int r, int c) {
        if (board[r][c] < 0) {
            // reset invalid areas
            for (int i = r, j = c; i < board.length && j < board.length; i++, j++) {
                board[i][j]--;
            }
            for (int i = r, j = c; i > -1 && j < board.length; i--, j++) {
                board[i][j]--;
            }
            for (int j = c; j < board.length; j++) {
                board[r][j]--;
            }

            board[r][c] = 0;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return The output string formatted as follows: All numbers that represent
     *         queens are replaced with 'Q', all others are displayed as underscores
     *         '_'. There are spaces between each symbol:
     * 
     *         <pre>
     *         """_ _ Q _ 
     *         Q _ _ _
     *         _ _ _ Q
     *         _ Q _ _"""
     *         </pre>
     * 
     *         (pythonic string notation for clarity, excludes the character up to
     *         the *)
     */
    @Override
    public String toString() {
        StringBuilder boardStr = new StringBuilder("");

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == -1) {
                    boardStr.append("Q ");
                } else {
                    boardStr.append("_ ");
                }

            }
            boardStr.delete(boardStr.length(), boardStr.length()).append("\n");
        }
        return boardStr.toString();
    }

    /**
     * @return false when the board is not solveable and leaves the board filled
     *         with zeros; true when the board is solveable, and leaves the board in
     *         a solved state
     * @throws IllegalStateException when the board starts with any non-zero value
     */
    public boolean solve() {
        if (!isValidBoard()) {
            throw new IllegalStateException("Board should not start with any non-zero value");
        }
        
    }

    /**
     * @return the number of solutions found, and leaves the board filled with only
     *         0's
     * @throws IllegalStateException when the board starts with any non-zero value
     */
    public int countSolutions() {
        if (!isValidBoard()) {
            throw new IllegalStateException("Board should not start with any non-zero value");
        }
    }
    
    private boolean isValidBoard() {
        return Arrays.equals(board, new int[board.length][board.length]);
    }
}
