import java.sql.*;

public class DataAgent {

    // Establish a database connection
    public DataAgent() {
        String url = "link_bd";
        String user = "user";
        String password = "password";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


}
