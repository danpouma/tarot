package tarot;

/**
 *
 * @author dpoumakis
 */
public class Main
{
    public static void main(String[] args)
    {
        Tarot tarot = new Tarot();
        
        tarot.initializeTable();
        
        for (int round = 0; round < 10; round++)
        {
            tarot.playRound();
        }
    }
}
