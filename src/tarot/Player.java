package tarot;

import java.util.Stack;

/**
 *
 * @author dpoumakis
 */
public class Player
{
    private int id;
    private Stack<Card> hand;
    private Stack<Card> winnings;
    
    private static int counter;
    
    public Player(Stack<Card> hand)
    {
        id = counter++;
        this.hand = hand;
        winnings = new Stack<>();
    }
    
    public void addCard(Card card)
    {
        hand.push(card);
    }
    
    public Card removeCard()
    {
        return hand.pop();
    }
    
    public void addToWinnings(Card card)
    {
        winnings.push(card);
    }
    
    public Card removeFromWinnings()
    {
        return winnings.pop();
    }
    
    public int getHandCount()
    {
        return hand.size();
    }
    
    public int getWinningsCount()
    {
        return winnings.size();
    }
    
    public Stack<Card> getHand()
    {
        return hand;
    }
    
    public Stack<Card> getWinnings()
    {
        return winnings;
    }
    
    public boolean handIsEmpty()
    {
        return hand.isEmpty();
    }
    
    public void addWinningsToHand()
    {
        for (int card = 0; card < winnings.size(); card++)
        {
            hand.push(winnings.pop());
        }
    }
    
    // Look into having check winnings too
    public boolean hasCards()
    {
        boolean hasCards = true;
        
        if (hand.isEmpty())
        {
            hasCards = false;
        }
        
        return hasCards;
    }
    
    
    /*
    @Override
    public String toString()
    {
        // Will need to figure out how to print stack
        String s = "Hand: \n";
        for (int i = 0; i < hand.size(); i++)
        {
            //s = s + hand[i] + "\n";
        }
        return s;
    }
    */
}
