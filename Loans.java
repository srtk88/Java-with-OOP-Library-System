import java.util.ArrayList;
/**
 * The Loans class represents multiple loan records in a library system.
 *
 * @author (LO,KE-HSIN)
 * @version (Assignment 2017.11.24)
 */
public class Loans
{
    /**
     * An ArrayList for sotring the loan files of loan lists
     */
    private ArrayList<Loan> loanfiles;
    
    /**
     * Constructor for the loan files.
     */
    public Loans()
    {
       
        loanfiles=new ArrayList<Loan>();
    }
    /**
     * Write the record for a user to borrow a book 
     * @param users,books The users to borrow
     * @param books The books to borrow
     * @param expiryDate The expiryDate to borrow
     * @throws IllegalArgumentException when users and books are null.
     */
    public void borrow(Users users,Books books,String expiryDate)throws Exception
    {
        if(users==null||books==null){
            throw new IllegalArgumentException("must not be null");
        }
        books.setAvailableNumberOfCopies(books.getAvailableNumberOfCopies() - 1);
        Loan l= new Loan(users,books,expiryDate);
        loanfiles.add(l);
        
    }
    /**
     * Remove a record for a user to borrow a book
     * @param users,books The users to return
     * @param books The books to return
     * @throws IllegalArgumentException when the user has not borrowed the book.
     */
    public void returnBook(Users users,Books books)throws Exception
    {
        
        for(Loan l:loanfiles){
            
            if(l.getUser()==users&&l.getBook()==books){
                books.setAvailableNumberOfCopies(books.getAvailableNumberOfCopies()+1);  
                loanfiles.remove(l);
                return;
            
            }
        }
        throw new IllegalArgumentException("the user has not borrowed the book.");
    }
    /**
     *Count the total number of books for a user to borrow a book
     *@param users The user
     *throws IllegalArgumentException when the users is null
     */
    public int countBooksOfUsers(Users users)
    {
        if(users==null){
            throw new IllegalArgumentException("must not be null");
        }
        int count=0;
        for(Loan l:loanfiles){
            if(l.getUser()==users){
                count=count+1;
                
            }
        }
        return count;
    }
    /**
    *Return all the overdue books along with the users’ username and firstname.
    *@param currentDate Today's date
    *@return list of book's description along with the username and firstname of the user who borrow the book
    */
    public ArrayList<OverdueItem> getOverdueItems(String currentDate)
    {
        ArrayList<OverdueItem>o=new ArrayList<OverdueItem>();
        for(Loan l:loanfiles){
            if(currentDate.compareTo(l.getExpiryDate())>0){
               OverdueItem oi = new OverdueItem(l.getBook(),l.getUser().getUsername(),l.getUser().getFirstname());
               o.add(oi);
                
            }
        }
        return o;
    }
    /**
    *Return those books that are borrowed by more than one User
    *@return the popular books which are borrowed by more than one User
    */
    public ArrayList<Books> getPopularBooks()
    {
        ArrayList<Books>p=new ArrayList<Books>();
        for(Loan l:loanfiles){
            int count=0;
            int rank=0;
            boolean multiple=false;
            for(Loan m:loanfiles){
                if(m.getBook() == l.getBook()){
                    count++;
                    if(m == l){
                        rank = count;
                    }
                    if(m.getUser() != l.getUser()){
                        multiple = true;
                   
                   
                    }
                }
            }
           
           if(multiple && rank ==1 ) p.add(l.getBook());
        }   
        return p;
    }
    /**
    *return the firstname, surname and email address name of a borrower of a given book.
    *@param books The book that user borrow
    *@return the users information
    */
    public BorrowerInformation getBorrower(Books book)
    {
        
        for(Loan b:loanfiles){
            if(b.getBook()==book){
                Users u = b.getUser();
                BorrowerInformation BI=new BorrowerInformation(u.getFirstname(),u.getSurname(),u.getEmailAddress());
                return BI;
                
            }
            
            
        }
        
        return null;
        
    }
    
}
    

 
  
