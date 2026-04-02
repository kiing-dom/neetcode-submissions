class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        Map<Integer, Set<Character>> rowToValues = new HashMap<>();
        Map<Integer, Set<Character>> colToValues = new HashMap<>();
        Map<String, Set<Character>> squareToValues = new HashMap<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                 if (board[r][c] == '.') {
                    continue;
                }

                String squareKey = new StringBuilder(String.valueOf(r/3)).append(',').append(String.valueOf(c/3)).toString();
                if (rowToValues.computeIfAbsent(r, key -> new HashSet<>()).contains(board[r][c]) ||
                    colToValues.computeIfAbsent(c, key -> new HashSet<>()).contains(board[r][c]) ||
                    squareToValues.computeIfAbsent(squareKey, key -> new HashSet<>()).contains(board[r][c])
                ) {
                    return false;
                }

                rowToValues.get(r).add(board[r][c]);
                colToValues.get(c).add(board[r][c]);
                squareToValues.get(squareKey).add(board[r][c]);
            }
        }

        return true;
    }
}