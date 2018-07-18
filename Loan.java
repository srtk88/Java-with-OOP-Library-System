
/**
 * The Loan class represents single loan record in a library system.
 *
 * @author (LO,KE-HSIN)
 * @version (a version number or a date)
 */
public class Loan
{
    private Users user ;
    private Books book;
    private String expiryDate;

    /**
     * Create a single loan record with a given user, book and expiry date
     */
    public Loan(Users user,Books book,String expiryDate)
    {
        this.user=user;
        this.book=book;
        this.expiryDate=expiryDate;
    }

    /**
     * @return the user 
     */
    public Users getUser()
    {
        
        return user;
    }
    /**
     * @return the book
     */
    public Books getBook()
    {
        
        return book;
    }
    /**
     * @return the expiry date
     */
    public String getExpiryDate()
    {
        
        return expiryDate;
    }
}
