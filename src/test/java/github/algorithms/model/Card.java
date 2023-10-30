package github.algorithms.model;

public class Card implements Comparable<Card> {

    private final int value;
    private final Type suits;

    public Card(int value, Type suits) {
        this.value = value;
        this.suits = suits;
    }

    @Override
    public int compareTo(Card o) {
        if (this.value < o.getValue())
            return -1;
        if (this.value > o.getValue())
            return 1;

        return 0;
    }

    // clubs (♣), diamonds (♦), hearts (♥), and spades (♠)
    public enum Type {
        C, D, H, S
    }

    public int getValue() {
        return value;
    }

    public Type getSuits() {
        return suits;
    }

    @Override
    public String toString() {
        return "{" + value + "," + suits + '}';
    }
}
