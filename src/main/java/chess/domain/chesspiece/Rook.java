package chess.domain.chesspiece;

import chess.domain.Position;
import chess.domain.chesspieceMove.HorizontalMove;
import chess.domain.chesspieceMove.VerticalMove;

import java.util.HashMap;
import java.util.List;

public class Rook extends ChessPiece {
    private static final int VERTICAL_LINE = 0;

    private static final int SCORE = 5;

    public Rook(Team team) {
        super(team);
        initMovingMap();
    }

    @Override
    public void initMovingMap() {
        movingMap = new HashMap<>();
        movingMap.put(MoveDirection.HORIZONTAL, HorizontalMove.getInstance());
        movingMap.put(MoveDirection.VERTICAL, VerticalMove.getInstance());
    }

    @Override
    public List<Position> getRouteOfPiece(Position source, Position target) {
        MoveDirection moveName = MoveDirection.HORIZONTAL;

        if (source.isInLine(target) == VERTICAL_LINE) {
            moveName = MoveDirection.VERTICAL;
        }

        return movingMap.get(moveName).move(source, target);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public double getScore() {
        return SCORE;
    }
}