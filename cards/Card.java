package cards;

public class Card {
    //牌的数字
    private int number;
    //牌的花色
    private char suit;

    public Card(){
    }

    public Card(int number, char suit) {
        this.number = number;
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public char getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", suit=" + suit +
                '}';
    }
}
