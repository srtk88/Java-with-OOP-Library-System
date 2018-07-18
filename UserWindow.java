import java.util.*;
public class UserWindow extends EditWindow 
{
    private ArrayList<Users> users;
    private GUI gui;
    public UserWindow(ArrayList<Users> users, GUI gui) 
    {
        super("Edit Users");
        this.users = users;
        this.gui = gui;
        addField("User Name");
        addField("First Name");
        addField("Surname");
        addField("House Number");
        addField("Street Name");
        addField("Post Code");
        addField("Email Address");
        addField("Birth Date");
        addFields();
    }

    protected int getNumOfData() 
    {
        return users.size();
    }

    protected void displayData() 
    {
        if(getIndex() < 0){
            super.displayData();
        } 
        else{
            Users u = users.get(getIndex());
            setField(0, u.getUsername());
            setField(1, u.getFirstname());
            setField(2, u.getSurname());
            setField(3, "" + u.getHouseNumber());
            setField(4, u.getStreetName());
            setField(5, u.getPostcode());
            setField(6, u.getEmailAddress());
            setField(7, u.getDateOfBirth());
        }
    }

    protected void removeData() 
    {
        users.remove(getIndex());
    }

    protected boolean newData() 
    {
        Users u;
        try{
            u = new Users(
                getField(0),
                getField(1),
                getField(2),
                Integer.parseInt(getField(3)),
                getField(4),
                getField(5),
                getField(6),
                getField(7));
        } 
        catch(Exception e){
            GUI.showErrMessage(e);
            return false;
        }
        users.add(u);
        return true;
    }

    protected boolean saveToMemory() 
    {
        Users u = users.get(getIndex());
        try{
            u.setUsername(getField(0));
            u.setFirstname(getField(1));
            u.setSurname(getField(2));
            u.setHouseNumber(Integer.parseInt(getField(3)));
            u.setStreetname(getField(4));
            u.setPostcode(getField(5));
            u.setEmailAddress(getField(6));
            u.setDateOfBirth(getField(7));
        }catch(Exception e){
            GUI.showErrMessage(e);
            return false;
        }
        return true;
    }

    protected void saveToFile() 
    {
        gui.saveToFile();
    }
}

