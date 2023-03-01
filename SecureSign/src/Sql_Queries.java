import javax.swing.*;
import java.sql.*;

public class Sql_Queries {
    Connection con = ConnectionDB.getConnection();
    Sql_Queries(String userRollNo, String userFullName, String userEmail, String password) throws SQLException {

        //step3 create the statement object
        // Statement stmt=con.createStatement();
        String insertIntoTable = "INSERT INTO REGISTRATION VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(insertIntoTable);

            preparedStatement.setString(1, userRollNo);
            preparedStatement.setString(2, userFullName);
            preparedStatement.setString(3, userEmail);
            preparedStatement.setString(4, password);

            preparedStatement.executeUpdate();
            con.close();
    }

    Sql_Queries(String userRollNo, String password) throws SQLException {
            String selectQuery = "SELECT ROLLNO , PASSWORD FROM REGISTRATION " +
                    "WHERE ROLLNO= \'" + userRollNo +  "\' AND PASSWORD = \'" + password + "\'" ;
            //step4 execute query
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);

        boolean isPresent = false;
        while (resultSet.next()) {
            if (resultSet.getString(1).equalsIgnoreCase(userRollNo)
                    && resultSet.getString(2).equals(password) ) {
                isPresent = true;
                JOptionPane.showMessageDialog(null,
                        "Logged In successfully",
                        "Login",JOptionPane.DEFAULT_OPTION);
            }
        }

        if(! isPresent) {
            JOptionPane.showMessageDialog(null,
                    "Incorrect information or Signed In first",
                    "Alert",JOptionPane.WARNING_MESSAGE);
        }

        con.close();
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    }
}
