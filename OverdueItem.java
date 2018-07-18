
/**
 * The OverdueItem class hold the details of overdue items in a library system.
 *
 * @author (Lo,Ke-HSIN)
 * @version (Assignment 2017.11.24)
 */
public class OverdueItem
{
   
    private Books book;
    private String username;
    private String firstname;

    /**
     * Constructor for the overdue items
     */
    public OverdueItem(Books book, String username,String firstname)
    {
        // initialise instance variables
        this.book=book;
        this.username=username;
        this.firstname=firstname;
      
    }

    /**
     * @return the book
     */
   public Books getBook()
   {
       return book;
    }
    /**
     * @return the firstname 
     */
   public String getFirstname()
   {
        return firstname;
   }
   /**
     * @return the username
     */
   public String getUsername()
   {
        // put your code here
        return username;
   }
}
