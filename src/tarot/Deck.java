package tarot;

import java.util.Random;

/**
 *
 * @author dpoumakis
 * @date 2/8/2016
 */
public class Deck
{
    private Card[] cards;
    private int numCardsLeft;
    private Card topCard;
    
    public Deck()
    {
        // Initialize number of card left
        numCardsLeft = 52;
        
        // Create an array of null pointers for Card objects
        cards = new Card[numCardsLeft];

        // Initialize each null pointer to new Card objects
        int index = 0;
        for (int suit = 1; suit <= 4; suit++)
        {
            for (int value = 1; value <= 13; value++)
            {
                cards[index] = new Card(value, suit);
                index++;
            }
        }
        
        // Shuffle deck... Topcard is set in this method
        shuffle();

    }
    
    // This shuffle method goes thoroughly shuffles each 
    // card in the deck
    public void shuffle()
    {
        // Create a new deck that will be shuffled
        Card[] shuffleDeck = new Card[numCardsLeft];
        
        // It will need to be initialized, same as constructor
        int count = 0;
        for (int suit = 1; suit <= 4; suit++)
        {
            for (int value = 1; value <= 13; value++)
            {
                shuffleDeck[count] = new Card(value, suit);
                count++;
            }
        }
        
        // Random number generator
        Random rndgen = new Random(System.currentTimeMillis());
        
        // Track total number of cards
        int numberOfCards = numCardsLeft;
        // Loop for number of cards left
        for(int i = 0; i < numCardsLeft; i++)
        {
            //Generate next integer 0 to numCardsLeft
            int randNum = rndgen.nextInt(numberOfCards);
            
            // Copy random card into shuffled deck
            shuffleDeck[i] = cards[randNum];
            
            // Reset top card marker
            topCard = cards[numberOfCards-1];
            
            // Replace card copied to shuffled deck with deck
            cards[randNum] = topCard;
            
            // Decrement number of cards
            // This makes it so that top card isn't looked at anymore
            // otherwise there would be duplicates
            numberOfCards--;
  
        }
        
        // Copy shuffled deck into cards...
        cards = shuffleDeck;
        
        // Test if there is duplicates
        // if message doesn't print... youre good!
        // **Will move this into a test class
        for (int i = 0; i < 52; i++)
        {
            for (int j = 0; j < 52; j++)
            {
                if (cards[i] == cards[j] && i != j)
                {
                    System.out.println("duplicate...");
                }
            }
        }
    }
    
    public Card getTopCard()
    {
        // Create handle to store topCard
        Card oldTopCard = topCard;
        
        // Decrement the number of cards
        numCardsLeft--;

        // Set the topCard handle to the next card
        // Took away [numCardsLeft -1... Fixed bug in war...
        // that's scary... hahaha
        topCard = cards[numCardsLeft];
        
        // Return the stored topCard
        return oldTopCard;
    }

    public int getNumCardsLeft()
    {
        return numCardsLeft;
    }

    @Override
    public String toString()
    {
        String s = "Deck: \n";
        for (int i = 0; i < numCardsLeft; i++)
        {
            s = s + cards[i] + "\n";
        }
        return s;
    }

}
