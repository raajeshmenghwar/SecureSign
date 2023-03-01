import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class GUI_LogIn {
    JFrame frame = new JFrame("SecureSign");
    JTextField userRollNo = new JTextField(15);
    JTextField userPassword = new JTextField(15);
    JButton logIn = new JButton("LOG IN ");
    JButton back = new JButton("BACK ");
    GUI_LogIn(){

        frame.setLayout(null);
        frame.setSize(800,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JLabel rollNo = new JLabel("Roll No ");
        rollNo.setBounds(330,110,150,40);
        frame.add(rollNo);

        JLabel password = new JLabel("Password ");
        password.setBounds(330,150,150,40);
        frame.add(password);

        userRollNo.setBounds(400,110,150,30);
        userRollNo.addActionListener(this::loginAction);
        frame.add(userRollNo);

        userPassword.setBounds(400,150,150,30);
        userPassword.addActionListener(this::loginAction);
        frame.add(userPassword);

        back.setBounds(330,210,100,35);
        back.setFocusable(false);
        back.addActionListener(e->{
            frame.dispose();
            new SecureSign();
        });
        frame.add(back);

        logIn.setBounds(450,210,100,35);
        logIn.setFocusable(false);
        logIn.addActionListener(this::loginAction);
        frame.add(logIn);
        frame.setVisible(true);
    }

    public void loginAction(ActionEvent e) {
        {
            try {
                new Sql_Queries(userRollNo.getText(),userPassword.getText());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    }
}

