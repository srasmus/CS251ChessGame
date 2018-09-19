public class Board {
    private String[][] board = new String[8][8];

    // ------------------------------------------------------------------------
    // Setup
    // ------------------------------------------------------------------------

    /**
     * Removes all pieces from the board.
     */
    public void clear() {
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                board[rank][file] = null;
            }
        }
    }

    /**
     * Sets the back two ranks of each player to be the starting position. The
     * back rank gets the sequence <R, K, B, Q, K, B, K, N>, and the second to
     * last rank gets eight pawns.
     */
    public void initialize() {
        clear();

        for (int file = 0; file < 8; file++) {
            board[1][file] = "\u265F";
            board[6][file] = "\u2659";
        }

        board[0][0] = "\u265C";
        board[0][1] = "\u265E";
        board[0][2] = "\u265D";
        board[0][3] = "\u265B";
        board[0][4] = "\u265A";
        board[0][5] = "\u265D";
        board[0][6] = "\u265E";
        board[0][7] = "\u265C";

        board[7][0] = "\u2656";
        board[7][1] = "\u2658";
        board[7][2] = "\u2657";
        board[7][3] = "\u2655";
        board[7][4] = "\u2654";
        board[7][5] = "\u2657";
        board[7][6] = "\u2658";
        board[7][7] = "\u2656";
    }

    // ------------------------------------------------------------------------
    // Printing
    // ------------------------------------------------------------------------

    /**
     * @return The string representation of the board.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(toStringFileLabels());

        for (int rank = 0; rank < 8; rank++) {
            sb.append(toStringLine());
            sb.append(toStringRank(rank));
        }

        sb.append(toStringLine());
        sb.append(toStringFileLabels());
        return sb.toString();
    }

    private String toStringFileLabels() {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");

        for (int file = 0; file < 8; file++) {
            sb.append(" ");
            sb.append((char) (file + 65));
            sb.append("  ");
        }

        sb.append("\n");
        return sb.toString();
    }

    private String toStringRank(int rank) {
        StringBuilder sb = new StringBuilder();

        sb.append(8 - rank);
        sb.append(" | ");

        for (int file = 0; file < 8; file++) {
            if (board[rank][file] == null) {
                sb.append(" ");
            } else {
                sb.append(board[rank][file]);
            }

            sb.append(" | ");
        }

        sb.append(8 - rank);
        sb.append("\n");
        return sb.toString();
    }

    private String toStringLine() {
        StringBuilder sb = new StringBuilder();

        sb.append("  ");
        for (int file = 0; file < 8; file++) {
            sb.append("+---");
        }

        sb.append("+\n");
        return sb.toString();
    }
}
