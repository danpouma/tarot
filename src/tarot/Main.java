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
        
        Card test = new Card(12,3);
        
        tarot.initializeTable();
        
        tarot.replaceCard(3, test);
    }
}
