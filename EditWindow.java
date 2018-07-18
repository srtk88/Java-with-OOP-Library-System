import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class EditWindow extends JFrame 
{
    private JLabel lblIndex;
    private JPanel table;
    private ArrayList<String> descriptions;
    private ArrayList<JTextField> fields;
    private int index;

    public EditWindow(String title) 
    {
        super(title);
        Container cp = getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        buttons.add(
            GUI.newJButton(
                "<",
                new ActionListener()
                {
                   public void actionPerformed(ActionEvent e)
                   {
                       if(index > 0){
                            setIndex(index - 1);
                            displayData();
                       }
                    }
                }));
        buttons.add(
            GUI.newJButton(
                ">",
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e) 
                    {
                        if(index + 1 < getNumOfData()) {
                            setIndex(index + 1);
                            displayData();
                        }
                    }
                }));
        buttons.add(
            GUI.newJButton(
                "+",
                new ActionListener() 
                {
                    public void actionPerformed(ActionEvent e) 
                    {
                        if(newData()){
                            setIndex(getNumOfData() - 1);
                            saveToFile();
                        }
                    }
                }));
        buttons.add(
            GUI.newJButton(
                 "-",
                 new ActionListener() 
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(index >= 0){
                            removeData();
                            setIndex(index - 1);
                            if(index < 0 && getNumOfData() > 0) {
                                setIndex(0);
                            }
                            displayData();
                            saveToFile();
                        }
                    }
                }));
        buttons.add(
            GUI.newJButton(
               "Save",
                new ActionListener() 
                {
                    public void actionPerformed(ActionEvent e) 
                    {
                        if(index < 0) {
                            GUI.showErrMessage("To add a record, click + button.");
                        }else if(saveToMemory()) {
                            saveToFile();
                        }
                    }
                }));
        cp.add(buttons);
        lblIndex = new JLabel("0/0");
        cp.add(lblIndex);
        table = new JPanel();
        cp.add(table);
        descriptions = new ArrayList<>();
        fields = new ArrayList<>();
        index = -1;
    }

    protected void addField(String description) 
    {
        descriptions.add(description);
    }

    protected void addFields() 
    {
        table.setLayout(new GridLayout(descriptions.size(), 2));
        for(String description : descriptions) {
            JTextField txt = new JTextField();
            fields.add(txt);
            table.add(new JLabel(description));
            table.add(txt);
        }
        GUI.adjustBounds(this);
        if(getNumOfData() > 0){
        setIndex(0);
        }
        displayData();
    }

    protected String getField(int index) 
    {
        return fields.get(index).getText();
    }

    private void setIndex(int idx) 
    {
        index = idx;
        lblIndex.setText((idx + 1) + "/" + getNumOfData());
    }

    protected void setField(int index, String text) 
    {
        fields.get(index).setText(text);
    }

    protected int getIndex() 
    {
        return index;
    }

    protected int getNumOfData()
    {
        return 0;
    }

    protected void displayData() 
    {
        for(JTextField txt : fields) {
            txt.setText("<no data>");
        }
    }

    protected void removeData()
    {
    }

    protected boolean newData() 
    {
        return false;
    }

    protected boolean saveToMemory()
    {
        return false;
    }

    protected void saveToFile() 
    {
    }
}
