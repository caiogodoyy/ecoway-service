import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DataAgent {
    private Building building;
    private Connection connection;
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

    public void addBuilding(int buildingCode, String name, String address, String region, int numApartments) {

        try {
            // Prepare a statement to insert a new building
            String command = "INSERT INTO buildings (buildingCode, name, address, region, numApartments) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(command);
            statement.setInt(1, buildingCode);
            statement.setString(2, name);
            statement.setString(3, address);
            statement.setString(4, region);
            statement.setInt(5, numApartments);

            // Execute the statement and close it
            statement.executeUpdate();
            statement.close();

            log.info(".addBuilding: done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTrash(int trashCode, String type, float maxCapacity, float currentCapacity, int buildingCode) {

        try {
            // Prepare a statement to insert a new trash
            String command = "INSERT INTO trash (trashCode, type, maxCapacity, currentCapacity, buildingCode) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(command);
            statement.setInt(1, trashCode);
            statement.setString(2, type);
            statement.setFloat(3, maxCapacity);
            statement.setFloat(4, currentCapacity);
            statement.setInt(5, buildingCode);

            // Execute the statement and close it
            statement.executeUpdate();
            statement.close();

            log.info(".addTrash: done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCurrentCapacity(float increaseOfTheDay, int buildingCode) {

        try {
            // Prepare a statement to update a trash current capacity
            String command = "UPDATE trash SET currentCapacity = currentCapacity + ? WHERE buildingCode = ?";
            PreparedStatement statement = connection.prepareStatement(command);
            statement.setFloat(1, increaseOfTheDay);
            statement.setInt(2, buildingCode);

            // Execute the statement and close it
            statement.executeUpdate();
            statement.close();

            log.info(".updateCurrentCapacity: done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Building getBuilding(int buildingCode) {

        Building result = null;
        try {
            // Prepare a statement to get a building
            String command = "SELECT * FROM buildings WHERE buildingCode = ?";
            PreparedStatement statement = connection.prepareStatement(command);
            statement.setInt(1, buildingCode);

            // Execute the statement and close it
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                // The building was found
                String name = rs.getString("name");
                String address = rs.getString("address");
                String region = rs.getString("region");
                int numApartments = rs.getInt("numApartments");
                result = new Building(buildingCode, name, address, region, numApartments);
                log.info(".getBuilding: done");
            } else {
                log.info(".getBuilding: building code [" + buildingCode + "] was not found");
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Trash> getTrashTypeList(String type) {

        List<Trash> result = new ArrayList<>();
        try {
            // Prepare a statement to get a trash list
            String command = "SELECT * FROM trash WHERE type = ?";
            PreparedStatement statement = connection.prepareStatement(command);
            statement.setString(1, type);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                // A trash was found
                int trashCode = rs.getInt("trashCode");
                float maxCapacity = rs.getFloat("maxCapacity");
                float currentCapacity = rs.getFloat("currentCapacity");
                int buildingCode = rs.getInt("buildingCode");
                building = getBuilding(buildingCode);
                result.add(new Trash(trashCode, type, maxCapacity, currentCapacity, building));
            }
            if (result.isEmpty())
                log.info(".getTrashTypeList: trash type [" + type + "] was not found");
            else
                log.info(".getTrashTypeList: done");
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
