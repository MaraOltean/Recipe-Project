package org.example;

import java.sql.*;

public class ConnectDataBase {
    public static void connect() throws SQLException {
        Connection connection = null;

        try{
            String url = "jdbc:sqlite:C:/sqlite/ReceipeDataBase/recipe.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite successfully :)");
        }
        catch (SQLException e){

            System.out.println(e.getMessage());
        }
        displayDatabase(connection, "user");
       // insertData(connection, "user", (new User(5, "Mara", "Oltean", Gender.F, 24, 1.64, 53, 1.5)) );

        if (connection!=null){
            connection.close();
        }

}
    private static void displayDatabase(Connection conn, String tableName) throws SQLException {
        String selectSQL = "SELECT * FROM " + tableName;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectSQL);
        System.out.println("TABLE: " + tableName);
        while(rs.next()) {
            System.out.println("Id: " + rs.getLong("id"));
            System.out.println("First name: " + rs.getString("firstName"));
            System.out.println("Last name: " + rs.getString("lastName"));
            System.out.println("Height: " + rs.getDouble("height"));
            System.out.println("Weight: " + rs.getDouble("weight"));
            System.out.println("Gender: " + rs.getString("gender"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("Activity factor: " + rs.getDouble("activityFactor"));
        }
    }
    private static void insertData(Connection connection, String tableName, User user) throws SQLException{
        String insertSQL = "INSERT INTO " + tableName + "(id,firstName,lastName,height,weight,gender,age,activityFactor) " + "VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
        preparedStatement.setLong(1, user.getID());
        preparedStatement.setString(2, user.getFirstName());
        preparedStatement.setString(3, user.getLastName());
        preparedStatement.setDouble(4, user.getHeight());
        preparedStatement.setDouble(5, user.getWeight());
        preparedStatement.setString(6, user.getGender().name());
        preparedStatement.setInt(7, user.getAge());
        preparedStatement.setDouble(8, user.getActivityFactor());

        preparedStatement.executeUpdate();


    }
}
