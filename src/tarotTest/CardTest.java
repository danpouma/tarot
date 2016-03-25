package tarotTest;

import tarot.Card;

/**
 *
 * @author dpoumakis
 */
public class CardTest
{
    public static void main(String[] args)
    {
        Card[] cards = new Card[52];

        int index = 0;
        for (int suit = 1; suit <= 4; suit++)
        {
            for (int value = 1; value <= 13; value++)
            {
                cards[index] = new Card(value, suit);
                index++;
            }
        }
        
        for (Card card : cards)
        {
            System.out.println(card);
        }
    }
}
