package chess.domain.piece.role;

import chess.domain.position.Position;

public final class Knight implements Role {

    private static final int FIRST_MOVEMENT_LIMIT = 2;
    private static final int SECOND_MOVEMENT_LIMIT = 1;
    private static final double SCORE = 2.5;

    @Override
    public String getSymbol() {
        return "N";
    }

    @Override
    public boolean isMovable(Position source, Position target) {
        int columnGap = source.columnGap(target);
        int rowGap = source.rowGap(target);
        return moveVerticalFirstThenDiagonal(columnGap, rowGap) || moveHorizontalFirstThenDiagonal(columnGap, rowGap);
    }

    private boolean moveHorizontalFirstThenDiagonal(int columnGap, int rowGap) {
        return rowGap == FIRST_MOVEMENT_LIMIT && columnGap == SECOND_MOVEMENT_LIMIT;
    }

    private boolean moveVerticalFirstThenDiagonal(int columnGap, int rowGap) {
        return columnGap == FIRST_MOVEMENT_LIMIT && rowGap == SECOND_MOVEMENT_LIMIT;
    }

    @Override
    public boolean isPawn() {
        return false;
    }

    @Override
    public boolean isKing() {
        return false;
    }

    @Override
    public double score() {
        return SCORE;
    }
}