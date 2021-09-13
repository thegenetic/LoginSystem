import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class loginSystem extends JFrame{
//    private HashMap<String, String> map= new HashMap<String, String>();
    private JPanel mainPanel;
    public JTextField textField1;
    private JButton LOGINButton;
    private JButton RESETButton;
    public JPasswordField passwordField1;
    private JButton CREATE_ACCOUNTButton;
    private JCheckBox showPasswordCheckBox;
    private String user = null;
    private String pass = null;

//    String sql;

    private Connection getConnection(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/login", "root", "");

            return con;
        }
        catch (ClassNotFoundException | SQLException ex){
            return null;
        }

    }

    public loginSystem(){


        setContentPane(mainPanel);
        setTitle("LOGIN SYSTEM");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,500);
        

        Connection con = getConnection();
        fetchLoginData();

        RESETButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textField1.setText("");
                passwordField1.setText("");
            }
        });

        CREATE_ACCOUNTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    user = textField1.getText();
                    pass = String.valueOf(passwordField1.getPassword());



//                ###connections#####
                if (con != null) {

                    try {
                        String sql = "INSERT INTO tbl_login(name, password) VALUES (?,?)";

                        PreparedStatement st = null;
                        st = con.prepareStatement(sql);
                        st.setString(1, user);
                        st.setString(2, pass);
                        int rowCount = st.executeUpdate();
                        if (rowCount != 0) {

                            fetchLoginData();

                            JOptionPane.showMessageDialog(null, "Account Created");


                        } else {
                            JOptionPane.showMessageDialog(null, "Username already taken");
                        }

                    }

                    catch (SQLException sqle) {
                        JOptionPane.showMessageDialog(null, "Username already taken");
                    }


                } else {
                    JOptionPane.showMessageDialog(null, "Connection error");
                }


            }
        });

        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = String.valueOf(passwordField1.getPassword());

                if (showPasswordCheckBox.isSelected()){
                    passwordField1.setEchoChar((char) 0);
                }
                else {
                    passwordField1.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
                }
            }
        });

        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                try{

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/login", "root", "");

                    String user = textField1.getText();
                    String pass = String.valueOf(passwordField1.getPassword());
                    try{
                    String sql = "select * from tbl_login where `name` =? AND `password` =?";
                    PreparedStatement st = con.prepareStatement(sql);
                    st.setString(1, user);
                    st.setString(2,pass);

                    ResultSet rs = st.executeQuery();

                    if(rs.next()){
                        welcom w = new welcom();

                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Please check you username and password again");
                        textField1.setText("");
                        passwordField1.setText("");
                    }
                    }
                    catch (Exception h){
                        System.out.println(h.getMessage());
                    }


                }
                catch (Exception ex){
                    System.out.println(ex.getMessage());
                }

            }
        });

    }

    private void fetchLoginData(){
        Connection con = getConnection();

        if (con != null){
            String[] column = {"name", "password"};

            DefaultTableModel model= new DefaultTableModel();
            model.setColumnIdentifiers(column);

            try{
                String sql ="SELECT * FROM `tbl_login`";
                PreparedStatement st = null;
                st = con.prepareStatement(sql);

                ResultSet rs = st.executeQuery(sql);

                while(rs.next()){
                    Object[] ob = new Object[]{rs.getString(1), rs.getString(2)};

//                    map.put(rs.getString("name"), rs.getString("password"));
                    model.addRow(ob);

                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }

    public static void main(String[] args) {
        new loginSystem();
    }
}
