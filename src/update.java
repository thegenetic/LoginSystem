import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class update extends loginSystem{
    private JPanel u;
    private JTextField newtextField;
    private JPasswordField newpasswordField1;
    private JButton CHANGEButton;

    public update(){
        setContentPane(u);
        setTitle("UPDATE");
        setVisible(true);
        setLayout(null);
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CHANGEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    String user = update.super.textField1.getText();
                    String pass = String.valueOf(update.super.passwordField1.getPassword());


                    System.out.println(user + pass);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });
    }

    public static void main(String[] args) {
        new update();
    }
}
