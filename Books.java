/**
 * The Books class represents books in a library system.
 * It holds the book records relevant in our context.
 *
 * @author (LO,KE-HSIN)
 * @version (2017.11.24)
 */
public class Books
{
   /**
    * the book id
    */
    private int id;
    /**
    * the book title 
    */
    private String title;
    /**
    * the book author
    */
    private String author;
    /**
    * the book year
    */
    private int year;
    /**
    * the book title 
    */
    private String publisher;
    /**
    * the book number of copies
    */
    private int numOfCopies;
    /**
    * the book the available number of copies
    */
    private int availableNumberOfCopies;
    /**
    * the book publication date
    */
    private String publicationDate;
    
    /**
     * Create a new book record with a given random ID, title, author,year,publisher,available number of copies 
     * and publication date.
     */
    public Books(String title,String author,int year,String publisher,int availableNumberOfCopies,
    String publicationDate)throws Exception
    {
        id = (int)(Math.random() * 1000000000);
        this.setTitle(title);
        this.setAuthor(author);
        this.setYear(year);
        this.setPublisher(publisher);
        this.setAvailableNumberOfCopies(availableNumberOfCopies);
        this.numOfCopies = availableNumberOfCopies;
        this.setPublicationDate(publicationDate);
        
    }

    /**
     * set the title for the book record.
     * @param title The title for the book to set
     * @throws IllegalArgumentException when the bookTitle is null
     */
    public void setTitle(String title)throws Exception
    {
        
        if(title==null){
            throw new IllegalArgumentException("must not be null");
        }
        this.title = title;
        
    }
    /**
     * set the author for the book record.
     * @param author The author for the book to set
     * @throws IllegalArgumentException when the bookTitle is null
     */
    public void setAuthor(String author)throws Exception
    {
        
        if(author==null){
            throw new IllegalArgumentException("must not be null");
        }
        this.author = author;
        
    }
    /**
     * set the year for the book record.
     * @param year The year for the book to set
     */
    public void setYear(int year)
    {
        
        this.year = year;
        
    }
    /**
     * set the publisher for the book record.
     * @param publisher The publisher for the book to set
     * @throws IllegalArgumentException when the publisher is null
     */
    public void setPublisher(String publisher)throws Exception
    {
        if(publisher==null){
            throw new IllegalArgumentException("must not be null");
        }
        this.publisher = publisher;
    }
    /**
     * set the available number of copies for the book record.
     * @paramthe available number of copies The available number of copies for the book to set
     * @throws IllegalArgumentException when the available number of copies is less than zero
     */
    public void setAvailableNumberOfCopies(int availableNumberOfCopies)throws Exception
    {
        if(availableNumberOfCopies<0){
            throw new IllegalArgumentException("must not be larger than zero");
        }
        this.availableNumberOfCopies = availableNumberOfCopies;
        

    }
    /**
     * set the publication date for the book record.
     * @paramthe publicationDate The publication date for the book to set
     * @throws IllegalArgumentException when the publication date is null or not equals to 8 digits 
     */
    public void setPublicationDate(String publicationDate)throws Exception
    {
        if(publicationDate.length()!=8){
            throw new IllegalArgumentException("invalid date");
        }
        if(publicationDate==null){
            throw new IllegalArgumentException("must not be null");
        }
        
        this.publicationDate = publicationDate;

    }
    /**
     * @return the title 
     */
    public String getTitle()
    {
        return title;
    }
    /**
     * @return the author 
     */
    public String getAuthor()
    {
        return author;
    }
    /**
     * @return the year 
     */
    public int getYear()
    {
        return year;
    }
    /**
     * @return the publisher 
     */
    public String getPublisher()
    {
        return publisher;
    }
    /**
     * @return the  number of copies 
     */
    public int getNumOfCopies()
    {
        return numOfCopies;
    }
    /**
     * @return the available number of copies 
     */
    public int getAvailableNumberOfCopies()
    {
        return availableNumberOfCopies;
    }
    /**
     * @return the publication date 
     */
    public String getPublicationDate()
    {
        return publicationDate;
    }
    
    
}
       
