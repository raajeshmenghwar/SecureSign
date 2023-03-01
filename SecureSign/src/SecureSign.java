import javax.swing.*;
public class SecureSign {

    JFrame frame = new JFrame("SecureSign");
    JButton signup = new JButton("SIGN UP");
    JButton login = new JButton("LOG IN");

    SecureSign(){
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(800,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        login.setBounds(500,250,200,50);
        login.setOpaque(false);
        frame.add(login);
        login.addActionListener(e->{
            frame.dispose();
            new GUI_LogIn();
        });

        signup.setBounds(500,310,200,50);
        signup.setOpaque(false);
        frame.add(signup);
        signup.addActionListener(e->{
            frame.dispose();
            new GUI_SignUp();
        });
    }
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
         new SecureSign();

    }
}
