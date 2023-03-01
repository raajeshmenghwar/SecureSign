import java.sql.*;
class ConnectionDB {
    static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String user = "raju";
    static final String password = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
    /*8 public static void main(String args[]){
        try{
//step1 load the driver class  


//step2 create  the connection object  
//Connection con=DriverManager.getConnection(url,user,password);

//step3 create the statement object
            Connection con = DBC.connection();
            Connection con = ConnectionDB.();
            Statement stmt=getConnection.createStatement();

//step4 execute query  
            ResultSet rs=stmt.executeQuery("select * from emp");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

//step5 close the connection object  
            con.close();

        }catch(Exception e){ System.out.println(e);}

    }}*/