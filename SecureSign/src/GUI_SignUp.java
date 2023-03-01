import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class GUI_SignUp {
    JFrame frame = new JFrame("SecureSign");
    JTextField userRollNo = new JTextField(15);
    JTextField userFullName = new JTextField(15);
    JTextField userEmail = new JTextField(15);
    JTextField userPassword = new JTextField(15);
    JButton signup = new JButton("SIGN UP ");
    JButton back = new JButton("BACK");

    GUI_SignUp() {
        frame.setLayout(null);
        frame.setSize(800, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JLabel rollNo = new JLabel("Roll No ");
        rollNo.setBounds(330, 110, 150, 40);
        frame.add(rollNo);

        JLabel lname = new JLabel("Full Name ");
        lname.setBounds(630, 110, 150, 40);
        frame.add(lname);

        JLabel email = new JLabel("Email: ");
        email.setBounds(330, 150, 150, 40);
        frame.add(email);

        JLabel password = new JLabel("Password: ");
        password.setBounds(630, 150, 150, 40);
        frame.add(password);

        userRollNo.setBounds(400, 110, 150, 30);
        userRollNo.addActionListener(this::signInAction);
        frame.add(userRollNo);

        userFullName.setBounds(700, 110, 150, 30);
        userFullName.addActionListener(this::signInAction);
        frame.add(userFullName);

        userEmail.setBounds(400, 150, 150, 30);
        userEmail.addActionListener(this::signInAction);
        frame.add(userEmail);

        userPassword.setBounds(700, 150, 150, 30);
        userPassword.addActionListener(this::signInAction);
        frame.add(userPassword);

        signup.setBounds(700, 210, 150, 40);
        signup.setFocusable(false);
        signup.addActionListener(this::signInAction);
        frame.add(signup);

        back.setBounds(400, 210, 150, 40);
        back.setFocusable(false);
        back.addActionListener(e -> {
            frame.dispose();
            new SecureSign();
        });
        frame.add(back);
        frame.setVisible(true);
    }

    public void signInAction(ActionEvent e) {
        try {
            if (userFullName.getText() == null || userPassword.getText() == null
                    || userRollNo.getText() == null || userEmail.getText() == null) {
                JOptionPane.showMessageDialog(null, "Please fill all fields", "Alert", JOptionPane.WARNING_MESSAGE);
            } else
                new Sql_Queries(userRollNo.getText(), userFullName.getText(), userEmail.getText(), userPassword.getText());
            JOptionPane.showMessageDialog(null, "Data inserted successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    }
}
