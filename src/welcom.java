import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class welcom extends JFrame{
    private JPanel m;
    private JButton updateButton;

    public welcom (){
        setContentPane(m);
        setTitle("FINALLY LOGGED IN :)");
        setVisible(true);
        setLayout(null);
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update u = new update();

//                try{
//                    String user = welcom.super.textField1.getText();
//                    String pass = String.valueOf(welcom.super.passwordField1.getPassword());
//                    Class.forName("com.mysql.cj.jdbc.Driver");
//                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/login", "root", "");
//
//                    Statement st = con.createStatement();
//
//                    String sql = "UPDATE `tbl_login` SET `name`='"+user+",`password`="+pass+"'";
//
//                }
//                catch (Exception ex){
//                    ex.printStackTrace();
//                }
            }
        });

    }

    public static void main(String[] args) {
        new welcom();
    }
}
