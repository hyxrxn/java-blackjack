package blackjack.card;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    @DisplayName("덱에서 카드를 뽑는다.")
    void createDeckTest() {
        // given
        List<Card> cards = List.of(
                new Card(Shape.HEART, Rank.ACE),
                new Card(Shape.CLOVER, Rank.EIGHT),
                new Card(Shape.DIAMOND, Rank.JACK)
        );
        Deck deck = new Deck(cards);
        Card expected = new Card(Shape.HEART, Rank.ACE);
        // when, then
        assertThat(deck.draw()).isEqualTo(expected);
    }

    @Test
    @DisplayName("덱에 카드가 없을 때 뽑는다면 예외를 발생시킨다.")
    void emptyDeckDrawTest() {
        // given
        Deck deck = new Deck(List.of());
        // when, then
        assertThatThrownBy(deck::draw)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 덱이 비어있습니다.");
    }
}
