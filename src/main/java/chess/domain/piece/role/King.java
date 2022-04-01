package chess.domain.piece.role;

import chess.domain.position.Position;

public final class King implements Role {

    private static final int MOVEMENT_LIMIT = 1;
    private static final double SCORE = 0;

    @Override
    public String getSymbol() {
        return "K";
    }

    @Override
    public boolean isMovable(Position source, Position target) {
        return source.columnGap(target) <= MOVEMENT_LIMIT && source.rowGap(target) <= MOVEMENT_LIMIT;
    }

    @Override
    public boolean isPawn() {
        return false;
    }

    @Override
    public boolean isKing() {
        return true;
    }

    @Override
    public double score() {
        return SCORE;
    }
}