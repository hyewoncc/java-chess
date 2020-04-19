package chess.domain.RuleStrategy.nonLeapableStrategy.pawnRuleStrategy;

import chess.domain.position.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WhitePawnRuleTest {

    @Test
    void WhitePawnRuleStrategy_MovableAndCatchableDirections_GenerateInstance() {
        assertThat(new WhitePawnRule()).isInstanceOf(WhitePawnRule.class);
    }

    @Test
    void canMove_InitialStateMovableSourcePositionAndTargetPosition_ReturnTrue() {
        Position sourcePosition = Position.of("c2");

        assertThat(new WhitePawnRule().canInitialMove(sourcePosition, Position.of("c4"))).isTrue();
    }

    @Test
    void canMove_MovedStateMovableSourcePositionAndTargetPosition_ReturnTrue() {
        Position sourcePosition = Position.of("c3");

        assertThat(new WhitePawnRule().canMove(sourcePosition, Position.of("c4"))).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"b4", "d4"})
    void canMove_NonMovableSourcePositionAndTargetPosition_ReturnFalse(Position targetPosition) {
        Position sourcePosition = Position.of("c3");

        assertThat(new WhitePawnRule().canMove(sourcePosition, targetPosition)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"b4", "d4"})
    void canMoveToCatch_CatchableSourcePositionAndTargetPosition_ReturnTrue(Position targetPosition) {
        Position sourcePosition = Position.of("c3");

        assertThat(new WhitePawnRule().canMoveToCatch(sourcePosition, targetPosition)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"c4", "c5"})
    void canMoveToCatch_NonCatchableSourcePositionAndTargetPosition_ReturnFalse(Position targetPosition) {
        Position sourcePosition = Position.of("c3");

        assertThat(new WhitePawnRule().canMoveToCatch(sourcePosition, targetPosition)).isFalse();
    }

}