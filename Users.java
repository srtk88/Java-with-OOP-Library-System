
/**
 * The Users class represents users in a library system.
 * It holds the user records relevant in our context.
 *
 * @author (LO,KE-HSIN)
 * @version (Assignment 2017.11.24)
 */
public class Users
{
    /**
    * the username of the user
    */
    private String username;
    /**
    * the firstname of the user
    */
    private String firstname;
    /**
    * the surname of the user
    */
    private String surname;
    /**
    * the house number of the user
    */
    private int houseNumber;
    /**
    * the street name of the user
    */
    private String streetName;
    /**
    * the postcode of the user
    */
    private String postcode;
    /**
    * the email address of the user
    */
    private String emailAddress;
    /**
    * the date of birth of the user
    */
    private String dateOfBirth;
    

    /**
     * Create a new book record with a given random ID, title, author,year,publisher,available number of copies 
     * and publication date.
     */
    public Users(String username,String firstname,String surname,int houseNumber,String streetName,
    String postcode,String emailAddress,String dateOfBirth)throws Exception
    {
        this.username = username;
        this.firstname = firstname;
        this.surname = surname;
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.postcode = postcode;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        
    }

    /**
     * @return the username of a user
     */
    public String getUsername()
    {
        
        return username;
    }
    /**
     * @return the firstname of a user
     */
    public String getFirstname()
    {
        return firstname;
    }
    /**
     * @return the surname of a user
     */
    public String getSurname()
    {
        return surname;
    }
    /**
     * @return the house number of a user
     */
    public int getHouseNumber()
    {
        return houseNumber;
    }
    /**
     * @return the street name of a user
     */
    public String getStreetName()
    {
        return streetName;
    }
    /**
     * @return the postcode of a user
     */
    public String getPostcode()
    {
        return postcode;
    }
    /**
     * @return the email address of a user
     */
    public String getEmailAddress()
    {
        return emailAddress;
    }
    /**
     * @return the date of birth of a user
     */
    public String getDateOfBirth()
    {
        return dateOfBirth;
    }
    /**
     * set the username for the user record.
     * @paramthe username The username for the user to set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    /**
     * set the firstname for the user record.
     * @paramthe firstname The firstname for the user to set
     */
    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }
    /**
     * set the surname for the user record.
     * @paramthe surname The surname for the user to set
     */
    public void setSurname(String surname)
    {
        this.surname = surname;
    }
    /**
     * set the house number for the user record.
     * @paramthe housenumber The house number for the user to set
     * @throws IllegalArgumentException when the house number is less than zero
     */
    public void setHouseNumber(int houseNumber)throws Exception
    {
        if(houseNumber<0){
            throw new IllegalArgumentException("must not be larger than zero");
        }
        this.houseNumber = houseNumber;
        
    }
    /**
     * set the street name for the user record.
     * @paramthe streetName The street name for the book to set
     */
    public void setStreetname(String streetName)
    {
        this.streetName = streetName;
    }
    /**
     * set the postcode for the user record.
     * @paramthe postcode The street name for the user to set
     */
    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }
    /**
     * set the email address for the user record.
     * @paramthe emailAddress The email address for the user to set
     */
    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }
    /**
     * set the date of birth for the user record.
     * @paramthe dateOfBirth The date of birth for the user to set
     * @throws IllegalArgumentException when the date of birth is null or not equals to 8 digits.
     */
    public void setDateOfBirth(String dateOfBirth)throws Exception
    {
        if(dateOfBirth .length()!=8){
            throw new IllegalArgumentException("invalid date");
        }
        if(dateOfBirth==null){
            throw new IllegalArgumentException("must not be null");
        }
        this.dateOfBirth = dateOfBirth;
        
    }
    
    
    
}
