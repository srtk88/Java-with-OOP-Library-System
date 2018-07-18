import java.util.*;
import java.util.*;
import java.util.*;
import java.util.*;
import java.util.*;
import java.util.*;
public class BookWindow extends EditWindow 
{
    private ArrayList<Books> books;
    private GUI gui;

    public BookWindow(ArrayList<Books> books, GUI gui)
    {
        super("Edit Books");
        this.books = books;
        this.gui = gui;
        addField("Title");
        addField("Author");
        addField("Year");
        addField("Publisher");
        addField("Number of Copies");
        addField("Publication Date");
        addFields();
    }

    protected int getNumOfData() 
    {
        return books.size();
    }

    protected void displayData() 
    {
        if(getIndex() < 0){
            super.displayData();
        }
        else{
            Books b = books.get(getIndex());
            setField(0, b.getTitle());
            setField(1, b.getAuthor());
            setField(2, "" + b.getYear());
            setField(3, b.getPublisher());
            setField(4, "" + b.getNumOfCopies());
            setField(5, b.getPublicationDate());
        }
    }

    protected void removeData() 
    {
        books.remove(getIndex());
    }

    protected boolean newData() 
    {
        Books b;
        try{
            b = new Books(
            getField(0),
            getField(1),
            Integer.parseInt(getField(2)),
            getField(3),
            Integer.parseInt(getField(4)),
            getField(5));
        } 
        catch(Exception e) {
            GUI.showErrMessage(e);
            return false;
        }
        books.add(b);
        return true;
    }

    protected boolean saveToMemory() 
    {
        Books b = books.get(getIndex());
        try {
            b.setTitle(getField(0));
            b.setAuthor(getField(1));
            b.setYear(Integer.parseInt(getField(2)));
            b.setPublisher(getField(3));
            b.setAvailableNumberOfCopies(Integer.parseInt(getField(4)));
            b.setPublicationDate(getField(5));
        } 
        catch(Exception e) {
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

