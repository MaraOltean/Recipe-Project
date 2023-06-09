package org.example;

import java.sql.SQLException;
import java.util.Scanner;

import static org.example.ConnectDataBase.connect;

public class Main {
    public static void main(String[] args) throws SQLException {

        System.out.println(calculateBMI(new User(1, "Mara", "Oltean", Gender.M, 24, 1.64, 53, 1.5, "Diabet")) );
        System.out.println(caloriesNeeded(new User(1, "Mara", "Oltean", Gender.M, 24, 1.64, 53, 1.5, "Diabet")));

        connect();
        User user = new User(2, "Ana" , "Pop", Gender.F, 24, 1.60, 50, 1.5, null);
        diseaseSelection(user);
        System.out.println(user.toString());

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

    public static void diseaseSelection(User user){
        System.out.println("Choose a disease: ");
        System.out.println("1.Diabetes; 2.Hypothyroidism; 3.Hyperthyroidism; 4.Atherosclerosis; 5.Hypertension");
        Scanner scanner = new Scanner(System.in);
        int diseaseNumber = scanner.nextInt();
        switch (diseaseNumber){
            case 1:
                user.setDiseaseName("Diabetes");
                break;
            case 2:
                user.setDiseaseName("Hypothyroidism");
                break;
            case 3:
                user.setDiseaseName("Hyperthyroidism");
                break;
            case 4:
                user.setDiseaseName("Atherosclerosis");
                break;
            case 5:
                user.setDiseaseName("Hypertension");
                break;
            default:
                System.out.println("Healthy User");
        }
    }


}