package org.example;

import java.sql.SQLException;

import static org.example.ConnectDataBase.connect;

public class Main {
    public static void main(String[] args) throws SQLException {

        System.out.println(calculateBMI(new User(1, "Mara", "Oltean", Gender.M, 24, 1.64, 53, 1.5)) );
        System.out.println(caloriesNeeded(new User(1, "Mara", "Oltean", Gender.M, 24, 1.64, 53, 1.5)));

        connect();

    }
    public static double calculateBMI(User user){
        double BMI = user.getWeight()/ (user.getHeight() * user.getHeight());
        return BMI;
    }
    public static double caloriesNeeded (User user){
        double BMR = 0;
        if(user.getGender().equals(Gender.M)) {
            BMR = 88.362 + (13.397 * user.getWeight()) + (4.799 * user.getHeight() * 100) - (5.677 * user.getAge());
        }
        else{
            BMR = 447.593 + (9.247 * user.getWeight()) + (3.098 * user.getHeight() * 100) - (4.330 * user.getAge());
        }
        return BMR * user.getActivityFactor();
    }



}