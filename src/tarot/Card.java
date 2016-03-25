package tarot;

/**
 *
 * @author dpoumakis
 * @date 2/8/2016
 */
public class Card
{
    public static final int SWORDS = 1;
    public static final int WANDS = 2;
    public static final int COINS = 3;
    public static final int CUPS = 4;

    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 1;

    private int suit;
    private int face;
    
    // Track number of cards... Used for ID.
    private int id;
    private static int counter = 0;

    // Is this even worth having? perhaps make
    // an algorithim that wont give repeats
    public Card()
    {
        this.id = counter++;
        this.face = ACE;
        this.suit = CUPS;
    }

    public Card(int face, int suit)
    {
        this.id = counter++;
        this.face = face;
        this.suit = suit;
    }
    
    public boolean equals(Card other)
    {
        boolean suitMatched = (this.suit == other.getSuitValue());
        boolean faceMatched = (this.face == other.getFaceValue());
        boolean isEqual = (suitMatched && faceMatched);
        
        return isEqual;
    }

    public boolean faceEquals(Card other)
    {
        return this.face == other.getFaceValue();
    }

    // Accessors for suit, face and id
    public int getSuitValue()
    {
        return suit;
    }

    public int getFaceValue()
    {
        // This modifcation is for war
        int f = this.face;
        
        if (f == ACE)
        {
            f = 14;
        }
        
        return f;
    }
    
    public int getId()
    {
        return this.id;
    }

    // Mutators for suit, face and id
    public void setSuit(int suit)
    { //test for valid data
        if (suit == SWORDS || suit == WANDS || suit == COINS || suit == CUPS)
        {
            this.suit = suit;
        } 
        else
        {
            //the input is invalid
        }
    }

    public void setFace(int face)
    {
        if (face >= 2 && face <= 10)
        {
            this.face = face;
        } 
        else if (face == ACE || face == KING || face == QUEEN || face == JACK)
        {
            this.face = face;
        } 
        else
        {
            ; //the input is invalid
        }
    }
    
    public void setId(int id)
    {
        this.id = id;
    }

    // Convert the suit value to a string
    public String getSuitString()
    {
        String s = "";
        switch (suit)
        {
            case SWORDS:
                s = "Swords";
                break;
            case WANDS:
                s = "Wands";
                break;
            case COINS:
                s = "Coins";
                break;
            case CUPS:
                s = "Cups";
                break;
            default:
                ;
        }
        return s;
    }

    // Convert the face value to a string
    public String getFaceString()
    {
        String f = ""; 
        switch (face)
        {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                f = face + "";
                break;
            case JACK:
                f = "Jack";
                break;
            case QUEEN:
                f = "Queen";
                break;
            case KING:
                f = "King";
                break;
            case ACE:
                f = "Ace";
                break;
            default:
                System.out.println("Invalid face value, this shouldn't print");
                break;
        }
        return f;
    }

    @Override
    public String toString()
    {
        String s;
        s = getFaceString() + " of " + getSuitString();
        return s;
    }

}
