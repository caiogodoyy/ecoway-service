import java.sql.*;
import java.util.logging.Logger;

public class DataAgent {
    Connection connection;
    private static final Logger log = Logger.getLogger(DataAgent.class.getName());


    // Establish a database connection
    public DataAgent() {
        String url = "link";
        String user = "user";
        String password = "password";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBuilding(int buildingCode, String name, String address, String neighborhood, int numApartments) {

        try {
            // Prepare a statement to insert a new building
            String command = "INSERT INTO buildings (buildingCode, name, address, neighborhood, numApartments) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(command);
            statement.setInt(1, buildingCode);
            statement.setString(2, name);
            statement.setString(3, address);
            statement.setString(4, neighborhood);
            statement.setInt(5, numApartments);

            // Execute the statement and close it
            statement.executeUpdate();
            statement.close();

            log.info(".addBuilding: done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTrash(int trashCode, String type, int maxCapacity, int currentCapacity, Building building) {

        try {
            // Prepare a statement to insert a new building
            String command = "INSERT INTO trash (trashCode, type, maxCapacity, currentCapacity, buildingCode) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(command);
            statement.setInt(1, trashCode);
            statement.setString(2, type);
            statement.setInt(3, maxCapacity);
            statement.setInt(4, currentCapacity);
            statement.setInt(5, building.getBuildingCode());

            // Execute the statement and close it
            statement.executeUpdate();
            statement.close();

            log.info(".addTrash: done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
