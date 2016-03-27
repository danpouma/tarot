package tarot;

import java.util.LinkedList;
import java.util.Random;

/*
TODO:
Objective: dealing with linked lists

Now we are going to read fortunes: Tarot cards. The suits this time are swords, 
wands, coins and cups. The face values stay the same but there are 14 cards to 
a suit (King, Queen, Knight & Jack).

Shuffle the deck and place nine cards in a circle. Randomly pick a number 1-9. 
Count to that number going around the circle. When you get to that number card, 
print what the card is and replace it in the circle with the next card on the 
deck. At any given time, there are nine cards in the circle and you have a 
“home card” (The one that tells your fate). A move consists of picking a random 
number, removing a card and replacing it with the next card on the deck. Print 
the card that was removed and the card that replaced it.
*/

/**
 *
 * @author dpoumakis
 */
public class Tarot
{
    private LinkedList table;
    private Deck deck;
    
    public Tarot()
    {
        table = new LinkedList();
        deck = new Deck();
    }
    
    public void initializeTable()
    {
        for (int card = 0; card < 9; card++)
        {
            table.add(deck.getTopCard());
        }
    }
    
    public void printCard(int index)
    {
        System.out.println(table.get(index)); 
    }
    
    public void replaceCard(int index, Card card)
    {
        int randomNumber = randomNumber();
        
        for (int i = 0; i < 9; i++)
        {
            if (i == randomNumber)
            {
                System.out.println("removed: " + table.remove(i));
                table.add(i, card);
            }
        }
    }
    
    public int randomNumber()
    {
        Random randomGen = new Random(System.currentTimeMillis());
        
        return randomGen.nextInt(9);
    }
}