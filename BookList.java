import java.util.*;
/**
 *A class to hold details of book files.
 *This version can play the files.
 *
 * @author (LO,KE-HSIN)
 * @version (Assignment 2017.11.20)
 */

public class BookList
{
    /**
     * An ArrayList for sotring the book files of booklist.
     */
    private ArrayList<Books>bookfiles;
   

    /**
     * Constructor for the book files.
     */
    public BookList()throws Exception
    {
        
       bookfiles = new ArrayList<Books>();
    }

    /**
     *Add a book to the collection
     *@param books The books to be added 
     *@throws IllegalArgumentException when the books is null
     */
    public void add(Books books)throws Exception
    {
        
        if(books==null){
            throw new IllegalArgumentException("must not be null");
        }
        bookfiles.add(books);
    }
    /**
     *Return the number of files in the collection.
     *@return The number of files in the collection.
     */
    public int size()
    {
        return bookfiles.size();
    }
    /**
     *Searching the books from the book files By matching the keyword with title,author,publisher or publication date
     *@param keyword The keyword to search the book
     *@throws IllegalArgumentException when the keyword is null or empty
     */
    public Books search(String keyword)throws Exception
    {
        
        if(keyword==null||keyword.equals("")){
            throw new IllegalArgumentException("must not be null or empty ");
        }
        for(Books x : bookfiles){
            boolean match = true;
            if(x.getTitle().equals(keyword)){
                return x;
            }
            if(x.getAuthor().equals(keyword)){
                return x;
            }
            if(x.getPublisher().equals(keyword)){
                return x;
            }
            if(x.getPublicationDate().equals(keyword)){
               return x;
            }
            
            
        }
        return null;
    }
    /**
     *Remave a book from the list by matching the title of the book If there is mare than one book, then the error will occur
     *@param title The title of the book to be removed
     *@throws IllegalArgumentException when  one of two condition happen:not found or
     *multiple found of the same title of the book
     */
    public void remove(String title)throws Exception 
    {
        Books z=null; 
        for(Books y: bookfiles){
            if(y.getTitle().equals(title)){
                if(z==null){
                    z=y;
                }
                else{
                     throw new Exception("multiple books with this title");
               }
            }
        }
        if(z!=null){
            bookfiles.remove(z);
        }
        else{
            throw new Exception(" not found ");
        }
    }
    
}
