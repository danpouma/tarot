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
        
        System.out.println("Cards before replacement...");
        for (int i = 0; i < 9; i++)
        {
            tarot.printCard(i);
        }
        System.out.println("*END*");
        
        tarot.replaceCard(3, test);
        
        System.out.println("Cards after replacement...");
        for (int i = 0; i < 9; i++)
        {
            tarot.printCard(i);
        }
        System.out.println("*END*");
    }
}
