
/**
 * The BorrowerInformation class hold the information of borrowers in a library system
 *
 * @author (Lo,Ke-HSIN)
 * @version (Assignment 2017.11.24)
 */
public class BorrowerInformation
{
    
    private String firstname;
    private String surname;
    private String emailAddress;

    /**
     * Constructor for the borrower information.
     */
    public BorrowerInformation(String firstname,String surname,String emailAddress)
    {
        
        this.firstname=firstname;
        this.surname=surname;
        this.emailAddress=emailAddress;
    }

    /**
     * @return the firstname of the borrower
     */
    public String getFirstname()
    {
        return firstname;
    }
    /**
     * @return the surname of the borrower
     */
    public String getSurname()
    {
        return surname;
    }
    /**
     * @return the email address of the borrower
     */
    public String getEmailAddress()
    {
        return emailAddress;
    }
}
