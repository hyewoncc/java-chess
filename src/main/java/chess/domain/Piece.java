package chess.domain;

import chess.domain.pieces.Type;
import chess.domain.position.Position;

import java.util.Objects;

public final class Piece {

    private final Color color;
    private final Type type;

    public Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public String symbol() {
        if (color.isWhite()) {
            return type.getSymbol().toLowerCase();
        }
        return type.getSymbol();
    }

    public boolean isMovable(Position source, Position target) {
        boolean movable = type.isMovable(source, target);
        if (movable && type.isPawn()) {
            return checkPawnDirection(source, target);
        }
        return movable;
    }

    private boolean checkPawnDirection(Position source, Position target) {
        if (color.isBlack()) {
            return source.isAbove(target);
        }
        return source.isBelow(target);
    }

    public boolean isPawn() {
        return type.isPawn();
    }

    public boolean isSameColor(Piece piece) {
        return color == piece.color;
    }

    public boolean isSameColor(Color color) {
        return this.color == color;
    }

    public boolean isKing() {
        return type.isKing();
    }

    public double score() {
        return type.score();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Piece)) return false;
        Piece piece = (Piece) o;
        return color == piece.color && piece.type.getClass() == type.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }
}
