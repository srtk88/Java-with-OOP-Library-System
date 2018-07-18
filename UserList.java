import java.util.*;
/**
 *A class to hold details of user files.
 *This version can play the files.
 * @author (LO,KE-HSIN)
 * @version (Assignment 2017.11.24)
 */
public class UserList
{
    /**
     * An ArrayList for sotring the user files of user list.
     */
    private ArrayList <Users> userfiles;
    /**
     * Constructor for the user files.
     */
    public UserList()throws Exception
    {
        userfiles = new ArrayList<Users>();
    }

    /**
     *Add a user to the collection
     *@param users The users to be added 
     *@throws IllegalArgumentException when the users is null
     */
    public void add(Users users)throws Exception
    {
        if(users==null){
            throw new IllegalArgumentException("must not be null");
        }
        userfiles.add(users);
    }
    /**
     *Return the number of files in the collection.
     *@return The number of files in the collection.
     */
    public int size()
    {
        return userfiles.size();
    }
    /**
     *Searching the users from the users files By matching the username 
     *@param username The username to search the book
     *@throws IllegalArgumentException when the username is null or empty
     */
    public Users search(String username)throws Exception
    {
        if(username==null||username.equals("")){
            throw new IllegalArgumentException("must not be null or empty ");
        }
        for(Users y: userfiles){
            if(y.getUsername().equals(username)){
                return y;
            }
        
        }
        return null;
    }
    /**
     *Remave a user from the collection by matching the firstname of the collection.
     *If there is more than one user, then the error will occur
     *@param firstname The firstname of the collection to be removed
     *@throws IllegalArgumentException when one of two condition happen:not found or
     *multiple found of the same firstname of the collection
     */
    public void remove(String firstname)throws Exception 
    {
        Users z=null; 
        for(Users y: userfiles){
            if(y.getFirstname().equals(firstname)){
                if(z==null){
                    z=y;
                }
                else{
                     throw new Exception("multiple users with this firstname");
               }
            }
        }
        if(z!=null){
            userfiles.remove(z);
        }
        else{
            throw new Exception("users not found ");
        }
    }
   
}
