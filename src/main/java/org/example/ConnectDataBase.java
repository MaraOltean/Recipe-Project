package org.example;

import java.sql.*;

import static java.awt.SystemColor.menu;
import static org.example.Main.menu;

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
        deleteData(connection, "user", 2 );
        System.out.println("After delete");
        displayDatabase(connection, "user");
        menu(connection);


        if (connection!=null){
            connection.close();
        }

}
    public static void displayDatabase(Connection conn, String tableName) throws SQLException {
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
            System.out.println("Disease name: " + rs.getString("diseaseName"));
            System.out.println("BMI: " + rs.getDouble("bmi"));
            System.out.println("Necessary number of calories: " + rs.getDouble("necessaryCalories"));
            System.out.println("Meal plan ids: " + rs.getDouble("mealPlanIDs"));
        }
    }
    public static void insertData(Connection connection, String tableName, User user) throws SQLException{
        String insertSQL = "INSERT INTO " + tableName + "(id,firstName,lastName,height,weight,gender,age,activityFactor,diseaseName,bmi,necessaryCalories,mealPlanIDs) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
        preparedStatement.setLong(1, user.getID());
        preparedStatement.setString(2, user.getFirstName());
        preparedStatement.setString(3, user.getLastName());
        preparedStatement.setDouble(4, user.getHeight());
        preparedStatement.setDouble(5, user.getWeight());
        preparedStatement.setString(6, user.getGender().name());
        preparedStatement.setInt(7, user.getAge());
        preparedStatement.setDouble(8, user.getActivityFactor());
        preparedStatement.setString(9, user.getDiseaseName());
        preparedStatement.setDouble(10, user.getBmi());
        preparedStatement.setDouble(11, user.getNecessaryCalories());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < user.getMealPlanIDs().size(); i++) {
            sb.append(user.getMealPlanIDs().get(i));
            if (i < user.getMealPlanIDs().size() - 1) {
                sb.append(",");
            }
        }
        String concatenatedValues = sb.toString();

        // Setează șirul de caractere în câmpul corespunzător
        preparedStatement.setString(12, concatenatedValues);


        preparedStatement.executeUpdate();


    }
    public static void deleteData(Connection connection, String tableName, Integer ID) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM " + tableName + " WHERE id = ?");
        preparedStatement.setLong(1, ID);

        int rowsAffected = preparedStatement.executeUpdate();
        if(rowsAffected>0){
            System.out.println("User with id = " + ID + " deleted with successfully");
        }else{
            System.out.println("The user has not been deleted");
        }

    }
}
