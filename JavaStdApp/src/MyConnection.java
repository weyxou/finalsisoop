import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

    public static Connection getConnection()
    {
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/final?allowPublicKeyRetrieval=true", "root", "Weyxou22@");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            con = null;
        }
        return con;
    }
}
