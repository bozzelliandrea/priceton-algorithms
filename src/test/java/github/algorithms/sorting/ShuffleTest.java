package github.algorithms.sorting;

import github.algorithms.model.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ShuffleTest {

    @Test
    void shuffle_cardDeck() {
        Card[] deck = new Card[]{
                new Card(1, Card.Type.S),
                new Card(4, Card.Type.S),
                new Card(6, Card.Type.H),
                new Card(3, Card.Type.S),
                new Card(1, Card.Type.D),
                new Card(11, Card.Type.S),
                new Card(9, Card.Type.S),
                new Card(1, Card.Type.D),
                new Card(8, Card.Type.C),
        };
        Card[] starter = deck.clone();

        Insertion.sort(deck);
        Card[] sorted = deck.clone();
        System.out.println(Arrays.toString(deck));

        Shuffle.sort(deck);

        System.out.println(Arrays.toString(deck));

        Assertions.assertNotEquals(deck, sorted);
        Assertions.assertNotEquals(Arrays.toString(deck), Arrays.toString(sorted));
        Assertions.assertNotEquals(Arrays.toString(deck), Arrays.toString(starter));
    }

    @Test
    void shuffle_integerArray_multipleTimes_shouldBeDifferent() {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] prev = arr.clone();
        int[] init = arr.clone();

        Shuffle.sort(arr);

        System.out.println(Arrays.toString(arr));
        Assertions.assertNotEquals(arr, prev);
        Assertions.assertNotEquals(arr, init);
        assertFalse(Arrays.equals(arr, prev));
        assertFalse(Arrays.equals(arr, init));

        prev = arr.clone();

        Shuffle.sort(arr);

        System.out.println(Arrays.toString(arr));
        Assertions.assertNotEquals(arr, prev);
        Assertions.assertNotEquals(arr, init);
        assertFalse(Arrays.equals(arr, prev));
        assertFalse(Arrays.equals(arr, init));

        prev = arr.clone();

        Shuffle.sort(arr);

        System.out.println(Arrays.toString(arr));
        Assertions.assertNotEquals(arr, prev);
        Assertions.assertNotEquals(arr, init);
        assertFalse(Arrays.equals(arr, prev));
        assertFalse(Arrays.equals(arr, init));
    }
}
