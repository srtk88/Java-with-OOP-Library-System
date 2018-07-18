import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class GUI
{
    private String fileName = "data.txt";
    private String account = "xxxxx";
    private String password = "12345";
    private ArrayList<Books> books;
    private BookWindow bookWindow;
    private ArrayList<Users> users;
    private UserWindow userWindow;
    public static void main(String[] args) 
    {
        new GUI().run();
    }

    private static void addExitOnClosing(JFrame frame) 
    {
        frame.addWindowListener(
            new WindowAdapter() 
            {
                public void windowClosing(WindowEvent e) 
                {
                    System.exit(0);
                }
            });
    }

    public static void adjustBounds(JFrame frame) 
    {
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public static JButton newJButton(String text, ActionListener al) 
    {
        JButton btn = new JButton(text);
        btn.addActionListener(al);
        return btn;
    }

    public static void showErrMessage(Object msg) 
    {
        JOptionPane.showMessageDialog(null, msg, null, JOptionPane.ERROR_MESSAGE);
    }

    public static void showInfoMessage(Object msg) 
    {
        JOptionPane.showMessageDialog(null, msg, null, JOptionPane.INFORMATION_MESSAGE);
    }
    public void run() 
    {
        showLoginWindow();
    }

    private void showLoginWindow() 
    {
        JFrame frame = new JFrame("Login");
        addExitOnClosing(frame);
        Container cp = frame.getContentPane();
        cp.setLayout(new GridLayout(5, 1));
        cp.add(new JLabel("Account"));
        JTextField txtAccount = new JTextField();
        cp.add(txtAccount);
        cp.add(new JLabel("Password"));
        JPasswordField txtPassword = new JPasswordField();
        cp.add(txtPassword);
        cp.add(
            newJButton(
                "Login",
                new ActionListener() 
                {
                    public void actionPerformed(ActionEvent e) 
                    {
                        if(txtAccount.getText().equals(account)&&txtPassword.getText().equals(password)){
                            frame.setVisible(false);
                            showInfoMessage("Congratulations!");
                            initialize();
                            showMainWindow();
                        }
                        else{
                            GUI.showErrMessage(
                                    "The account or password you typed is incorrect. " +
                                    "Please try again.");
                        }
                    }
                }));
        adjustBounds(frame);
        frame.setVisible(true);
    }

    private void initialize()
    {
        books = new ArrayList<>();
        users = new ArrayList<>();
        loadFromFile();
        bookWindow = new BookWindow(books, this);
        userWindow = new UserWindow(users, this);
    }

    private void loadFromFile()
    {
        FileReader f;
        try{
            f = new FileReader(fileName);
        }
        catch(FileNotFoundException e){
            showInfoMessage(
                "File '" + fileName + "' not found. Will create one later.");
            return;
        }
        try{
            Scanner s = new Scanner(f);
            int nbooks = Integer.parseInt(s.nextLine());
            while(nbooks > 0){
                nbooks = nbooks - 1;
                String title = s.nextLine();
                String author = s.nextLine();
                int year = Integer.parseInt(s.nextLine());
                String publisher = s.nextLine();
                int numOfCopies = Integer.parseInt(s.nextLine());
                String publicationDate = s.nextLine();
                books.add(
                    new Books(title, author, year, publisher, numOfCopies, publicationDate));
            }

            int nusers = Integer.parseInt(s.nextLine());
            while(nusers > 0){
                nusers = nusers - 1;
                String username = s.nextLine();
                String firstname = s.nextLine();
                String surname = s.nextLine();
                int houseNumber = Integer.parseInt(s.nextLine());
                String streetName = s.nextLine();
                String postcode = s.nextLine();
                String emailAddress = s.nextLine();
                String dateOfBirth = s.nextLine();
                users.add(new Users(username, firstname, surname, houseNumber, 
                streetName, postcode,emailAddress, dateOfBirth));
            }

            s.close();
            f.close();
       } 
       catch(Exception e) {
       showErrMessage(e);
       System.exit(1);
       }
  }

  public void saveToFile() 
  {
      try {
          FileWriter f = new FileWriter(fileName);
          PrintWriter p = new PrintWriter(f);

          p.println(books.size());
          for(Books b : books){
            p.println(b.getTitle());
            p.println(b.getAuthor());
            p.println(b.getYear());
            p.println(b.getPublisher());
            p.println(b.getNumOfCopies());
            p.println(b.getPublicationDate());
          }

          p.println(users.size());
          for(Users u : users){
            p.println(u.getUsername());
            p.println(u.getFirstname());
            p.println(u.getSurname());
            p.println(u.getHouseNumber());
            p.println(u.getStreetName());
            p.println(u.getPostcode());
            p.println(u.getEmailAddress());
            p.println(u.getDateOfBirth());
          }

      p.close();
      f.close();
      }catch(Exception e) {
          showErrMessage(e);
          System.exit(1);
      }
  }

  private void showMainWindow() 
  {
      JFrame frame = new JFrame("Main");
      addExitOnClosing(frame);
      Container cp = frame.getContentPane();
      cp.setLayout(new GridLayout(2, 1));
      cp.add(
         newJButton(
            "Edit Books",
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    bookWindow.setVisible(true);
                }
            }));
       cp.add(
          newJButton(
             "Edit Users",
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    userWindow.setVisible(true);
                }
            }));
      adjustBounds(frame);
      frame.setVisible(true);
  }

}
