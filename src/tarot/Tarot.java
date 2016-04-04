package tarot;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author dpoumakis
 */
public class Tarot
{
    private int home;
    private LinkedList table;
    private Deck deck;
    
    public Tarot()
    {
        home = 0;
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
        for (int i = 0; i < 9; i++)
        {
            if (i == index)
            {
                table.remove(i);
                table.add(i, card);
            }
        }
    }
    
    public void playRound()
    {
        Random randomGen = new Random(System.currentTimeMillis());
        int randomNumber = randomGen.nextInt(9);
        
        home +=  randomNumber;
        
        if (home > 8)
        {
            home -= 9;
        }
        else
        {
            // Valid index
        }
        
        replaceCard(home, deck.getTopCard());
    }
}