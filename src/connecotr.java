import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connecotr {
    JFrame frame;

    private Connection getConnection(){
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/christmas", "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }

    public connecotr(){
        frame = new JFrame();

        String [] coloumn = { "s.no", "name", "gift"};

        Connection con = getConnection();

        JTable table = new JTable();

        table.setBounds(30, 40, 200, 300);

        if (con!= null){
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(coloumn);

            try {
                String sql = "SELECT * FROM tbl_chris";

                Statement st = null;
                st = con.createStatement();

                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    //                System.out.println(rs.getString("test_id")+" "+rs.getString("name") + rs.getString("age") + rs.getString("roll_no"));

                    Object[] ob = new Object[]{rs.getString("s.no"), rs.getString("name"), rs.getString("gift")};

                    model.addRow(ob);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            table.setModel(model);
        } else {
            JOptionPane.showMessageDialog(frame, "Connection error");
        }

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        frame.setSize(300, 400);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new connecotr();
    }


}
